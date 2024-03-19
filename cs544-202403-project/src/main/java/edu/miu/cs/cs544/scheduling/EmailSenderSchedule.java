package edu.miu.cs.cs544.scheduling;

import edu.miu.cs.cs544.integration.KafkaSender;
import edu.miu.cs.cs544.service.AccountService;
import edu.miu.cs.cs544.service.contract.EmailPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderSchedule {
    @Autowired
    AccountService accountService;
    @Autowired
    KafkaSender kafkaSender;
//    @Scheduled(fixedRate = 20000)
    @Scheduled(cron = "0 0 10 * * ?")
    public void welcome() {
        System.out.println("hello");
        EmailPayload payload = new EmailPayload("dorgodol@miu.edu","hello");
        kafkaSender.send("email",payload);
    }
}
