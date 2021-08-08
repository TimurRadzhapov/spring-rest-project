package com.restapp.restapi.service;

import com.restapp.restapi.dto.progress.GetAllProgressResponseDTO;
import com.restapp.restapi.dto.progress.EditProgressResponseDTO;
import com.restapp.restapi.dto.progress.ProgressResponseDTO;

public interface ProgressService {
    GetAllProgressResponseDTO getListOfProgress();

    EditProgressResponseDTO editProgressText(Long id, ProgressResponseDTO progressResponseDTO);
}
