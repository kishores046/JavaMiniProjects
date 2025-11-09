package com.company.ems.service;

import com.company.ems.model.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Profile("prod")
public class FileNotificationService implements NotificationService {
    
    private static final String LOG_FILE = "notifications.log";
    
    @Override
    public void sendNotification(String message, Employee employee) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String log = String.format("[%s] Notification to %s: %s%n",
                    LocalDateTime.now(), employee.getEmail(), message);
            writer.write(log);
            System.out.println("📧 [FILE] Notification logged to " + LOG_FILE);
        } catch (IOException e) {
            System.err.println("❌ Failed to log notification: " + e.getMessage());
        }
    }
}