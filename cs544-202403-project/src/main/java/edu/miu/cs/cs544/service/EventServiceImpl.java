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

    private final EventRepository eventRepository;
    private final AttendanceRepository attendanceRepository;

    public EventServiceImpl(EventRepository eventRepository, AttendanceRepository attendanceRepository) {
        this.eventRepository = eventRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Map<Member, List<Attendance>> calculateAttendance(Long eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);

        if (event == null) {
            return new HashMap<>();
        }

        Map<Member, List<Attendance>> attendanceMap = new HashMap<>();

        for (Member member : event.getParticipants()) {
            List<Attendance> memberAttendance = attendanceRepository.findAllByMemberId(member.getId());
            attendanceMap.put(member, memberAttendance);
        }

        return attendanceMap;
    }

}



