package com.backend.app.controller;

import com.backend.app.dto.TemporalEmailDto;
import com.backend.app.dto.create.CreateTemporalEmailDto;
import com.backend.app.service.TemporalEmailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/temporal-email")
@AllArgsConstructor
public class TemporalEmailController {

    private final TemporalEmailService temporalEmailService;

    @GetMapping
    public ResponseEntity<List<TemporalEmailDto>> getAllTemporalEmails() {
        List<TemporalEmailDto> temporalEmailList = temporalEmailService.findAllTemporalEmails();
        return new ResponseEntity<>(temporalEmailList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemporalEmailDto> getTemporalEmailById(@PathVariable Integer id) {
        TemporalEmailDto temporalEmail = temporalEmailService.findTemporalEmailById(id);
        return new ResponseEntity<>(temporalEmail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TemporalEmailDto> createTemporalEmail(@RequestBody @Valid CreateTemporalEmailDto temporalEmailDto) {
        TemporalEmailDto temporalEmail = temporalEmailService.saveTemporalEmail(temporalEmailDto);
        return new ResponseEntity<>(temporalEmail, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemporalEmailDto> updateTemporalEmail(@PathVariable Integer id, @RequestBody @Valid CreateTemporalEmailDto temporalEmailDto) {
        TemporalEmailDto temporalEmail = temporalEmailService.updateTemporalEmail(id, temporalEmailDto);
        return new ResponseEntity<>(temporalEmail, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TemporalEmailDto> deleteTemporalEmail(@PathVariable Integer id) {
        TemporalEmailDto temporalEmail = temporalEmailService.deleteTemporalEmail(id);
        return new ResponseEntity<>(temporalEmail, HttpStatus.OK);
    }

}
