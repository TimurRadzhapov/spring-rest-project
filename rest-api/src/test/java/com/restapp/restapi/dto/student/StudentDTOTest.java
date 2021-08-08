package com.restapp.restapi.dto.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class StudentDTO ")
public class StudentDTOTest {
    @Test
    void shoulHaveb(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFullName("A");
        assertEquals("A", studentDTO.getFullName());

    }
}
