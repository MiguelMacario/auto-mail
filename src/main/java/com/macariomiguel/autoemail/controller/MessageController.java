package com.macariomiguel.autoemail.controller;

import com.macariomiguel.autoemail.dto.MessageRequestDTO;
import com.macariomiguel.autoemail.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Void> createMessage(@RequestBody MessageRequestDTO data) {
        messageService.createMessage(data);
        return ResponseEntity.ok().build();
    }

}
