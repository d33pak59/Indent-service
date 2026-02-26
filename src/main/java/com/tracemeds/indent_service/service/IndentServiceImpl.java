package com.tracemeds.indent_service.service;

import com.tracemeds.indent_service.dto.IndentRequest;
import com.tracemeds.indent_service.dto.IndentResponse;
import com.tracemeds.indent_service.entity.ENUM.IndentStatus;
import com.tracemeds.indent_service.entity.Indent;
import com.tracemeds.indent_service.entity.IndentItems;
import com.tracemeds.indent_service.repository.IndentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@RequiredArgsConstructor
@Service
public class IndentServiceImpl implements IndentService {
    private final IndentRepository indentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public IndentResponse createIndent(IndentRequest request) {
        // yaha indent bana rhe hai




        Long nextVal = indentRepository.getNextSequenceValue();
        String customIndentNumber = "IND-2026-" + String.format("%03d", nextVal);
        Indent savedIndent=Indent.builder()
                .indentNumber(customIndentNumber)
                .hospitalId(request.getHospitalId())
                .status(IndentStatus.CREATED)
                .build();
        // yaha list bana rhe hai items ka
        List<IndentItems> items = request.getItems().stream()
                .map(itemRequest -> {
                    IndentItems item = IndentItems.builder()
                            .itemName(itemRequest.getItemName())
                            .quantity(itemRequest.getQuantity())
                            .build();

                    item.setIndent(savedIndent); // iss line se indent_id set hoga .
                    return item;
                })
                .toList();

        savedIndent.setItems(items);
        indentRepository.save(savedIndent)  ;
        return IndentResponse.builder()
                .hospitalId(savedIndent.getHospitalId())
                .indentNumber(savedIndent.getIndentNumber())
                .status(savedIndent.getStatus())
                .items(savedIndent.getItems())
                .build();
    }

    @Override
    public IndentResponse getIndent(String  indentNumber) {

        Indent indent = indentRepository
                .findByIndentNumber(indentNumber)
                .orElseThrow(() -> new RuntimeException("Indent not found"));
        IndentResponse indentResponse = modelMapper.map(indent, IndentResponse.class);
        return  indentResponse;
    }

    @Override
    public List<IndentResponse> getAllIndents() {
      return indentRepository.findAll().stream().map(indent->modelMapper.map(indent,IndentResponse.class)).toList();
    }

    @Override
    public IndentStatus getIndentStatus(String indentNumber) {
        Indent indent=indentRepository.findByIndentNumber(indentNumber).orElseThrow(()->new RuntimeException("Indent not found"));

        return indent.getStatus();
    }

    //
//    @Override
//    public IndentResponse updateStatus(UUID id, IndentStatus status) {
//        return null;
//    }
//
//    @Override
//    public void deleteIndent(UUID id) {
//
//    }
//
    @Override
    public List<IndentResponse> getByHospital(String hospitalId) {
              List<Indent> indents = indentRepository.findByHospitalId(hospitalId);
              return indents.stream()
                      .map(indent -> modelMapper.map(indent, IndentResponse.class))
                      .toList();
    }


}
