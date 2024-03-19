package edu.miu.cs.cs544.service;


import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.service.contract.AccountPayload;

public interface AccountService extends BaseReadWriteService <AccountPayload, Account, Long>{
	List<Account> findAccountsByBalanceCondition();
 }
