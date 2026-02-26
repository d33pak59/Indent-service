package com.tracemeds.indent_service.dto;


import com.tracemeds.indent_service.entity.ENUM.IndentStatus;
import com.tracemeds.indent_service.entity.IndentItems;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndentResponse {
    private String indentNumber;
    private String hospitalId;
    @Enumerated(EnumType.STRING)
    private IndentStatus status;
    private List<IndentItems> items;
}
