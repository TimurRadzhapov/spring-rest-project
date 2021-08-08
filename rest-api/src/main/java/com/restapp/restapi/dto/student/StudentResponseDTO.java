package com.restapp.restapi.dto.student;

import java.sql.Date;
import java.util.Objects;

public class StudentResponseDTO {
    private Long id;
    private String fullName;
    private Date dateOfBirth;
    private String progress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponseDTO that = (StudentResponseDTO) o;
        return id.equals(that.id) &&
                fullName.equals(that.fullName) &&
                dateOfBirth.equals(that.dateOfBirth) &&
                Objects.equals(progress, that.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, dateOfBirth, progress);
    }
}
