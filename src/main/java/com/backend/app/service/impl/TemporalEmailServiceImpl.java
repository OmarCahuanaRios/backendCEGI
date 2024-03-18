package com.backend.app.service.impl;

import com.backend.app.dto.TemporalEmailDto;
import com.backend.app.dto.create.CreateTemporalEmailDto;
import com.backend.app.exception.ResourceNotFoundException;
import com.backend.app.model.TemporalEmail;
import com.backend.app.repository.TemporalEmailRepository;
import com.backend.app.service.TemporalEmailService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TemporalEmailServiceImpl implements TemporalEmailService {

    private final TemporalEmailRepository temporalEmailRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TemporalEmailDto> findAllTemporalEmails() {
        return temporalEmailRepository.findAll().stream()
                .map(temporalEmail -> modelMapper.map(temporalEmail, TemporalEmailDto.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TemporalEmailDto findTemporalEmailById(Integer id) {
        TemporalEmail optionalTemporalEmail = temporalEmailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TemporalEmail", "id", id));
        return modelMapper.map(optionalTemporalEmail, TemporalEmailDto.class);
    }

    @Override
    @Transactional
    public TemporalEmailDto saveTemporalEmail(CreateTemporalEmailDto temporalEmail) {
        try {
            TemporalEmail savedTemporalEmail = temporalEmailRepository.save(modelMapper.map(temporalEmail, TemporalEmail.class));
            return modelMapper.map(savedTemporalEmail, TemporalEmailDto.class);
        } catch (Exception e) {
            throw new ResourceNotFoundException("TemporalEmail", "id", temporalEmail);
        }
    }

    @Override
    @Transactional
    public TemporalEmailDto updateTemporalEmail(Integer id, CreateTemporalEmailDto temporalEmail) {
        try {
            TemporalEmail temporalEmailToUpdate = temporalEmailRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("TemporalEmail", "id", id));
            BeanUtils.copyProperties(temporalEmail, temporalEmailToUpdate, "id", "createdBy", "createdDate");
            return modelMapper.map(temporalEmailRepository.save(temporalEmailToUpdate), TemporalEmailDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ResourceNotFoundException("TemporalEmail", "id", id);
        }
    }

    @Override
    @Transactional
    public TemporalEmailDto deleteTemporalEmail(Integer id) {
        try {
            TemporalEmail temporalEmailToDelete = temporalEmailRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("TemporalEmail", "id", id));
            temporalEmailRepository.deleteById(temporalEmailToDelete.getId());
            return modelMapper.map(temporalEmailToDelete, TemporalEmailDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ResourceNotFoundException("TemporalEmail", "id", id);
        }
    }
}
