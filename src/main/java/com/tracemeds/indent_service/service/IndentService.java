package com.tracemeds.indent_service.service;

import com.tracemeds.indent_service.dto.IndentRequest;
import com.tracemeds.indent_service.dto.IndentResponse;

import com.tracemeds.indent_service.entity.ENUM.IndentStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndentService {
     IndentResponse createIndent( IndentRequest request);

    IndentResponse getIndent(String indentNumber);

  List<IndentResponse> getAllIndents();

    IndentStatus getIndentStatus(String indentNumber);
//
//    IndentResponse updateStatus(UUID id, IndentStatus status);
//
//    void deleteIndent(UUID id);
//
   List<IndentResponse> getByHospital(String hospitalId);

}
