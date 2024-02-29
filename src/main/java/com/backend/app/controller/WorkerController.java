package com.backend.app.controller;

import com.backend.app.dto.WorkerDto;
import com.backend.app.dto.create.WorkerCreateDto;
import com.backend.app.service.WorkerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/worker")
@AllArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<WorkerDto>> getAllWorkers() {
        List<WorkerDto> workerList = workerService.findAllWorkers();
        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDto> getWorkerById(@PathVariable Integer id) {
        WorkerDto worker = workerService.findWorkerById(id);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<WorkerDto> getWorkerByDni(@PathVariable String dni) {
        WorkerDto worker = workerService.findWorkerByDni(dni);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkerDto> createWorker(@RequestBody @Valid WorkerCreateDto workerDto) {
        WorkerDto worker = workerService.createWorker(workerDto);
        return new ResponseEntity<>(worker, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerDto> updateWorker(@PathVariable Integer id, @RequestBody @Valid WorkerCreateDto workerDto) {
        WorkerDto worker = workerService.updateWorker(id, workerDto);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkerDto> deleteWorker(@PathVariable Integer id) {
        WorkerDto worker = workerService.deleteWorker(id);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

}
