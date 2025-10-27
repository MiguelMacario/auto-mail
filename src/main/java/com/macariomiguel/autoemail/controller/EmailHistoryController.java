package com.macariomiguel.autoemail.controller;

import com.macariomiguel.autoemail.dto.EmailHistoryResponseDTO;
import com.macariomiguel.autoemail.service.EmailHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class EmailHistoryController {

    private final EmailHistoryService emailHistoryService;

    public EmailHistoryController(EmailHistoryService emailHistoryService) {
        this.emailHistoryService = emailHistoryService;
    }

    @GetMapping
    public List<EmailHistoryResponseDTO> getEmailHistory(){
        return emailHistoryService.findAllEmailHistory();
    }
}
