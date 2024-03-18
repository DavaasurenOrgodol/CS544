package edu.miu.cs.cs544.controller;


import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.SessionService;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class SessionController extends BaseReadWriteController<SessionPayload, Session, Long> {

    @Autowired
    private SessionService sessionServiceImpl;

    @GetMapping("/events/{eventId}/sessions")
    public EntityResponse<Session> getSession(@RequestPart("eventId") Long eventId){
        return null;
    }
}
