package edu.miu.cs.cs544.domain;

import edu.miu.common.domain.AuditData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attendance implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "member_id")
    private long memberId;
    @Column(name = "event_id")
    private long eventId;
    @Column(name = "session_id")
    private long sessionId;
    @Column(name = "account_id")
    private long accountId;
    @Column(name = "is_present")
    private boolean isPresent;
    @Embedded
    AuditData auditData = new AuditData();
}
