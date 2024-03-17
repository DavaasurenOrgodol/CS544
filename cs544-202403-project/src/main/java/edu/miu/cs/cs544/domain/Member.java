package edu.miu.cs.cs544.domain;

import edu.miu.common.domain.AuditData;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Member implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(name = "BAR_CODE",nullable = false)
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
    @Embedded
    AuditData auditData;
}
