package com.backend.app.service;

import com.backend.app.dto.VisitDto;
import com.backend.app.dto.create.VisitCreateDto;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.List;

public interface VisitService {

    List<VisitDto> findAllVisits();

    VisitDto findVisitById(Integer id);

    VisitDto createVisit(VisitCreateDto visitCreateDto) throws IOException, WriterException;

    VisitDto updateVisit(Integer id, VisitCreateDto visitCreateDto) throws IOException, WriterException;

    VisitDto deleteVisit(Integer id);

}
