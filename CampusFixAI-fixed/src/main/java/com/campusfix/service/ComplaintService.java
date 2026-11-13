package com.campusfix.service;

import com.campusfix.model.Complaint;
import com.campusfix.repository.ComplaintRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintService {
    private final ComplaintRepository repository;
    private final SmartClassifier classifier;
    public ComplaintService(ComplaintRepository repository, SmartClassifier classifier) {
        this.repository = repository; this.classifier = classifier;
    }
    public Complaint create(Complaint complaint) {
        String combined = complaint.getTitle() + " " + complaint.getDescription();
        String category = classifier.category(combined);
        complaint.setCategory(category);
        complaint.setPriority(classifier.priority(combined));
        complaint.setDepartment(classifier.department(category));
        complaint.setStatus("Submitted");
        return repository.save(complaint);
    }
    public List<Complaint> all() { return repository.findAllByOrderByCreatedAtDesc(); }
    public Complaint get(Long id) { return repository.findById(id).orElseThrow(); }
    public Complaint updateStatus(Long id, String status) {
        if (!List.of("Submitted", "In Progress", "Resolved", "Rejected").contains(status))
            throw new IllegalArgumentException("Invalid status");
        Complaint c = get(id); c.setStatus(status); return repository.save(c);
    }
    public long total(){return repository.count();}
    public long countStatus(String s){return repository.countByStatus(s);}
    public long countPriority(String p){return repository.countByPriority(p);}
    public long countCategory(String c){return repository.countByCategory(c);}
}
