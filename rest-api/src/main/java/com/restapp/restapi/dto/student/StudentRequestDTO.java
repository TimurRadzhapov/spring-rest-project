package com.restapp.restapi.dto.student;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Objects;

@ApiModel(value = "StudentRequestDTO")
public class StudentRequestDTO {
    @NotBlank
    private String fullName;
    @NotBlank
    private Date dateOfBirth;

    private Long progressId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRequestDTO that = (StudentRequestDTO) o;
        return Objects.equals(fullName, that.fullName) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(progressId, that.progressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, dateOfBirth, progressId);
    }
}
