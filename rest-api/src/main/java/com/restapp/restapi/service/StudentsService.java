package com.restapp.restapi.service;

import com.restapp.restapi.dto.student.*;

public interface StudentsService {
    GetAllStudentsResponseDTO getAllStudents();

    AddNewStudentsResponseDTO addNewStudent(StudentRequestDTO studentRequestDTO);

    EditStudentResponseDTO editStudent(Long id, StudentRequestDTO studentRequestDTO);

    DeleteStudentResponseDTO deleteStudent(Long id);
}