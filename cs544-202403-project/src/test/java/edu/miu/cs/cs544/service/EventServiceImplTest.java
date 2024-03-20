package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Attendance;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceImplTest {

    @Mock
    private AttendanceRepository attendanceRepository;

    @InjectMocks
    private EventServiceImpl eventService;

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
