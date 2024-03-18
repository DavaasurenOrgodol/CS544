package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Attendance;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends BaseRepository<Attendance, Long> {
}
