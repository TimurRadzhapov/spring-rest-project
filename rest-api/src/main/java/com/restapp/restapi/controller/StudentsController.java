package com.restapp.restapi.controller;

import com.restapp.restapi.dto.student.*;
import com.restapp.restapi.service.StudentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(value = {"/v1"})
@Api(value = "StudentRestController")
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping(value = "/api/students/getAllStudents", produces = "application/json")
    @ApiOperation(value = "Get all students")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Ok", response = GetAllStudentsResponseDTO.class))
    public ResponseEntity<?> getAllStudents() {
        GetAllStudentsResponseDTO getAllStudentsResponseDTO = studentsService.getAllStudents();
        return new ResponseEntity<>(getAllStudentsResponseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/students/addNewStudent", produces = "application/json")
    @ApiOperation(value = "Add new student")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Ok", response = StudentDTO.class))
    public ResponseEntity<?> addNewStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        AddNewStudentsResponseDTO addNewStudentsResponseDTO = studentsService.addNewStudent(studentRequestDTO);
        return new ResponseEntity<>(addNewStudentsResponseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/api/students/editStudent/{id}", produces = "application/json")
    @ApiOperation(value = "Edit student")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Ok", response = StudentDTO.class))
    public ResponseEntity<?> editStudent(@RequestBody StudentRequestDTO studentRequestDTO, @PathVariable Long id) {
        EditStudentResponseDTO editStudentResponseDTO = studentsService.editStudent(id, studentRequestDTO);
        return new ResponseEntity<>(editStudentResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/students/deleteStudent/{id}", produces = "application/json")
    @ApiOperation(value = "Delete student")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Ok", response = DeleteStudentResponseDTO.class))
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        DeleteStudentResponseDTO deleteStudentResponseDTO = studentsService.deleteStudent(id);
        return new ResponseEntity<>(deleteStudentResponseDTO, HttpStatus.OK);
    }
}
