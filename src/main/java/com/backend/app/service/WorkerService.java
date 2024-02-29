package com.backend.app.service;

import com.backend.app.dto.WorkerDto;
import com.backend.app.dto.create.WorkerCreateDto;

import java.util.List;

public interface WorkerService {

    List<WorkerDto> findAllWorkers();

    WorkerDto findWorkerById(Integer id);

    WorkerDto findWorkerByDni(String dni);

    WorkerDto createWorker(WorkerCreateDto workerCreateDto);

    WorkerDto updateWorker(Integer id, WorkerCreateDto workerCreateDto);

    WorkerDto deleteWorker(Integer id);

}
