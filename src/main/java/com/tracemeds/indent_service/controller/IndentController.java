package com.tracemeds.indent_service.controller;

import com.tracemeds.indent_service.dto.IndentRequest;
import com.tracemeds.indent_service.dto.IndentResponse;
import com.tracemeds.indent_service.entity.ENUM.IndentStatus;
import com.tracemeds.indent_service.service.IndentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/indent")
@RequiredArgsConstructor
public class IndentController {
    private final IndentService indentService;

    //Create
    @PostMapping
    public ResponseEntity<IndentResponse> createIndent(
             @RequestBody IndentRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(indentService.createIndent(request));
    }

    // Get By Id
    @GetMapping("/{indentNumber}")
    public ResponseEntity<IndentResponse> getIndent(
            @PathVariable String indentNumber) {
        return ResponseEntity.ok(indentService.getIndent(indentNumber));
    }

    // Get All Indents
    @GetMapping
    public ResponseEntity<List<IndentResponse>> getAllIndents() {
        return ResponseEntity.ok(indentService.getAllIndents());
    }

    @GetMapping("/status/{indentNumber}")
    public ResponseEntity<IndentStatus> getIndentStatus(@PathVariable String indentNumber) {
        return ResponseEntity.ok(indentService.getIndentStatus(indentNumber));
    }

//    // Update Status
//    @PatchMapping("/{id}/status")
//    public ResponseEntity<IndentResponse> updateStatus(
//            @PathVariable UUID id,
//            @RequestParam IndentStatus status) {
//
//        return ResponseEntity.ok(indentService.updateStatus(id, status));
//    }
//    // Delete
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteIndent(@PathVariable UUID id) {
//
//        indentService.deleteIndent(id);
//        return ResponseEntity.noContent().build();
//    }
//
    //  Get all the indents using HospitalId
    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<IndentResponse>> getByHospital(
            @PathVariable String hospitalId) {

        return ResponseEntity.ok(indentService.getByHospital(hospitalId));
    }
}
