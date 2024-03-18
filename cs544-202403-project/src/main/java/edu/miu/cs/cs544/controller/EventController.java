package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.service.contract.EventPayload;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController extends BaseReadWriteController<EventPayload, Event, Long>{

//    private final AttendanceServiceImpl attendanceService;
//    public EventController(AttendanceServiceImpl attendanceService) {
//        this.attendanceService = attendanceService;
//    }
//
//    @GetMapping("/{eventId}/attendance")
//    public int getAttendance(@PathVariable long eventId) {
//        return attendanceService.calculateAttendance(eventId);
//    }
}

