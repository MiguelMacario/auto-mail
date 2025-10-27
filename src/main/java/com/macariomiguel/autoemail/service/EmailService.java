package com.macariomiguel.autoemail.service;

import com.macariomiguel.autoemail.entity.Email;
import com.macariomiguel.autoemail.repository.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email saveIfNotExist(String email) {
        boolean exists = emailRepository.findByEmail(email).isPresent();
        if (!exists) {
            emailRepository.save(new Email(email));
        }
        return emailRepository.findByEmail(email).get();
    }

}
