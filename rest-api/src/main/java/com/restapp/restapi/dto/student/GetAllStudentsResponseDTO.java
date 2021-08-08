package com.restapp.restapi.dto.student;

import java.util.List;
import java.util.Objects;

public class GetAllStudentsResponseDTO {
    private String message;
    private List<StudentResponseDTO> listOfStudents;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<StudentResponseDTO> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<StudentResponseDTO> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetAllStudentsResponseDTO that = (GetAllStudentsResponseDTO) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(listOfStudents, that.listOfStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, listOfStudents);
    }
}
