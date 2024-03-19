package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository extends BaseRepository<Attendance, Long> {
    @Query(value = "select a from Attendance a where a.scanner.code = :code")
    List<Attendance> findAllRecordsByScannerCode(@Param("code") String code);
    @Query(value = "select a from Attendance a where a.scanner.event.id = :evtId")
    List<Attendance> findAllByEventId(@Param("evtId") String evtId);
    @Query(value = "select a from Attendance a join fetch Member m join fetch Account acc where acc.id = :accountId and to_char(date_time,'yyyy-mm-dd') between :startDate and :endDate")
    List<Attendance> findAllByAccountId(@Param("accountId") String accountId, @Param("startDate") String startDate,@Param("endDate") String endDate);
    @Query(value = "select a from Attendance a where a.member.id = :memId and a.scanner.event.id = :evtId")
    List<Attendance> findAllByMemberIdAndEventId(@Param("memId") String memId, @Param("evtId") String evtId);
    @Query(value = "select a from Attendance a where a.member.id = :memId")
    List<Attendance> findAllByMemberId(@Param("memId") String memId);
}
