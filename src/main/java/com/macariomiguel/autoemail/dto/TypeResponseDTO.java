package com.macariomiguel.autoemail.dto;

import com.macariomiguel.autoemail.entity.Type;

public record TypeResponseDTO (String name){
    public TypeResponseDTO(Type type){
        this (
                type.getType()
        );
    }
}
