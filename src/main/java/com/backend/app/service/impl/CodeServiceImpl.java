package com.backend.app.service.impl;

import com.backend.app.dto.CodeDto;
import com.backend.app.dto.create.CodeCreateDto;
import com.backend.app.exception.DataProcessingException;
import com.backend.app.exception.ResourceNotFoundException;
import com.backend.app.model.Code;
import com.backend.app.repository.CodeRepository;
import com.backend.app.service.CodeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CodeDto> findAllCodes() {
        return codeRepository.findAll().stream()
                .map(code -> modelMapper.map(code, CodeDto.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CodeDto findCodeById(Integer id) {
        Code optionalCode = codeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Code", "id", id));
        return modelMapper.map(optionalCode, CodeDto.class);
    }

    @Override
    @Transactional
    public CodeDto saveCode(CodeCreateDto codeDto) {
        try {
            Code code = codeRepository.save(modelMapper.map(codeDto, Code.class));
            return modelMapper.map(code, CodeDto.class);
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error creating the code.");
        }
    }

    @Override
    @Transactional
    public CodeDto updateCode(Integer id, CodeCreateDto codeDto) {
        try {
            Code optionalCode = codeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Code", "id", id));
            BeanUtils.copyProperties(codeDto, optionalCode);
            return modelMapper.map(codeRepository.save(optionalCode), CodeDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error updating the code with ID: " + id);
        }
    }

    @Override
    @Transactional
    public CodeDto deleteCodeById(Integer id) {
        try {
            Code optionalCode = codeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Code", "id", id));
            codeRepository.deleteById(optionalCode.getId());
            return modelMapper.map(optionalCode, CodeDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error deleting the code with ID: " + id);
        }
    }
}
