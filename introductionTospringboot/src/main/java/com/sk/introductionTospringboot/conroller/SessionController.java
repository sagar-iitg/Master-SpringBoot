package com.sk.introductionTospringboot.conroller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/login")
    public String login(HttpSession session) {
        // Save user ID or username to session
        session.setAttribute("userId", "sagar");
        session.setMaxInactiveInterval(30); // 30 seconds
        return "User logged in and session created.";
    }

    @GetMapping("/check")
    public String checkSession(HttpSession session) {
        String user = (String) session.getAttribute("userId");
        if (user != null) {
            return "Session is active. User: " + user + ", Session ID: " + session.getId();
        } else {
            return "No active session or session expired.";
        }
    }

    @GetMapping("/profile")
    public String getUserProfile(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId != null) {
            return "Hello, user: " + userId;
        } else {
            return "No active session. Please log in.";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "User logged out and session destroyed.";
    }
}
