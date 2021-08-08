package com.restapp.restapi.service.impl;

import com.restapp.restapi.dto.student.*;
import com.restapp.restapi.model.Student;
import com.restapp.restapi.model.StudentResponse;
import com.restapp.restapi.repository.StudentResponseRepository;
import com.restapp.restapi.repository.StudentsRepository;
import com.restapp.restapi.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;
    private final StudentResponseRepository studentResponseRepository;

    public StudentServiceImpl(StudentsRepository studentsRepository, StudentResponseRepository studentResponseRepository) {
        this.studentsRepository = studentsRepository;
        this.studentResponseRepository = studentResponseRepository;
    }

    @Override
    public GetAllStudentsResponseDTO getAllStudents() {
        List<StudentResponse> students = studentResponseRepository.getAllStudents();

        List<StudentResponseDTO> res = students.stream().map(student -> {
            StudentResponseDTO studentDTO = new StudentResponseDTO();
            studentDTO.setId(student.getId());
            studentDTO.setFullName(student.getFullName());
            studentDTO.setDateOfBirth(student.getDateOfBirth());
            studentDTO.setProgress(student.getProgress() != null ? student.getProgress() : "no progress yet");
            return studentDTO;
        }).collect(Collectors.toList());

        GetAllStudentsResponseDTO getAllStudentsResponseDTO = new GetAllStudentsResponseDTO();
        if (res.size() > 0) {
            getAllStudentsResponseDTO.setMessage("Successfully.");
        } else {
            getAllStudentsResponseDTO.setMessage("No any students found.");
        }
        getAllStudentsResponseDTO.setListOfStudents(res);
        return getAllStudentsResponseDTO;
    }

    @Override
    public AddNewStudentsResponseDTO addNewStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        AddNewStudentsResponseDTO addNewStudentsResponseDTO = new AddNewStudentsResponseDTO();
        if (studentRequestDTO.getFullName() != null && studentRequestDTO.getDateOfBirth() != null) {
            student.setFull_name(studentRequestDTO.getFullName());
            student.setDateOfBirth(studentRequestDTO.getDateOfBirth());
            student.setProgress_id(studentRequestDTO.getProgressId());
            studentsRepository.save(student);
            addNewStudentsResponseDTO.setMessage("Student added successfully");
        } else {
            addNewStudentsResponseDTO.setMessage("Some required fields are missing");
        }

        addNewStudentsResponseDTO.setStudentRequestDTO(studentRequestDTO);
        return addNewStudentsResponseDTO;
    }

    @Override
    public EditStudentResponseDTO editStudent(Long id, StudentRequestDTO studentRequestDTO) {
        Optional<Student> student = studentsRepository.findById(id);
        EditStudentResponseDTO editStudentResponseDTO = new EditStudentResponseDTO();
        StudentRequestDTO requestDTO = new StudentRequestDTO();
        if (student.isPresent()) {
            if (studentRequestDTO.getFullName() != null && studentRequestDTO.getDateOfBirth() != null) {
                student.get().setFull_name(studentRequestDTO.getFullName());
                student.get().setDateOfBirth(studentRequestDTO.getDateOfBirth());
                requestDTO.setFullName(studentRequestDTO.getFullName());
                requestDTO.setDateOfBirth(studentRequestDTO.getDateOfBirth());
                if (studentRequestDTO.getProgressId() != null) {
                    if (studentRequestDTO.getProgressId() > 1 && studentRequestDTO.getProgressId() < 6) {
                        student.get().setProgress_id(studentRequestDTO.getProgressId());
                        requestDTO.setProgressId(studentRequestDTO.getProgressId());
                        studentsRepository.save(student.get());
                        editStudentResponseDTO.setMessage("Student edited successfully");
                    } else {
                        requestDTO.setProgressId(studentRequestDTO.getProgressId());
                        editStudentResponseDTO.setMessage("Incorrect progress id.");
                    }
                } else {
                    studentsRepository.save(student.get());
                    editStudentResponseDTO.setMessage("Student edited successfully");
                }
            } else {
                editStudentResponseDTO.setMessage("Some required fields are missing");
            }
        } else {
            editStudentResponseDTO.setMessage("Student not found");
        }
        editStudentResponseDTO.setStudentRequestDTO(requestDTO);
        return editStudentResponseDTO;
    }

    @Override
    public DeleteStudentResponseDTO deleteStudent(Long id) {
        DeleteStudentResponseDTO deleteStudentResponseDTO = new DeleteStudentResponseDTO();
        Optional<Student> student = studentsRepository.findById(id);
        if (student.isPresent()) {
            studentsRepository.delete(student.get());
            deleteStudentResponseDTO.setMessage("Student deleted successfully");
        } else {
            deleteStudentResponseDTO.setMessage("Student not found");
        }
        return deleteStudentResponseDTO;
    }
}
