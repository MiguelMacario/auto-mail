package com.macariomiguel.autoemail.service;

import com.macariomiguel.autoemail.dto.EmailSenderRequestDTO;
import com.macariomiguel.autoemail.entity.Email;
import com.macariomiguel.autoemail.entity.EmailHistory;
import com.macariomiguel.autoemail.entity.Message;
import com.macariomiguel.autoemail.entity.Type;
import com.macariomiguel.autoemail.exceptions.MessageNotFoundEcxeption;
import com.macariomiguel.autoemail.repository.EmailHistoryRepository;
import com.macariomiguel.autoemail.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;
    private final EmailService emailService;
    private final MessageRepository messageRepository;
    private final EmailHistoryRepository emailHistoryRepository;

    public EmailSenderService(JavaMailSender javaMailSender, EmailService emailService
            ,MessageRepository messageRepository, EmailHistoryRepository emailHistoryRepository) {
        this.javaMailSender = javaMailSender;
        this.emailService = emailService;
        this.messageRepository = messageRepository;
        this.emailHistoryRepository = emailHistoryRepository;
    }

    public void sendEmail(EmailSenderRequestDTO data) {
        Email email = emailService.saveIfNotExist(data.email());
        Message message = messageRepository.findById(data.messageId()).orElseThrow(() -> new MessageNotFoundEcxeption("Message not found"));
        Type type = message.getType();
        EmailHistory emailHistory = new EmailHistory(email, message, type);
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(email.getEmail());
            mailMessage.setSubject(type.getType());
            mailMessage.setText(message.getText());
            javaMailSender.send(mailMessage);
            emailHistoryRepository.save(emailHistory);
        } catch (Exception e) {
            System.out.println("Email sending failed" + e.getMessage());
        }
    }
}
