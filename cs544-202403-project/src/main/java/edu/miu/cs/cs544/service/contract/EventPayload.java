package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.AccountType;

import java.io.Serializable;

public class EventPayload implements Serializable {
    private Long id;
    private String name;
    private String description;
    private AccountType accountType;

    public EventPayload(String name, String description, AccountType accountType) {
        this.name = name;
        this.description = description;
        this.accountType = accountType;
    }
}
