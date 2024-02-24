package com.backend.app.service;

import com.backend.app.dto.VisitDto;
import com.backend.app.dto.create.VisitCreateDto;

import java.util.List;

public interface VisitService {

    List<VisitDto> findAllVisits();

    VisitDto findVisitById(Integer id);

    VisitDto createVisit(VisitCreateDto visitCreateDto);

    VisitDto updateVisit(Integer id, VisitCreateDto visitCreateDto);

    VisitDto deleteVisit(Integer id);

}
