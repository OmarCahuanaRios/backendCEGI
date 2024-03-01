package com.backend.app.service.impl;

import com.backend.app.dto.WorkerDto;
import com.backend.app.dto.create.WorkerCreateDto;
import com.backend.app.exception.DataProcessingException;
import com.backend.app.exception.ResourceNotFoundException;
import com.backend.app.model.Enterprise;
import com.backend.app.model.Worker;
import com.backend.app.repository.EnterpriseRepository;
import com.backend.app.repository.WorkerRepository;
import com.backend.app.service.WorkerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    private final EnterpriseRepository enterpriseRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<WorkerDto> findAllWorkers() {
        return workerRepository.findAll().stream()
                .map(worker -> modelMapper.map(worker, WorkerDto.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public WorkerDto findWorkerById(Integer id) {
        Worker optionalWorker = workerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Worker", "id", id));
        return modelMapper.map(optionalWorker, WorkerDto.class);
    }

    @Override
    public WorkerDto findWorkerByDni(String dni) {
        Worker optionalWorker = workerRepository.findByDocumentId(dni)
                .orElseThrow(() -> new ResourceNotFoundException("Worker", "dni", dni));
        return modelMapper.map(optionalWorker, WorkerDto.class);
    }

    @Override
    @Transactional
    public WorkerDto createWorker(WorkerCreateDto workerCreateDto) {
        try {
            Worker worker = workerRepository.save(modelMapper.map(workerCreateDto, Worker.class));
            return modelMapper.map(workerRepository.save(worker), WorkerDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error creating the worker.");
        }
    }

    @Override
    @Transactional
    public WorkerDto updateWorker(Integer id, WorkerCreateDto workerCreateDto) {
        try {
            //Enterprise enterprise = enterpriseRepository.findById(workerCreateDto.getEnterpriseId())
            // .orElseThrow(() -> new ResourceNotFoundException("Enterprise", "id", workerCreateDto.getEnterpriseId()));
            Worker optionalWorker = workerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Worker", "id", id));
            BeanUtils.copyProperties(workerCreateDto, optionalWorker, "id", "createdBy", "createdDate");
            //optionalWorker.setEnterprise(enterprise);
            return modelMapper.map(workerRepository.save(optionalWorker), WorkerDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error updating the worker with ID: " + id);
        }
    }

    @Override
    @Transactional
    public WorkerDto deleteWorker(Integer id) {
        try {
            Worker optionalWorker = workerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Worker", "id", id));
            workerRepository.deleteById(optionalWorker.getId());
            return modelMapper.map(optionalWorker, WorkerDto.class);
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error deleting the worker with ID: " + id);
        }
    }
}
