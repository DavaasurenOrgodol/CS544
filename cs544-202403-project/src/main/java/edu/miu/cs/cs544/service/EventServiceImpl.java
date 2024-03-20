package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventServiceImpl extends BaseReadWriteServiceImpl<EventPayload, Event, Long> implements EventService {

    private final AttendanceRepository attendanceRepository;

    public EventServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Map<Member, List<Attendance>> calculateAttendance(Long eventId) {
        List<Attendance> allAttendance = attendanceRepository.findAll();
        Map<Member, List<Attendance>> attendanceMap = new HashMap<>();

        // Filter attendance records based on eventId
        for (Attendance attendance : allAttendance) {
            // Add the attendance record to the corresponding member's list
            attendanceMap.computeIfAbsent(attendance.getMember(), k -> new ArrayList<>()).add(attendance);
        }

        return attendanceMap;
    }
}




