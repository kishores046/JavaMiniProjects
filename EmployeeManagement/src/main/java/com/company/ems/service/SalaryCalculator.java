package com.company.ems.service;

import com.company.ems.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaryCalculator {
    
 
    @Value("#{T(java.lang.Double).parseDouble('${bonus.percentage:0.1}')}")
    private double bonusPercentage;
    
  
    @Value("#{${bonus.enabled:true} ? T(java.lang.Double).parseDouble('${bonus.multiplier:1.5}') : 1.0}")
    private double bonusMultiplier;
    
    
    public void calculateBonus(Employee employee) {
        double bonus = employee.getBaseSalary() * bonusPercentage * bonusMultiplier;
        employee.setBonus(bonus);
        System.out.println("💰 Calculated bonus for " + employee.getName() + ": $" + bonus);
    }
    
    public void calculateBonusForAll(List<Employee> employees) {
        employees.forEach(this::calculateBonus);
    }
}