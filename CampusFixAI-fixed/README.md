# CampusFix AI — Java Edition

AI-powered smart campus complaint and maintenance management system built with **Java 17, Spring Boot, Thymeleaf, Spring Data JPA and H2**.

## Features
- Admin dashboard with complaint KPIs and a live status doughnut chart.
- Student complaint submission form.
- Smart keyword-based complaint categorization.
- Automatic priority suggestion (High / Medium / Low).
- Automatic department routing.
- Complaint detail page and status workflow (Submitted, In Progress, Resolved, Rejected).
- Sample complaints seeded automatically for an attractive first-run dashboard.
- H2 file database by default; optional MySQL configuration included.

> Note: The classification engine is a transparent rule-based smart classifier, not a trained machine-learning model or external generative-AI service. You can replace `SmartClassifier` with an ML/API integration later.

## Requirements
- JDK 17+
- Maven 3.8+
- Internet connection on first build so Maven can download dependencies and the dashboard can load Chart.js / Google Fonts from their CDNs.

## Run locally
```bash
Open this extracted folder in VS Code, open Terminal, then run:

```bash
mvn spring-boot:run
```
```
Open **http://localhost:8080**.

The dashboard is preloaded with six demo complaints. Submit a new complaint to see the automatic category, priority and department assignment, then open it and update its status.

## Build executable JAR
```bash
mvn clean package
java -jar target/campusfix-ai-1.0.0.jar
```

## H2 database console
Open **http://localhost:8080/h2-console**
- JDBC URL: `jdbc:h2:file:./data/campusfixdb`
- User: `sa`
- Password: leave blank

## Optional MySQL
1. Create a database: `CREATE DATABASE campusfix;`
2. In `src/main/resources/application.properties`, comment out the H2 datasource settings and uncomment the MySQL settings.
3. Set your MySQL username and password.
4. Run `mvn spring-boot:run`.

## Suggested project demo video (2–3 minutes)
1. Open the dashboard and show the KPI cards, status chart and seeded complaints.
2. Click **New complaint** and submit: title `Sparking electrical socket`, location `Block C corridor`, description `The electrical socket is sparking and there is a burning smell`.
3. Return to the dashboard and show the new complaint with **Electricity**, **High** priority and **Electrical Maintenance** department.
4. Open the complaint, show the student details and AI classification, then change status to **In Progress** and save.
5. Change it to **Resolved** and return to the dashboard to show the updated chart and KPI.
6. Finish by explaining that the current smart classifier uses keyword rules and can be extended with a trained AI model.

## GitHub upload
Extract the ZIP, create a new GitHub repository named `CampusFixAI-Java`, then upload the project files (including `pom.xml`, `src/`, `.gitignore` and `README.md`). Do not upload the `target/` or local `data/` folders.


## Windows quick start
1. Install JDK 17+ and Maven 3.8+.
2. Double-click `RUN-CAMPUSFIX.bat` (or run `mvn spring-boot:run` in this folder).
3. Open http://localhost:8080 in your browser.
