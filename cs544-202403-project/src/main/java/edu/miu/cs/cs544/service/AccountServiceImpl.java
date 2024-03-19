package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.service.contract.AccountPayload;

@Service
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> findAccountsByBalanceCondition() {
		return accountRepository.findAccountsByBalanceCondition();
	}
	
}

