package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AttendanceServiceImpl extends BaseReadWriteServiceImpl<AttendancePayload, Attendance, Long> implements AttendanceService {
    @Autowired
    ScannerRepository scannerRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    AttendanceRepository attendanceRepository;
    @Override
    public void attendance(AttendancePayload attendancePayload) throws Exception {
        Long scannerId = attendancePayload.getScanner().getId();
        String barCode = attendancePayload.getMember().getBarCode();
        Optional<Scanner> optionalScanner = scannerRepository.findById(scannerId);
        Optional<Member> optionalMember = memberRepository.findMemberByBarCode(barCode);
        if (optionalScanner.isPresent() && optionalMember.isPresent()) {
            Member member = optionalMember.get();
            Scanner scanner = optionalScanner.get();
            Event event = scanner.getEvent();
            if(event.getParticipants().contains(member)){
                AccountType accountType = scanner.getAccountType();
                Optional<Account> account = member.getAccounts()
                        .stream()
                        .filter((a)-> a.getType().equals(accountType))
                        .findFirst();
                //withdraw point from this account
                if(account.isPresent()){
                    account.get().withdraw(1);
                    Attendance attendance = new Attendance();
                    attendance.setMember(member);
                    attendance.setScanner(scanner);
                    attendance.setDateTime(LocalDateTime.now());
                    attendanceRepository.save(attendance);
                }else {
                    throw new Exception("Invalid input.");
                }
            }else{
                throw new Exception("Invalid input.");
            }
        }else {
            throw new Exception("Invalid input.");
        }
    }
}
