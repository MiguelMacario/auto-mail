package com.macariomiguel.autoemail.controller;

import com.macariomiguel.autoemail.dto.MessageRequestDTO;
import com.macariomiguel.autoemail.dto.MessageResponseDTO;
import com.macariomiguel.autoemail.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<MessageResponseDTO> getAllMessages() {
        return messageService.getMessages();
    }

}
