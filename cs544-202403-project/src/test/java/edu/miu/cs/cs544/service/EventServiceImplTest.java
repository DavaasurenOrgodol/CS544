package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;
public class EventServiceImplTest {

    @Mock
    private AttendanceRepository attendanceRepository;

    @InjectMocks
    private EventServiceImpl eventService;
    @BeforeEach
    void setUp() {
    }

    @Test
    void testCalculateAttendance_EventNotFound() {
        // Given
        Long eventId = 1L;

        // Mocking behavior of eventRepository.findById() to return empty optional
        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());

        // When
        Map<Member, List<Attendance>> attendanceMap = eventService.calculateAttendance(eventId);

        // Then
        assertEquals(0, attendanceMap.size());
    }

    @Test
    void testCalculateAttendance_EventFound() {
        // Given
        Long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);

        Member member = new Member();
        member.setId(1L);
        event.setParticipants(List.of(member));

        Attendance attendance = new Attendance();
        attendance.setMember(member);
        List<Attendance> attendanceList = new ArrayList<>();
        attendanceList.add(attendance);

        // Mocking behavior of eventRepository.findById() and attendanceRepository.findAllByMemberId()
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));
        when(attendanceRepository.findAllByMemberId(member.getId())).thenReturn(attendanceList);

        // When
        Map<Member, List<Attendance>> attendanceMap = eventService.calculateAttendance(eventId);

        // Then
        assertEquals(1, attendanceMap.size());
    }
}
    private List<Attendance> attendanceList;

    @BeforeEach
    void setUp() {
        // Initialize the list of attendance records
        attendanceList = new ArrayList<>();

        // Create some sample attendance records
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setId(1L);
        member2.setId(2L);

        Attendance attendance1 = new Attendance(member1, null, null);
        Attendance attendance2 = new Attendance(member1, null, null);
        Attendance attendance3 = new Attendance(member2, null, null);

        attendanceList.add(attendance1);
        attendanceList.add(attendance2);
        attendanceList.add(attendance3);

        // Mock the behavior of attendanceRepository.findAll() method
        when(attendanceRepository.findAll()).thenReturn(attendanceList);
    }

    @Test
    void calculateAttendance_ReturnsCorrectAttendanceMap() {
        // Arrange
        Long eventId = 1L; // Assuming eventId
        // Act
        Map<Member, List<Attendance>> attendanceMap = eventService.calculateAttendance(eventId);
        // Assert
        // Ensure that the attendance map is not null
        assertEquals(2, attendanceMap.size()); // Assuming there are two different members in the sample attendance records
        // Add more assertions as needed based on your specific implementation
    }
}
