package com.tasksaas.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendInvitationEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ss2727303@gmail.com");
        message.setTo(toEmail);
        message.setSubject("You're invited to join TaskFlow AI!");
        message.setText(
                "Hello,\n\nYou have been invited to join the TaskFlow AI workspace. Collaborate on tasks, manage projects, and boost your productivity.\n\nLog in now to get started!\n\nBest regards,\nThe TaskFlow Team");

        mailSender.send(message);
    }
}
