package com.restapp.restapi.controller;

import com.restapp.restapi.dto.progress.GetAllProgressResponseDTO;
import com.restapp.restapi.dto.progress.ProgressDTO;
import com.restapp.restapi.service.ProgressService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProgressController.class)
public class ProgressControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProgressService service;

    @Test
    public void testGetAllTypeOfProgress() throws Exception {

        String message = "Test";
        ProgressDTO progress = new ProgressDTO(1L, "Test");
        List<ProgressDTO> list = new ArrayList<>();
        list.add(progress);
        GetAllProgressResponseDTO getAllProgressResponseDTO = new GetAllProgressResponseDTO(message, list);


        Mockito.when(service.getListOfProgress()).thenReturn(getAllProgressResponseDTO);
        String url = "/v1/api/progress/getAllTypeOfProgress";
        mvc.perform(get(url).accept("application/json")).andExpect(status().isOk());
    }
}
