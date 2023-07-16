package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    protected String name;
    protected int age;

    private List<Student> students = new ArrayList<Student>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students)
            if (student.getAverageGrade() == averageGrade)
                return student;

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = -1;
        Student result = null;

        for (Student student : students)
            if (maxAverageGrade < student.getAverageGrade()) {
                maxAverageGrade = student.getAverageGrade();
                result = student;
            }

        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        double minAverageGrade = students.get(0).getAverageGrade();
        Student result = students.get(0);

        for (Student student : students)
            if (minAverageGrade > student.getAverageGrade()) {
                minAverageGrade = student.getAverageGrade();
                result = student;
            }

        return result;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}