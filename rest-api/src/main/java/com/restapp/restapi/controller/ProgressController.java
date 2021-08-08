package com.restapp.restapi.controller;

import com.restapp.restapi.dto.progress.GetAllProgressResponseDTO;
import com.restapp.restapi.dto.progress.EditProgressResponseDTO;
import com.restapp.restapi.dto.progress.ProgressResponseDTO;
import com.restapp.restapi.service.ProgressService;
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
@Api(value = "ProgressRestController")
public class ProgressController {
    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping(value = "/api/progress/getAllTypeOfProgress", produces = "application/json")
    @ApiOperation(value = "Get all type of progress")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Ok", response = GetAllProgressResponseDTO.class))
    public ResponseEntity<?> getAllTypeOfProgress() {
        GetAllProgressResponseDTO getAllProgressResponseDTO = progressService.getListOfProgress();
        return new ResponseEntity<>(getAllProgressResponseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/api/progress/editProgressText/{id}", produces = "application/json")
    @ApiOperation(value = "Edit progress text")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Ok", response = EditProgressResponseDTO.class))
    public ResponseEntity<?> editProgressName(@RequestBody ProgressResponseDTO progressResponseDTO, @PathVariable Long id) {
        EditProgressResponseDTO editProgressResponseDTO = progressService.editProgressText(id, progressResponseDTO);
        return new ResponseEntity<>(editProgressResponseDTO, HttpStatus.OK);
    }
}
