package com.restapp.restapi.dto.progress;

import java.util.List;
import java.util.Objects;

public class GetAllProgressResponseDTO {
    private String message;
    private List<ProgressDTO> progressDTOS;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProgressDTO> getProgressDTOS() {
        return progressDTOS;
    }

    public void setProgressDTOS(List<ProgressDTO> progressDTOS) {
        this.progressDTOS = progressDTOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetAllProgressResponseDTO that = (GetAllProgressResponseDTO) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(progressDTOS, that.progressDTOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, progressDTOS);
    }
}
