package edu.miu.cs.cs544.service.contract;

import edu.miu.common.domain.AuditData;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Location;
import lombok.Data;

import java.io.Serializable;
@Data
public class ScannerPayload implements Serializable {
    private static final long serialVersionUID = 1L;
    private long scannerId;
    private String code;
    private Location location;
    private AccountType accountType;
    private Event event;

    public ScannerPayload(String code, Location location, AccountType accountType, Event event) {
        this.code = code;
        this.location = location;
        this.accountType = accountType;
        this.event = event;
    }
}
