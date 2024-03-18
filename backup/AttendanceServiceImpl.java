package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl extends BaseReadWriteServiceImpl <AttendancePayload, Attendance, Long> implements AttendanceService {
    private final AttendanceRepository attendanceRepository;


    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public int calculateAttendance(long eventId) {
        return attendanceRepository.countByEventId(eventId);
    }
//    @Override
//    public List<Attendance> getMemberAttendance(long memberId) {
//        return attendanceRepository.findByMemberId(memberId);
//    }
}
