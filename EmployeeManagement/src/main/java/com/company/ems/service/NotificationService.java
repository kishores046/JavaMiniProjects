package com.company.ems.service;

import com.company.ems.model.Employee;

public interface NotificationService {
    void sendNotification(String message, Employee employee);
}