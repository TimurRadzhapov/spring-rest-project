package com.restapp.restapi.dto.student;

import java.sql.Date;
import java.util.Objects;

public class StudentDTO {
    private String fullName;
    private Date dateOfBirth;
    private String progress;

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
        StudentDTO that = (StudentDTO) o;
        return Objects.equals(fullName, that.fullName) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(progress, that.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, dateOfBirth, progress);
    }
}
