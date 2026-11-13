package com.campusfix.repository;

import com.campusfix.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findAllByOrderByCreatedAtDesc();
    long countByStatus(String status);
    long countByPriority(String priority);
    long countByCategory(String category);
}
