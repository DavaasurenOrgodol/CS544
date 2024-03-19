package edu.miu.cs.cs544.service;


import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.repository.SessionRepositroy;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl extends BaseReadWriteServiceImpl<SessionPayload, Session, Long> implements SessionService {

//    @Autowired
//    private SessionRepositroy sessionRepositroy;
//    public Session findById(long sessionId){
//      return  sessionRepositroy.getSessionsById(sessionId);

   // }
}
