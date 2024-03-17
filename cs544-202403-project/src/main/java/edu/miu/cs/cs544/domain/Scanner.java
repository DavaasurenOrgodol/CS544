package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scanner implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    private Location location;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "evt_id")
    private Event event;

    public Scanner(Location location, AccountType accountType, Event event) {
        this.location = location;
        this.accountType = accountType;
        this.event = event;
    }

    //    public void assignEvent(Event event){
//        this.event = event;
//    }
}
