package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;

import java.util.List;
import java.util.Map;

public interface EventService extends BaseReadWriteService <EventPayload, Event, Long>{

 Map<Member, List<Attendance>> calculateAttendance(Long eventId);

}
