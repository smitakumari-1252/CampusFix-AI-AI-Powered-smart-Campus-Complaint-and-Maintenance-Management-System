package com.campusfix.controller;

import com.campusfix.model.Complaint;
import com.campusfix.service.ComplaintService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CampusController {
    private final ComplaintService service;
    public CampusController(ComplaintService service){this.service=service;}

    @GetMapping("/") public String dashboard(Model model) {
        model.addAttribute("total", service.total());
        model.addAttribute("submitted", service.countStatus("Submitted"));
        model.addAttribute("progress", service.countStatus("In Progress"));
        model.addAttribute("resolved", service.countStatus("Resolved"));
        model.addAttribute("high", service.countPriority("High"));
        model.addAttribute("complaints", service.all().stream().limit(6).toList());
        model.addAttribute("allComplaints", service.all());
        model.addAttribute("electricity", service.countCategory("Electricity"));
        model.addAttribute("wifi", service.countCategory("Wi-Fi & Network"));
        model.addAttribute("washroom", service.countCategory("Washroom"));
        model.addAttribute("classroom", service.countCategory("Classroom"));
        model.addAttribute("lab", service.countCategory("Laboratory"));
        model.addAttribute("general", service.countCategory("General Facilities"));
        return "dashboard";
    }

    @GetMapping("/complaints/new") public String newComplaint(Model model) {
        model.addAttribute("complaint", new Complaint()); return "new-complaint";
    }
    @PostMapping("/complaints") public String create(@ModelAttribute Complaint complaint, RedirectAttributes ra) {
        Complaint saved = service.create(complaint);
        ra.addFlashAttribute("success", "Complaint #" + saved.getId() + " submitted. Smart categorization completed!");
        return "redirect:/";
    }
    @GetMapping("/complaints/{id}") public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("complaint", service.get(id)); return "detail";
    }
    @PostMapping("/complaints/{id}/status") public String status(@PathVariable Long id, @RequestParam String status, RedirectAttributes ra) {
        service.updateStatus(id, status);
        ra.addFlashAttribute("success", "Complaint status updated successfully.");
        return "redirect:/complaints/" + id;
    }
}
