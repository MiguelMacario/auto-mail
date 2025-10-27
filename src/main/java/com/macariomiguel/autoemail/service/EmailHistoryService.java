package com.macariomiguel.autoemail.service;

import com.macariomiguel.autoemail.dto.EmailHistoryResponseDTO;
import com.macariomiguel.autoemail.repository.EmailHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmailHistoryService {

    private final EmailHistoryRepository emailHistoryRepository;
    public EmailHistoryService(EmailHistoryRepository emailHistoryRepository) {
        this.emailHistoryRepository = emailHistoryRepository;
    }

    public List<EmailHistoryResponseDTO> findAllEmailHistory() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return emailHistoryRepository.findAll().stream()
                .map(h -> new EmailHistoryResponseDTO(
                        h.getEmail().getEmail(),
                        h.getType().getType(),
                        h.getMessage().getText(),
                        formatter.format(h.getDate())
                ))
                .toList();
    }
}
