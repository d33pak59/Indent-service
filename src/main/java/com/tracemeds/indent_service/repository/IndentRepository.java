package com.tracemeds.indent_service.repository;
import com.tracemeds.indent_service.entity.Indent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IndentRepository extends JpaRepository<Indent, UUID> {
    @Query(value = "SELECT nextval('indent_seq')", nativeQuery = true)
    Long getNextSequenceValue();

    Optional<Indent> findByIndentNumber(String indentNumber);
    List<Indent>findByHospitalId(String hospitalId);
}
