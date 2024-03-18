package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.contract.EventPayload;

public interface AttendanceService extends BaseReadWriteService <AttendancePayload, Attendance, Long> {
    int calculateAttendance(long eventId);
   // List<Attendance> getMemberAttendance(long memberId);

}
