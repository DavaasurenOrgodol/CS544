package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.SessionService;
import edu.miu.cs.cs544.service.contract.EventPayload;

import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController extends BaseReadWriteController<EventPayload, Event, Long> {

//    private final AttendanceServiceImpl attendanceService;
//    public EventController(AttendanceServiceImpl attendanceService) {
//        this.attendanceService = attendanceService;
//    }
//
//    @GetMapping("/{eventId}/attendance")
//    public int getAttendance(@PathVariable long eventId) {
//        return attendanceService.calculateAttendance(eventId);
//    }


    @Autowired
    SessionService sessionService;

    @PostMapping("{eventId}/sessions")
    public ResponseEntity<?> createSessionByEventId(@PathVariable long eventId, @RequestBody Session session) {
        return sessionService.createSessionByEventId(session, eventId);
    }

    @GetMapping("{eventId}/sessions")
    public ResponseEntity<?> findSessionsByEventId(@PathVariable long eventId) {
        return sessionService.findSessionsByEventId(eventId);
    }

    @PutMapping("{eventId}/sessions/{sessionId}")
    public ResponseEntity<?> UpdateSession(@PathVariable long eventId,
                                           @PathVariable long sessionId,
                                           @RequestBody SessionPayload sessionPayload)
    {
        return sessionService.updateSessionByEventIdAndSessionId(eventId,sessionId,sessionPayload);
    }

    @DeleteMapping("{eventId}/sessions/{sessionId}")
    public ResponseEntity<?> deleteSessionById(@PathVariable long eventId,
                                            @PathVariable long sessionId) {
        return sessionService.deleteSessionByEventIdAndSessionId(eventId,sessionId);
    }
}

