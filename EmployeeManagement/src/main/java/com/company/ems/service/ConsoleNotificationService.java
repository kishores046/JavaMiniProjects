package com.company.ems.service;

import com.company.ems.model.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class ConsoleNotificationService implements NotificationService {
    
    @Override
    public void sendNotification(String message, Employee employee) {
        System.out.println("📧 [CONSOLE] Notification to " + employee.getEmail() + ": " + message);
    }
}