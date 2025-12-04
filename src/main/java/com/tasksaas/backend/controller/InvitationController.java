package com.tasksaas.backend.controller;

import com.tasksaas.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/invite")
@CrossOrigin(origins = "*")
public class InvitationController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> sendInvite(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        try {
            emailService.sendInvitationEmail(email);
            return ResponseEntity.ok().body(Map.of("message", "Invitation sent successfully"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to send email: " + e.getMessage());
        }
    }
}
