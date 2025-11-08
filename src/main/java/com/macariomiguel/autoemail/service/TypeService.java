package com.macariomiguel.autoemail.service;

import com.macariomiguel.autoemail.dto.TypeRequestDTO;
import com.macariomiguel.autoemail.dto.TypeResponseDTO;
import com.macariomiguel.autoemail.entity.Type;
import com.macariomiguel.autoemail.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {

    private final TypeRepository typeRepository;
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public void createType(TypeRequestDTO data) {
        typeRepository.save(new Type(data.name()));
    }

    public List<TypeResponseDTO> findAllTypes() {
        return typeRepository.findAll().stream().map(TypeResponseDTO::new).collect(Collectors.toList());
    }

}
