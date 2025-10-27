package com.macariomiguel.autoemail.service;

import com.macariomiguel.autoemail.dto.MessageRequestDTO;
import com.macariomiguel.autoemail.entity.Message;
import com.macariomiguel.autoemail.entity.Type;
import com.macariomiguel.autoemail.repository.MessageRepository;
import com.macariomiguel.autoemail.repository.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final TypeRepository typeRepository;

    public MessageService(MessageRepository messageRepository, TypeRepository typeRepository) {
        this.messageRepository = messageRepository;
        this.typeRepository = typeRepository;
    }

    public void createMessage(MessageRequestDTO data) {
        Type t = typeRepository.findById(data.type()).orElse(null);
        messageRepository.save(new Message(data.text(), data.version(), t));
    }
}
