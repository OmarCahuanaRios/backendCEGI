package com.backend.app.service.impl;

import com.backend.app.dto.VisitDto;
import com.backend.app.dto.WorkerDto;
import com.backend.app.dto.create.VisitCreateDto;
import com.backend.app.exception.DataProcessingException;
import com.backend.app.exception.ResourceNotFoundException;
import com.backend.app.model.Visit;
import com.backend.app.model.Visitant;
import com.backend.app.model.Worker;
import com.backend.app.repository.VisitRepository;
import com.backend.app.repository.VisitantRepository;
import com.backend.app.repository.WorkerRepository;
import com.backend.app.service.VisitService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    private final WorkerRepository workerRepository;

    private final VisitantRepository visitantRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<VisitDto> findAllVisits() {
        return visitRepository.findAll().stream()
                .map(visit -> modelMapper.map(visit, VisitDto.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public VisitDto findVisitById(Integer id) {
        Visit optionalVisit = visitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visit", "id", id));
        return modelMapper.map(optionalVisit, VisitDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VisitDto> findAllVisitsByEnterprise(String enterpriseName){


        List<Visit> visits = visitRepository.findAllByVisitant_EnterpriseEnterpriseName(enterpriseName);
        if (visits == null || visits.isEmpty()) {
            throw new ResourceNotFoundException("Visits", "enterpriseName", enterpriseName);
        }
        return visits.stream()
                .map(visit -> modelMapper.map(visit, VisitDto.class))
                .toList();
    }

    @Override
    @Transactional
    public VisitDto createVisit(VisitCreateDto visitCreateDto) throws IOException, WriterException {
        try {
            Visitant visitant = null;
            if (visitCreateDto.getVisitantId() != null) {
                Optional<Visitant> optionalVisitant = visitantRepository.findById(visitCreateDto.getVisitantId());
                visitant = optionalVisitant.orElseThrow(() -> new ResourceNotFoundException("Visitant", "id", visitCreateDto.getVisitantId()));
            }
            Visit visit = new Visit();
            BeanUtils.copyProperties(visitCreateDto, visit);
            visit.setApprobationDate(null);
            visit.setVisitant(visitant);
            return modelMapper.map(visitRepository.save(visit), VisitDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error creating the visit.");
        }
    }

    @Override
    @Transactional
    public VisitDto updateVisit(Integer id, VisitCreateDto visitCreateDto) throws IOException, WriterException {
        try {
            Visitant visitant = null;
            if (visitCreateDto.getVisitantId() != null) {
                Optional<Visitant> optionalVisitant = visitantRepository.findById(visitCreateDto.getVisitantId());
                visitant = optionalVisitant.orElseThrow(() -> new ResourceNotFoundException("Visitant", "id", visitCreateDto.getVisitantId()));
            }
            Visit optionalVisit = visitRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Visit", "id", id));
            BeanUtils.copyProperties(visitCreateDto, optionalVisit, "id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate");
            optionalVisit.setVisitant(visitant);
            return modelMapper.map(visitRepository.save(optionalVisit), VisitDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error updating the visit with ID: " + id);
        }
    }

    @Override
    @Transactional
    public VisitDto deleteVisit(Integer id) {
        try {
            Visit optionalVisit = visitRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Visit", "id", id));
            visitRepository.deleteById(optionalVisit.getId());
            return modelMapper.map(optionalVisit, VisitDto.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            //Throw a custom exception
            throw new DataProcessingException("Error deleting the visit with ID: " + id);
        }
    }

    private String generateQrCode(String text, int width, int height) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "png", outputStream);
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}
