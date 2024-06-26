package com.backend.app.service;

import com.backend.app.dto.CodeDto;
import com.backend.app.dto.create.CodeCreateDto;

import java.util.List;

public interface CodeService {

    List<CodeDto> findAllCodes();

    CodeDto findCodeById(Integer id);

    List<CodeDto> findAllCodeByVisitantId(Integer visitantId);

    CodeDto saveCode(CodeCreateDto codeDto);

    CodeDto updateCode(Integer id);

    CodeDto deleteCodeById(Integer id);
}
