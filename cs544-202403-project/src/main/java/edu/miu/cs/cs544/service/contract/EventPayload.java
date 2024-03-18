package edu.miu.cs.cs544.service.contract;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import edu.miu.cs.cs544.domain.AccountType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EventPayload implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String description;
    private AccountType accountType;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public EventPayload(String name, String description, AccountType accountType, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.name = name;
        this.description = description;
        this.accountType = accountType;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
