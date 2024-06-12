package org.taas_tech.student_management_system;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String URL = "jdbc:sqlite:D:/Java_task/Student_Management_System/database/students.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            createTable();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "rollnum TEXT NOT NULL, "
                + "name TEXT NOT NULL, "
                + "age INTEGER NOT NULL, "
                + "grade TEXT NOT NULL);";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(rs.getInt("id"), rs.getString("rollnum"), rs.getString("name"), rs.getInt("age"), rs.getString("grade"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static void addStudent(String rollnum, String name, int age, String grade) {
        String sql = "INSERT INTO students(rollnum, name, age, grade) VALUES(?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rollnum);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, grade);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateStudent(int id, String rollnum, String name, int age, String grade) {
        String sql = "UPDATE students SET rollnum = ?, name = ?, age = ?, grade = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rollnum);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, grade);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
