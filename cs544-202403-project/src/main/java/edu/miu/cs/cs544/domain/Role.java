package edu.miu.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Set<Account> accounts = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }
    public void addAccount(Account account){
        accounts.add(account);
    }
}
