package com.sha.messageboardreact;

import com.sha.messageboardreact.payloads.MessageDto;
import com.sha.messageboardreact.service.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DbLoad implements CommandLineRunner {

    private final MessageService messageService;

    public DbLoad(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void run(String... args) throws Exception {
        messageService.save(new MessageDto("One@gmail.com", "aaaaaaa aasdf ", new Date()));
        messageService.save(new MessageDto("two@gmail.com", "bbbbb bbbb ", new Date()));
        messageService.save(new MessageDto("three@gmail.com", "ccccc ccccc ", new Date()));
        messageService.save(new MessageDto("four@gmail.com", "ddddd ddddd ", new Date()));
        messageService.save(new MessageDto("five@gmail.com", "eeee eeee ", new Date()));
        messageService.save(new MessageDto("six@gmail.com", "fffff fffff ", new Date()));
    }
}
