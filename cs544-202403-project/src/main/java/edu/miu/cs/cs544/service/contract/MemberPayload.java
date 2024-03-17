package edu.miu.cs.cs544.service.contract;

import edu.miu.common.domain.AuditData;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class MemberPayload implements Serializable {

    public static final long serialVersionUID = 1L;

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String barCode;

    private Set<Role> role;

    private List<Account> accounts;

    private AuditData auditData;

}
