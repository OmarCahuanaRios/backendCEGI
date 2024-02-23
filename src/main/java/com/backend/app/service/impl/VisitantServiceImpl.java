package com.backend.app.service.impl;

import com.backend.app.dto.VisitantDto;
import com.backend.app.dto.create.VisitantCreateDto;
import com.backend.app.exception.DataProcessingException;
import com.backend.app.exception.ResourceNotFoundException;
import com.backend.app.model.Visitant;
import com.backend.app.repository.VisitantRepository;
import com.backend.app.service.VisitantService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VisitantServiceImpl implements VisitantService {

    private final VisitantRepository visitantRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<VisitantDto> findAllVisitants() {
        return visitantRepository.findAll().stream()
                .map(visitant -> modelMapper.map(visitant, VisitantDto.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public VisitantDto findVisitantById(Integer id) {
        Visitant optionalVisitant = visitantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitant", "id", id));
        return modelMapper.map(optionalVisitant, VisitantDto.class);
    }

    @Override
    @Transactional
    public VisitantDto createVisitant(VisitantCreateDto VisitantCreateDto) {
        try {
            Visitant visitant = visitantRepository.save(modelMapper.map(VisitantCreateDto, Visitant.class));
            return modelMapper.map(visitant, VisitantDto.class);
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error creating the visitant.");
        }
    }

    @Override
    @Transactional
    public VisitantDto updateVisitant(Integer id, VisitantCreateDto VisitantCreateDto) {
        try {
            Visitant optionalVisitant = visitantRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Visitant", "id", id));
            BeanUtils.copyProperties(VisitantCreateDto, optionalVisitant, "id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate");
            return modelMapper.map(visitantRepository.save(optionalVisitant), VisitantDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error updating the visitant with ID: " + id);
        }
    }

    @Override
    @Transactional
    public VisitantDto deleteVisitant(Integer id) {
        try {
            Visitant optionalVisitant = visitantRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Visitant", "id", id));
            visitantRepository.deleteById(optionalVisitant.getId());
            return modelMapper.map(optionalVisitant, VisitantDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error deleting the visitant with ID: " + id);
        }
    }
}
