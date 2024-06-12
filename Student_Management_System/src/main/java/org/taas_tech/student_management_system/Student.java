package org.taas_tech.student_management_system;

public class Student {
    private int id;
    private String rollnum;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String rollnum, String name, int age, String grade) {
        this.id = id;
        this.rollnum = rollnum;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getRollnum() {
        return rollnum;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRollnum(String rollnum) {
        this.rollnum = rollnum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
