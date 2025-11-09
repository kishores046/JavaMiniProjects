package com.company.ems.event;

import com.company.ems.model.Employee;
import org.springframework.context.ApplicationEvent;

public class EmployeeEvent extends ApplicationEvent {
    
    
	private static final long serialVersionUID = 1L;
	private final Employee employee;
    private final String action; // CREATED, UPDATED, DELETED
    
    public EmployeeEvent(Object source, Employee employee, String action) {
        super(source);
        this.employee = employee;
        this.action = action;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public String getAction() {
        return action;
    }
}