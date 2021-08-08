package com.restapp.restapi.dto.progress;

import java.util.Objects;

public class EditProgressResponseDTO {
    private String message;
    private ProgressDTO progressDTO;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProgressDTO getProgressDTO() {
        return progressDTO;
    }

    public void setProgressDTO(ProgressDTO progressDTO) {
        this.progressDTO = progressDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditProgressResponseDTO that = (EditProgressResponseDTO) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(progressDTO, that.progressDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, progressDTO);
    }
}
