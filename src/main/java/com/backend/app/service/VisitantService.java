package com.backend.app.service;

import com.backend.app.dto.VisitantDto;
import com.backend.app.dto.create.VisitantCreateDto;

import java.util.List;

public interface VisitantService {

    List<VisitantDto> findAllVisitants();

    VisitantDto findVisitantById(Integer id);

    VisitantDto createVisitant(VisitantCreateDto VisitantCreateDto);

    VisitantDto updateVisitant(Integer id, VisitantCreateDto VisitantCreateDto);

    VisitantDto deleteVisitant(Integer id);

}
