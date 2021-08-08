package com.restapp.restapi.service.impl;

import com.restapp.restapi.dto.progress.GetAllProgressResponseDTO;
import com.restapp.restapi.dto.progress.ProgressDTO;
import com.restapp.restapi.dto.progress.EditProgressResponseDTO;
import com.restapp.restapi.dto.progress.ProgressResponseDTO;
import com.restapp.restapi.model.Progress;
import com.restapp.restapi.repository.ProgressRepository;
import com.restapp.restapi.service.ProgressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgressServiceImpl implements ProgressService {
    private final ProgressRepository progressRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }


    @Override
    public GetAllProgressResponseDTO getListOfProgress() {
        List<Progress> progressList = progressRepository.findAll();
        List<ProgressDTO> res = progressList.stream().map(progress -> {
            ProgressDTO progressDTO = new ProgressDTO();
            progressDTO.setId(progress.getId());
            progressDTO.setText(progress.getText());
            return progressDTO;
        }).collect(Collectors.toList());

        GetAllProgressResponseDTO getAllProgressResponseDTO = new GetAllProgressResponseDTO();

        if (res.size() > 0) {
            getAllProgressResponseDTO.setMessage("Successfully.");
        } else {
            getAllProgressResponseDTO.setMessage("No any progress records");
        }
        getAllProgressResponseDTO.setProgressDTOS(res);
        return getAllProgressResponseDTO;
    }

    @Override
    public EditProgressResponseDTO editProgressText(Long id, ProgressResponseDTO progressResponseDTO) {
        Optional<Progress> progress = progressRepository.findById(id);
        ProgressDTO progressDTO = new ProgressDTO();
        EditProgressResponseDTO editProgressResponseDTO = new EditProgressResponseDTO();
        if (progress.isPresent()) {
            if (progressResponseDTO.getText() != null) {
                progress.get().setText(progressResponseDTO.getText());
                progressRepository.save(progress.get());
                progressDTO.setId(progress.get().getId());
                progressDTO.setText(progressResponseDTO.getText());
                editProgressResponseDTO.setMessage("Student edited successfully");
                editProgressResponseDTO.setProgressDTO(progressDTO);
            } else {
                editProgressResponseDTO.setMessage("New text field is missing");
            }
        } else {
            editProgressResponseDTO.setMessage("Progress name with this id - not found");
        }
        return editProgressResponseDTO;
    }
}


