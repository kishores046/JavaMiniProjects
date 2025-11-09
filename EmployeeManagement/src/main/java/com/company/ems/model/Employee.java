package com.company.ems.model;

import jakarta.validation.constraints.*;

public class Employee {
    
    @NotNull(message = "ID cannot be null")
    private Long id;
    
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50)
    private String name;
    
    @Email(message = "Invalid email")
    private String email;
    
    @NotBlank
    private String department;
    
    @Min(value = 0, message = "Salary must be positive")
    private double baseSalary;
    
    private double bonus;
    
    // Constructors
    public Employee() {}
    
    public Employee(Long id, String name, String email, String department, double baseSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.baseSalary = baseSalary;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    
    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }
    
    public double getTotalSalary() { return baseSalary + bonus; }
    
    @Override
    public String toString() {
        return String.format("Employee[id=%d, name=%s, email=%s, dept=%s, salary=%.2f]",
                id, name, email, department, getTotalSalary());
    }
}