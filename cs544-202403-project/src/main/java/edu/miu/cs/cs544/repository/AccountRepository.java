package edu.miu.cs.cs544.repository;

import org.springframework.stereotype.Repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Account;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {

}
