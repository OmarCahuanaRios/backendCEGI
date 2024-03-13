package com.backend.app.controller;

import com.backend.app.dto.CodeDto;
import com.backend.app.dto.create.CodeCreateDto;
import com.backend.app.service.CodeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/code")
@AllArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @GetMapping
    public ResponseEntity<List<CodeDto>> findAllCodes() {
        List<CodeDto> codeList = codeService.findAllCodes();
        return new ResponseEntity<>(codeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodeDto> findCodeById(@PathVariable Integer id) {
        CodeDto code = codeService.findCodeById(id);
        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CodeDto> createCode(@RequestBody @Valid CodeCreateDto codeDto) {
        CodeDto code = codeService.saveCode(codeDto);
        return new ResponseEntity<>(code, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodeDto> updateCode(@PathVariable Integer id) {
        CodeDto codeDto = codeService.updateCode(id);
        return new ResponseEntity<>(codeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CodeDto> deleteCode(@PathVariable Integer id) {
        CodeDto codeDto = codeService.deleteCodeById(id);
        return new ResponseEntity<>(codeDto, HttpStatus.OK);
    }
}
