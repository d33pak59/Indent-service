package com.tracemeds.indent_service.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name="indent_items")
public class IndentItems {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String drugName;
   // private String drugCode; // we will not take code for now
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "indent_id")
    @JsonIgnore
    private Indent indent;
}
