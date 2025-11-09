# Employee Management System

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java)
![Spring](https://img.shields.io/badge/Spring-6.0-green?style=for-the-badge&logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue?style=for-the-badge&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

---

## 📖 About

The **Employee Management System** is a simple Java + Spring Core application (built without Spring Boot).  
It helps you manage employees — add, view, delete, and update records — and also calculate their salaries and bonuses.

This project is designed to help **beginners understand Spring Core concepts** before moving to Spring Boot.

---

## 💡 What You’ll Learn

- How Dependency Injection works in Spring  
- Bean lifecycle and scopes  
- Using Spring Profiles (Dev/Prod)  
- Task Scheduling  
- SpEL (Spring Expression Language)  
- Event Handling  
- Property Management and Validation  

---

## ✨ Features

✅ Add, view, update, and delete employees  
✅ Calculate bonuses dynamically using SpEL  
✅ Dev/Prod profiles for environment setup  
✅ Event-based logging for employee actions  
✅ Scheduled employee reports every 30 seconds  
✅ Input validation with Hibernate Validator  
✅ Custom Bean Post Processor for lifecycle logging  

---

## Tech Stack

| Tool | Version | Use |
|------|----------|-----|
| **Java** | 17+ | Core language |
| **Spring Framework** | 6.0.11 | Dependency Injection & Core features |
| **Maven** | 3.8+ | Build and dependency management |
| **Jakarta Annotations** | 2.1.1 | Lifecycle hooks |
| **Hibernate Validator** | 8.0.0 | Bean validation |

---

## 📁 Project Structure
employee-management-system/
├── src/
│ ├── main/java/com/company/ems/
│ │ ├── App.java # Main runner
│ │ ├── config/ # Spring configuration
│ │ ├── model/ # Employee & Department classes
│ │ ├── repository/ # In-memory database
│ │ ├── service/ # Business logic
│ │ ├── event/ # Custom events
│ │ ├── scheduler/ # Scheduled reports
│ │ └── processor/ # Bean Post Processor
│ └── resources/
│ ├── application.properties
│ ├── application-dev.properties
│ └── application-prod.properties
└── pom.xml
## ⚙️ Setup Guide

### 1️⃣ Prerequisites

Make sure you have:
- Java 17+
- Maven 3.8+
- Any IDE (IntelliJ, Eclipse, STS, or VS Code)

Check versions:
java -version
mvn -version

2️⃣ Clone the Project
git clone https://github.com/kishores046/EmployeeManagement.git
cd EmployeeManagement

3️⃣ Build the Project
mvn clean install

4️⃣ Run the Application
🧑‍💻 Development Mode (Console Notifications)
mvn exec:java -Dexec.mainClass="com.company.ems.App"

🏭 Production Mode (File Logging)
mvn exec:java -Dexec.mainClass="com.company.ems.App" -Dspring.profiles.active=prod


Or run App.java directly from your IDE.

🧮 Example Console Output
🏢 Welcome to Employee Management System

1. View All Employees
2. Add Employee
3. Delete Employee
4. Recalculate Bonuses
5. Exit

Choose option: 2
Name: Charlie Davis
Email: charlie@company.com
Department: Sales
Base Salary: 55000
💰 Bonus calculated: 8250.00
✅ Employee added successfully!
📧 Notification sent: Welcome, Charlie Davis!

⚙️ Configuration Files
application.properties
spring.profiles.active=dev
app.name=Employee Management System
app.version=1.0.0

application-dev.properties
bonus.percentage=0.15
bonus.multiplier=1.5
bonus.enabled=true
logging.level=DEBUG

application-prod.properties
bonus.percentage=0.10
bonus.multiplier=1.2
bonus.enabled=true
logging.level=ERROR

🔮 Future Enhancements
Phase	Goals
🧱 Phase 1	Convert to Spring Boot + integrate MySQL
🌐 Phase 2	Add REST APIs + Department management
💻 Phase 3	Create a React frontend
🔐 Phase 4	Add Spring Security, JWT, and Docker support

🧑‍🤝‍🧑 Contributing

Want to help improve this project?
Fork it → Make your changes → Submit a Pull Request!

Guidelines:

Keep code clean and well-commented

Update README for new features

Test before committing

📬 Contact

Mail:kishore279k@gmail.com

GitHub: https://github.com/kishore046

LinkedIn: www.linkedin.com/in/kishore-s-6b299b290

💖 Thanks for Visiting!

If this project helped you understand Spring Core better, please ⭐ star the repo to support!
Learning Spring is like learning an instrument — it sounds complex at first, but with each concept, it starts to sing.
