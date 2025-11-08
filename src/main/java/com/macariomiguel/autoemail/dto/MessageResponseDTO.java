package com.macariomiguel.autoemail.dto;

import com.macariomiguel.autoemail.entity.Message;

public record MessageResponseDTO(String text, Integer version, String type) {
    public MessageResponseDTO(Message message){
        this (
                message.getText(),
                message.getVersion(),
                message.getType().getType()
        );

    }
}
