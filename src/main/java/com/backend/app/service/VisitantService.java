package com.backend.app.service;

import com.backend.app.dto.VisitantDto;
import com.backend.app.dto.WorkerDto;
import com.backend.app.dto.create.VisitantCreateDto;

import java.util.List;

public interface VisitantService {

    List<VisitantDto> findAllVisitants();

    VisitantDto findVisitantById(Integer id);

    VisitantDto findVisitantByDocument(String dni);

    VisitantDto createVisitant(VisitantCreateDto visitantCreateDto);

    VisitantDto updateVisitant(Integer id, VisitantCreateDto visitantCreateDto);

    List<VisitantDto> findAllVisitantsByEnterprise(String enterpriseName);

    VisitantDto deleteVisitant(Integer id);

}
