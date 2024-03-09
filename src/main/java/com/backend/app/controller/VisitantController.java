package com.backend.app.controller;

import com.backend.app.dto.VisitDto;
import com.backend.app.dto.VisitantDto;
import com.backend.app.dto.create.VisitantCreateDto;
import com.backend.app.service.VisitantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/visitant")
@AllArgsConstructor
public class VisitantController {

    private final VisitantService visitantService;

    @GetMapping
    public ResponseEntity<List<VisitantDto>> getAllVisitants() {
        List<VisitantDto> visitantList = visitantService.findAllVisitants();
        return new ResponseEntity<>(visitantList, HttpStatus.OK);
    }

    @GetMapping("/enterprise/{enterpriseName}")
    public ResponseEntity<List<VisitantDto>> getAllVisitsByEnterprise(@PathVariable String enterpriseName){
        List<VisitantDto> visitantList = visitantService.findAllVisitantsByEnterprise(enterpriseName);
        return new ResponseEntity<>(visitantList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitantDto> getVisitantById(@PathVariable Integer id) {
        VisitantDto visitant = visitantService.findVisitantById(id);
        return new ResponseEntity<>(visitant, HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<VisitantDto> getVisitantByDocument(@PathVariable String dni) {
        VisitantDto visitant = visitantService.findVisitantByDocument(dni);
        return new ResponseEntity<>(visitant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VisitantDto> createVisitant(@RequestBody @Valid VisitantCreateDto visitantDto) {
        VisitantDto visitant = visitantService.createVisitant(visitantDto);
        return new ResponseEntity<>(visitant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitantDto> updateVisitant(@PathVariable Integer id, @RequestBody @Valid VisitantCreateDto visitantDto) {
        VisitantDto visitant = visitantService.updateVisitant(id, visitantDto);
        return new ResponseEntity<>(visitant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VisitantDto> deleteVisitant(@PathVariable Integer id) {
        VisitantDto visitant = visitantService.deleteVisitant(id);
        return new ResponseEntity<>(visitant, HttpStatus.OK);
    }
}
