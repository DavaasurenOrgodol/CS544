package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
//    @Autowired
//    ScannerRepository scannerRepository;
//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    AttendanceRepository attendanceRepository;
//    @GetMapping("/register")
//    public ResponseEntity<?> register(){
//        Optional<Scanner> optionalScanner = scannerRepository.findById(1L);
//        //findByBarCode
//        Optional<Member> optionalMember = memberRepository.findById(1L);
//        if(optionalScanner.isPresent() && optionalMember.isPresent()){
//            Member member = optionalMember.get();
//            Scanner scanner = optionalScanner.get();
//            Event event = scanner.getEvent();
//            if(event.getParticipants().contains(member)){
//                //
//                AccountType accountType = scanner.getAccountType();
//                Optional<Account> account = member.getAccounts()
//                        .stream()
//                        .filter((a)-> a.getType().equals(accountType))
//                        .findFirst();
//                //withdraw point from this account
//                //account.withdraw();
//                Attendance attendance = new Attendance();
//                attendance.setMember(member);
//                attendance.setScanner(scanner);
//                attendanceRepository.save(attendance);
//            }
//        }
//
//        return null;
//    }
}
