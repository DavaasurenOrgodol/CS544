package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    @Lob
    private String barCode;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "member_role",
    joinColumns = {@JoinColumn(name = "member_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> role = new HashSet<>();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private List<Account> accounts = new ArrayList<>();

    public Member(String firstName, String lastName, String email, String barCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.barCode = barCode;
    }
    public void addAccount(Account account){
        accounts.add(account);
    }
    public void addRole(Role role){
       this.role.add(role);
    }
}
