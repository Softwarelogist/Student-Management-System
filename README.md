# Student Management System
# Overview
The Student Management System is a JavaFX application that allows users to manage student records. Users can add new students, update existing student information, delete students, and view a list of all students. The application uses SQLite for data storage.

# Features
Add new student records
Update existing student records
Delete student records
View a list of all students

# Prerequisites
JDK 17 or higher
Maven
SQLite JDBC Driver


# Project Structure
# nsrc/main/java/org/taas_tech/student_management_system/:
# MainApplication.java: Entry point of the application.
# MainController.java: Controller for the main student management view.
# DatabaseHandler.java: Handles database connections and operations.
# src/main/resources/org/taas_tech/student_management_system/:
# main-view.fxml: FXML file for the main student management interface.

# Classes Overview
# MainApplication.java
The main entry point of the application. It initializes the JavaFX application and loads the main view.

# MainController.java
The controller class for the main student management interface. It contains methods to handle user interactions with the interface, such as adding, updating, and deleting student records.

# DatabaseHandler.java
This class manages the connection to the SQLite database and performs CRUD operations. It includes methods for connecting to the database, creating tables, and executing SQL queries to manage student data.

# Database
The application uses SQLite to store student data. The database file is located in the database directory. The DatabaseHandler class handles all database operations, including creating the table if it doesn't exist, and executing queries to insert, update, delete, and fetch student records.

# Contributing
Feel free to fork this project and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

# License
This project is licensed under the MIT License.
