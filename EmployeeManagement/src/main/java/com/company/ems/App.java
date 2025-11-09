package com.company.ems;

import com.company.ems.config.AppConfig;
import com.company.ems.model.Employee;
import com.company.ems.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        // Create Spring container
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Get service bean
        EmployeeService service = context.getBean(EmployeeService.class);
        
        try(Scanner scanner = new Scanner(System.in)){
        	 boolean running = true;
             
             System.out.println("\n🏢 Welcome to Employee Management System\n");
             
             while (running) {
                 System.out.println("\n===== MENU =====");
                 System.out.println("1. View All Employees");
                 System.out.println("2. Add Employee");
                 System.out.println("3. Delete Employee");
                 System.out.println("4. Recalculate Bonuses");
                 System.out.println("5. Exit");
                 System.out.print("Choose option: ");
                 
                 int choice = scanner.nextInt();
                 scanner.nextLine(); // consume newline
                 
                 try {
                     switch (choice) {
                         case 1 ->{
                             System.out.println("\n📋 All Employees:");
                             service.getAllEmployees().forEach(System.out::println);
                           
                         }
                         case 2 ->{
                             System.out.print("Name: ");
                             String name = scanner.nextLine();
                             System.out.print("Email: ");
                             String email = scanner.nextLine();
                             System.out.print("Department: ");
                             String dept = scanner.nextLine();
                             System.out.print("Base Salary: ");
                             double salary = scanner.nextDouble();
                             
                             Employee emp = new Employee(null, name, email, dept, salary);
                             Employee saved = service.addEmployee(emp);
                             System.out.println("✅ Employee added: " + saved);

                         }
                         case 3 ->{
                             System.out.print("Employee ID to delete: ");
                             Long id = scanner.nextLong();
                             service.deleteEmployee(id);
                             System.out.println("✅ Employee deleted");
                             
                         }
                         case 4 ->{
                             service.recalculateBonuses();
                             System.out.println("✅ Bonuses recalculated");
                         }
                         case 5 ->{
                             running = false;
                             System.out.println("👋 Goodbye!");
                             
                         }
                         default ->System.out.println("❌ Invalid option");
                     }
                 } catch (Exception e) {
                     System.out.println("❌ Error: " + e.getMessage());
                     scanner.nextLine(); // clear buffer
                 }
             }
             
        }
        context.close(); // Trigger @PreDestroy
    }
}
