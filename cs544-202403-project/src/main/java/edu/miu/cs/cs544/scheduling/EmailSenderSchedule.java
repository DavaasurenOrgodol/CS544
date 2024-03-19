package edu.miu.cs.cs544.scheduling;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.integration.KafkaSender;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.AccountService;
import edu.miu.cs.cs544.service.contract.EmailPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailSenderSchedule {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    KafkaSender kafkaSender;
//    @Scheduled(fixedRate = 20000)
    @Scheduled(cron = "0 0 10 * * ?")
    public void welcome() {
        System.out.println("hello");
//        List<Account> accounts = accountRepository.findAccountsByBalanceCondition();
//        for(Account account: accounts){
////            Member member = memberRepository.Member
//            EmailPayload payload = new EmailPayload("dorgodol@miu.edu","hello");
//            kafkaSender.send("email",payload);
//        }
    }
}
