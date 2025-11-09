package com.company.ems.service;

import com.company.ems.event.EmployeeEvent;
import com.company.ems.model.Employee;
import com.company.ems.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated // Enable validation
public class EmployeeService {
    
    private final EmployeeRepository repository;
    private final SalaryCalculator salaryCalculator;
    private final NotificationService notificationService;
    private final ApplicationEventPublisher eventPublisher;
    
    // Constructor injection (preferred)
    @Autowired
    public EmployeeService(EmployeeRepository repository,
                          SalaryCalculator salaryCalculator,
                          NotificationService notificationService,
                          ApplicationEventPublisher eventPublisher) {
        this.repository = repository;
        this.salaryCalculator = salaryCalculator;
        this.notificationService = notificationService;
        this.eventPublisher = eventPublisher;
    }
    
    public Employee addEmployee(@Valid Employee employee) {
        salaryCalculator.calculateBonus(employee);
        Employee saved = repository.save(employee);
        
        // Publish event
        eventPublisher.publishEvent(new EmployeeEvent(this, saved, "CREATED"));
        
        // Send notification
        notificationService.sendNotification("Welcome to the company!", saved);
        
        return saved;
    }
    
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
    
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));
    }
    
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        repository.deleteById(id);
        
        // Publish event
        eventPublisher.publishEvent(new EmployeeEvent(this, employee, "DELETED"));
        
        // Send notification
        notificationService.sendNotification("Goodbye from the company", employee);
    }
    
    public void recalculateBonuses() {
        List<Employee> employees = repository.findAll();
        salaryCalculator.calculateBonusForAll(employees);
    }
}