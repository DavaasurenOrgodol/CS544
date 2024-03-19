package edu.miu.cs.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Attendance;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
    @Query(value = "select a from Account a where currentValue < defaultValue*0.05")
    List<Account> findAccountsByBalanceCondition();
}
