package com.codealpha.grade;

import java.util.ArrayList;

public class GradeTracker {

    private ArrayList<Student> studentList;

    // Constructor
    public GradeTracker() {
        studentList = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(String name, int marks) {
        Student newStudent = new Student(name, marks);
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
    }

    // Display all students
    public void displayStudents() {

        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n==============================");
        System.out.println("      STUDENT RECORDS");
        System.out.println("==============================");
        System.out.printf("%-20s %s%n", "Name", "Marks");
        System.out.println("------------------------------");

        for (Student student : studentList) {
            System.out.printf("%-20s %3d%n",
                    student.getName(),
                    student.getMarks());
        }
    }
    // Calculate average marks
    public double calculateAverage() {

        if (studentList.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (Student student : studentList) {
            total += student.getMarks();
        }

        return (double) total / studentList.size();
    }

    // Display student with highest marks
    public void showHighestMarks() {

        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        Student topper = studentList.get(0);

        for (Student student : studentList) {
            if (student.getMarks() > topper.getMarks()) {
                topper = student;
            }
        }

        System.out.println("\nTop Performer");
        System.out.println("Name : " + topper.getName());
        System.out.println("Marks : " + topper.getMarks());
    }

    // Display student with lowest marks
    public void showLowestMarks() {

        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        Student lowest = studentList.get(0);

        for (Student student : studentList) {
            if (student.getMarks() < lowest.getMarks()) {
                lowest = student;
            }
        }

        System.out.println("\nLowest Performer");
        System.out.println("Name : " + lowest.getName());
        System.out.println("Marks : " + lowest.getMarks());
    }
}