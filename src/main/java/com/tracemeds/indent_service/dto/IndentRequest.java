package com.tracemeds.indent_service.dto;
import com.tracemeds.indent_service.entity.ENUM.IndentStatus;
import com.tracemeds.indent_service.entity.IndentItems;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndentRequest {
    private String indentNumber;
    @Column(nullable = false)
    private String hospitalId;
    private List<IndentItems> items;
}
