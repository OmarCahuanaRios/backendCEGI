package com.backend.app.service.impl;

import com.backend.app.dto.EnterpriseDto;
import com.backend.app.dto.create.EnterpriseCreateDto;
import com.backend.app.exception.DataProcessingException;
import com.backend.app.exception.ResourceNotFoundException;
import com.backend.app.model.Enterprise;
import com.backend.app.repository.EnterpriseRepository;
import com.backend.app.service.EnterpriseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EnterpriseDto> findAllEnterprises() {
        return enterpriseRepository.findAll().stream()
                .map(enterprise -> modelMapper.map(enterprise, EnterpriseDto.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EnterpriseDto findEnterpriseById(Integer id) {
        Enterprise optionalEnterprise = enterpriseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("enterprise", "id", id));
        return modelMapper.map(optionalEnterprise, EnterpriseDto.class);
    }

    @Override
    @Transactional
    public EnterpriseDto createEnterprise(EnterpriseCreateDto enterpriseCreateDto) {
        try {
            Enterprise enterprise = enterpriseRepository.save(modelMapper.map(enterpriseCreateDto, Enterprise.class));
            return modelMapper.map(enterprise, EnterpriseDto.class);
        } catch (Exception e) {
            // Throw a custom exception
            throw new DataProcessingException("Error creating the enterprise.");
        }
    }

    @Override
    @Transactional
    public EnterpriseDto updateEnterprise(Integer id, EnterpriseCreateDto enterpriseCreateDto) {
        try {
            Enterprise optionalEnterprise = enterpriseRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Enterprise", "id", id));

            BeanUtils.copyProperties(enterpriseCreateDto, optionalEnterprise, "id", "createdBy", "createdDate");
            return modelMapper.map(enterpriseRepository.save(optionalEnterprise), EnterpriseDto.class);
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error updating the enterprise with ID: " + id);
        }
    }

    @Override
    @Transactional
    public EnterpriseDto deleteEnterprise(Integer id) {
        try {
            Enterprise optionalEnterprise = enterpriseRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Enterprise", "id", id));

            //enterpriseRepository.deleteById(optionalEnterprise.getId());
            return modelMapper.map(optionalEnterprise, EnterpriseDto.class);
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error deleting the enterprise with ID: " + id);
        }
    }
}
