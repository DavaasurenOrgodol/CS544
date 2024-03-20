package edu.miu.cs.cs544.repository;

import edu.miu.common.domain.AuditData;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTests {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Member createTestMember(
            long id,
            String firstName,
            String lasName
    ){
        return new Member(
                id,
                firstName,
                lasName,
                firstName + lasName + "@gmail.com",
                String.valueOf(id),
                new HashSet<>(),
                new ArrayList<>(),
                new AuditData()
        );
    }

    @Test
    public void whenDeleteRoleRefsFromMemberRoleAndThenDelete(){
        var member1 = createTestMember(1L, "Kerim", "Amansaryyev");
        var member2 = createTestMember(2L, "Nazar", "Amanov");
        var role1 = new Role(1L, "admin", new AuditData(), new HashSet<>());
        final var role2 = new Role(2L, "student", new AuditData(), new HashSet<>());

        roleRepository.saveAll(List.of(role1, role2));

        member1.getRole().add(role1);
        member1.getRole().add(role2);
        member2.getRole().add(role2);

        memberRepository.saveAll(List.of(member1, member2));
        entityManager.flush();

        roleRepository.deleteAllRoleRefsInMemberRole(List.of(role2.getId()));
        roleRepository.deleteById(role2.getId());

        roleRepository.flush();
        entityManager.clear();

        role1 = roleRepository.findById(role1.getId()).orElseThrow();

        member1 = memberRepository.findById(member1.getId()).orElseThrow();
        member2 = memberRepository.findById(member2.getId()).orElseThrow();

        assert roleRepository.findById(role2.getId()).isEmpty() && member1.getRole().size() == 1 && member1.getRole().contains(role1)
                && member2.getRole().isEmpty();
    }
}
