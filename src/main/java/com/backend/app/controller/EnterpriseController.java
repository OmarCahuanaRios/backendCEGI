package com.backend.app.controller;

import com.backend.app.dto.EnterpriseDto;
import com.backend.app.dto.create.EnterpriseCreateDto;
import com.backend.app.service.EnterpriseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/enterprise")
@AllArgsConstructor
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    @GetMapping
    public ResponseEntity<List<EnterpriseDto>> getAllEnterprises() {
        List<EnterpriseDto> enterpriseList = enterpriseService.findAllEnterprises();
        return new ResponseEntity<>(enterpriseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterpriseDto> getEnterpriseById(@PathVariable Integer id) {
        EnterpriseDto enterprise = enterpriseService.findEnterpriseById(id);
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    @GetMapping("/name/{enterpriseName}")
    public ResponseEntity<EnterpriseDto> getEnterpriseByName(@PathVariable String enterpriseName){
        EnterpriseDto enterprise = enterpriseService.findEnterpriseByName(enterpriseName);
        return new ResponseEntity<>(enterprise,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnterpriseDto> createEnterprise(@RequestBody @Valid EnterpriseCreateDto enterpriseDto) {
        EnterpriseDto enterprise = enterpriseService.createEnterprise(enterpriseDto);
        return new ResponseEntity<>(enterprise, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterpriseDto> updateEnterprise(@PathVariable Integer id, @RequestBody @Valid EnterpriseCreateDto EnterpriseDto) {
        EnterpriseDto enterprise = enterpriseService.updateEnterprise(id, EnterpriseDto);
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnterpriseDto> deleteEnterprise(@PathVariable Integer id) {
        EnterpriseDto enterprise = enterpriseService.deleteEnterprise(id);
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

}
