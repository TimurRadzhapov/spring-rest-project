package com.restapp.restapi.dto.student;

import java.util.Objects;

public class AddNewStudentsResponseDTO {
    private String message;
    private StudentRequestDTO studentRequestDTO;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StudentRequestDTO getStudentRequestDTO() {
        return studentRequestDTO;
    }

    public void setStudentRequestDTO(StudentRequestDTO studentRequestDTO) {
        this.studentRequestDTO = studentRequestDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddNewStudentsResponseDTO that = (AddNewStudentsResponseDTO) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(studentRequestDTO, that.studentRequestDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, studentRequestDTO);
    }
}
