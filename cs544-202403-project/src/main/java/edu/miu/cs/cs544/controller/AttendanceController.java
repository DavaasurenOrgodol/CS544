package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.service.AttendanceService;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/attendances")
public class AttendanceController extends BaseReadWriteController<AttendancePayload, Attendance, Long> {
    @Autowired
    AttendanceService service;
    @PostMapping("/register")
    public ResponseEntity<?> attendance(@RequestBody AttendancePayload attendancePayload){
        service.attendance(attendancePayload);
        return new ResponseEntity<>(attendancePayload, HttpStatusCode.valueOf(200));
    }
//    @PostMapping("/register")
//    public ResponseEntity<?> register(){
////    receive an registerpayload request
//        Optional<Member> optionalMember = memberRepository.findById(1L);
////        Optional<Event> eventOptional = eventRepository.findById(1L);
////        Event event = eventOptional.get();
////        event.addParticipant(optionalMember.get());
//        return null;
//    }
}
