package com.company.ems.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmployeeEventListener {
    
    @EventListener
    public void handleEmployeeEvent(EmployeeEvent event) {
        System.out.println("🔔 EVENT: " + event.getAction() + " - " + 
                          event.getEmployee().getName() + " at " + LocalDateTime.now());
    }
}