package com.macariomiguel.autoemail.controller;

import com.macariomiguel.autoemail.dto.EmailSenderRequestDTO;
import com.macariomiguel.autoemail.service.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emailSender")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<Void> sendEmail(@RequestBody EmailSenderRequestDTO data) {
        emailSenderService.sendEmail(data);
        return ResponseEntity.ok().build();
    }

}
