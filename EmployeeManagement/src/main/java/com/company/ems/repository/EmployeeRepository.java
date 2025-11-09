package com.company.ems.repository;

import com.company.ems.model.Employee;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Scope("singleton") // Demonstrate scope
public class EmployeeRepository {
    
    private final Map<Long, Employee> employees = new ConcurrentHashMap<>();
    private Long idCounter = 1L;
    
    @PostConstruct
    public void init() {
        System.out.println("📦 EmployeeRepository initialized - Loading seed data...");
        // Seed data
        save(new Employee(null, "Alice Johnson", "alice@company.com", "Engineering", 80000));
        save(new Employee(null, "Bob Smith", "bob@company.com", "Marketing", 60000));
        save(new Employee(null, "Charlie Brown", "charlie@company.com", "Sales", 55000));
    }
    
    @PreDestroy
    public void cleanup() {
        System.out.println("🗑️ EmployeeRepository shutting down - Cleaning up resources...");
        employees.clear();
    }
    
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idCounter++);
        }
        employees.put(employee.getId(), employee);
        return employee;
    }
    
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employees.get(id));
    }
    
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }
    
    public List<Employee> findByDepartment(String department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
    
    public void deleteById(Long id) {
        employees.remove(id);
    }
    
    public long count() {
        return employees.size();
    }
}