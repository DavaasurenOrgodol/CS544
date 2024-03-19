package edu.miu.cs.cs544.controller;


import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.SessionService;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class SessionController extends BaseReadWriteController<SessionPayload, Session, Long> {

    @Autowired
    private SessionService sessionServiceImpl;

//    @GetMapping("/events/{eventId}/sessions")
//    public EntityResponse<Session> getSession(@RequestPart("eventId") Long eventId){
//        return null;
//    }
//


    @GetMapping("/events/{eventId}/sessions")
        public ResponseEntity<SessionPayload> getSession(@PathVariable Long sessionId) {
            SessionPayload session = sessionServiceImpl.findById(sessionId);
            if (session != null) {
                return ResponseEntity.ok().body(session);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        @GetMapping("check")
        public  void check(){
        System.out.println("checked");
        }

}
