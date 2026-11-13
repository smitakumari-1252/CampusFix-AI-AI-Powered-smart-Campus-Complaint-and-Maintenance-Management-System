package com.campusfix.config;

import com.campusfix.model.Complaint;
import com.campusfix.repository.ComplaintRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;

@Configuration
public class DataSeeder {
    @Bean CommandLineRunner seed(ComplaintRepository repo) {
        return args -> {
            if (repo.count() > 0) return;
            add(repo, "Aarav Sharma", "aarav@campus.edu", "Block A - Room 204", "Ceiling fan not working", "The ceiling fan is not working in our classroom.", "Classroom", "Medium", "Campus Facilities", "In Progress", 1);
            add(repo, "Priya Singh", "priya@campus.edu", "Library - 2nd Floor", "Wi-Fi connection unavailable", "No internet connectivity near the reading area.", "Wi-Fi & Network", "Medium", "IT Support", "Submitted", 3);
            add(repo, "Rohan Verma", "rohan@campus.edu", "Hostel Block B", "Water leakage in washroom", "There is water leaking near the washbasin.", "Washroom", "Medium", "Housekeeping & Plumbing", "Resolved", 5);
            add(repo, "Meera Das", "meera@campus.edu", "Computer Lab 3", "Computer systems not starting", "Several lab computers are not powering on.", "Laboratory", "Medium", "IT Support", "Submitted", 8);
            add(repo, "Kabir Patel", "kabir@campus.edu", "Block C - Corridor", "Sparking electrical socket", "A socket is sparking and may be dangerous.", "Electricity", "High", "Electrical Maintenance", "In Progress", 12);
            add(repo, "Ananya Roy", "ananya@campus.edu", "Admin Block", "Broken classroom chair", "One chair is broken and needs repair.", "Classroom", "Low", "Campus Facilities", "Resolved", 20);
        };
    }
    private void add(ComplaintRepository r, String n, String e, String l, String t, String d, String c, String p, String dep, String s, int days) {
        Complaint x = new Complaint(); x.setStudentName(n); x.setStudentEmail(e); x.setLocation(l);
        x.setTitle(t); x.setDescription(d); x.setCategory(c); x.setPriority(p); x.setDepartment(dep); x.setStatus(s);
        x.setCreatedAt(LocalDateTime.now().minusDays(days)); x.setUpdatedAt(x.getCreatedAt()); r.save(x);
    }
}
