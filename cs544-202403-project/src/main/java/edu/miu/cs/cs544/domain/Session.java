package edu.miu.cs.cs544.domain;

import edu.miu.common.domain.AuditData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Session implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="date")
    private Date date;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    @Embedded
    AuditData auditData = new AuditData();

    public Session(LocalTime startTime, LocalTime endTime,Date date) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }
}
