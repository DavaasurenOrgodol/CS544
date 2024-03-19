package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.EventService;
import edu.miu.cs.cs544.service.contract.EventPayload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventController extends BaseReadWriteController<EventPayload, Event, Long>{

    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

@GetMapping("/{eventId}/attendance")
public ResponseEntity<Map<Member, List<Attendance>>> calculateAttendance(@PathVariable Long eventId) {
    Map<Member, List<Attendance>> attendanceMap = eventService.calculateAttendance(eventId);
    return ResponseEntity.ok(attendanceMap);
}
}


