package com.backend.app.controller;

import com.backend.app.dto.VisitDto;
import com.backend.app.dto.create.VisitCreateDto;
import com.backend.app.service.VisitService;
import com.google.zxing.WriterException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/visit")
@AllArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping
    public ResponseEntity<List<VisitDto>> findAllVisits() {
        List<VisitDto> visitList = visitService.findAllVisits();
        return new ResponseEntity<>(visitList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDto> findVisitById(@PathVariable Integer id) {
        VisitDto visit = visitService.findVisitById(id);
        return new ResponseEntity<>(visit, HttpStatus.OK);
    }

    @GetMapping("/enterprise/{enterpriseName}")
    public ResponseEntity<List<VisitDto>> getAllVisitsByEnterprise(@PathVariable String enterpriseName){
        List<VisitDto> visitList = visitService.findAllVisitsByEnterprise(enterpriseName);
        return new ResponseEntity<>(visitList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VisitDto> createVisit(@RequestBody @Valid VisitCreateDto visitCreateDto) throws IOException, WriterException {
        VisitDto visitDto = visitService.createVisit(visitCreateDto);
        return new ResponseEntity<>(visitDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitDto> updateVisit(@PathVariable Integer id, @RequestBody @Valid VisitCreateDto visitCreateDto) throws IOException, WriterException {
        VisitDto visitDto = visitService.updateVisit(id, visitCreateDto);
        return new ResponseEntity<>(visitDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VisitDto> deleteVisit(@PathVariable Integer id) {
        VisitDto visitDto = visitService.deleteVisit(id);
        return new ResponseEntity<>(visitDto, HttpStatus.OK);
    }

}
