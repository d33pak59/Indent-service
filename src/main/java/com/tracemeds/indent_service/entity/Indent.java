package com.tracemeds.indent_service.entity;
import com.tracemeds.indent_service.entity.ENUM.IndentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "indent")
public class Indent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String indentNumber;
    @Column(nullable = false)
    private String hospitalId;
    @Enumerated(EnumType.STRING)
    private IndentStatus status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "indent", cascade = CascadeType.ALL)
    private List<IndentItems> items=new ArrayList<>();


}
