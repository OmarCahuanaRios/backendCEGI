package com.backend.app.service;

import com.backend.app.dto.EnterpriseDto;
import com.backend.app.dto.create.EnterpriseCreateDto;

import java.util.List;

public interface EnterpriseService {

    List<EnterpriseDto> findAllEnterprises();

    EnterpriseDto findEnterpriseById(Integer id);

    EnterpriseDto findEnterpriseByName(String enterpriseName);

    EnterpriseDto createEnterprise(EnterpriseCreateDto enterpriseCreateDto);

    EnterpriseDto updateEnterprise(Integer id, EnterpriseCreateDto enterpriseCreateDto);

    EnterpriseDto deleteEnterprise(Integer id);

}
