package com.macariomiguel.autoemail.controller;

import com.macariomiguel.autoemail.dto.TypeRequestDTO;
import com.macariomiguel.autoemail.dto.TypeResponseDTO;
import com.macariomiguel.autoemail.service.TypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public ResponseEntity<Void> createType(@RequestBody TypeRequestDTO data){
        typeService.createType(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<TypeResponseDTO> findAllTypes(){
        return typeService.findAllTypes();
    }
}
