package edu.miu.cs.cs544.service.contract;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

public class SessionPayload implements Serializable {
    private long Id;
    private Date date;

    private LocalTime startTime;

    private LocalTime endTime;
}
