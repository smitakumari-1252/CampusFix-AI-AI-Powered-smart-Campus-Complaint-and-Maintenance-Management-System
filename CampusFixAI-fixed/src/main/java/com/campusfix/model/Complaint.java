package com.campusfix.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Complaint {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false) private String studentName;
    @Column(nullable=false) private String studentEmail;
    @Column(nullable=false) private String location;
    @Column(nullable=false) private String title;
    @Column(nullable=false, length=2000) private String description;
    private String category;
    private String priority;
    private String department;
    private String status = "Submitted";
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public String getFormattedDate() {
        return createdAt == null ? "" : createdAt.format(DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a"));
    }
    @PreUpdate public void touch() { updatedAt = LocalDateTime.now(); }
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getStudentName(){return studentName;} public void setStudentName(String v){studentName=v;}
    public String getStudentEmail(){return studentEmail;} public void setStudentEmail(String v){studentEmail=v;}
    public String getLocation(){return location;} public void setLocation(String v){location=v;}
    public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getCategory(){return category;} public void setCategory(String v){category=v;}
    public String getPriority(){return priority;} public void setPriority(String v){priority=v;}
    public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
    public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime v){updatedAt=v;}
}
