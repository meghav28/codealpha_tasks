package com.codealpha.grade;

import java.util.Scanner;
/*
 * Project: Student Grade Tracker
 * Internship: CodeAlpha Java Programming
 * Developed by: Megha Vashishth
 *
 * Description:
 * A console-based Java application to manage student grades.
 * Features include adding students, displaying records,
 * calculating average marks, finding highest and lowest scores.
 */

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        int choice;

        do {

            System.out.println("\n========== STUDENT GRADE TRACKER ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Show Average Marks");
            System.out.println("4. Show Highest Marks");
            System.out.println("5. Show Lowest Marks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    int marks;

                    while (true) {

                        System.out.print("Enter Marks (0-100): ");
                        marks = sc.nextInt();

                        if (marks >= 0 && marks <= 100) {
                            break;
                        }

                        System.out.println("Invalid Marks! Please enter between 0 and 100.");
                    }

                    tracker.addStudent(name, marks);
                    break;

                case 2:
                    tracker.displayStudents();
                    break;

                case 3:
                    System.out.printf("Average Marks : %.2f%n",
                            tracker.calculateAverage());
                    break;

                case 4:
                    tracker.showHighestMarks();
                    break;

                case 5:
                    tracker.showLowestMarks();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}