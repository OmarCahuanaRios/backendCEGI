package com.backend.app.service;

import com.backend.app.dto.TemporalEmailDto;
import com.backend.app.dto.create.CreateTemporalEmailDto;

import java.util.List;

public interface TemporalEmailService {

    List<TemporalEmailDto> findAllTemporalEmails();

    TemporalEmailDto findTemporalEmailById(Integer id);

    TemporalEmailDto saveTemporalEmail(CreateTemporalEmailDto temporalEmail);

    TemporalEmailDto updateTemporalEmail(Integer id, CreateTemporalEmailDto temporalEmail);

    TemporalEmailDto deleteTemporalEmail(Integer id);

}
