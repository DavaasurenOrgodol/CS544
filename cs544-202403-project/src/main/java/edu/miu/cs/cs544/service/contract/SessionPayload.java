package edu.miu.cs.cs544.service.contract;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;
@Data
public class SessionPayload implements Serializable {
    private static final long serialVersionUID = 1L;
    private long Id;
    private Date date;
    private LocalTime endTime;

    private LocalTime startTime;

    public SessionPayload(Date date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
