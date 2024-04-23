package org.example;

import java.util.Scanner;


public class StudentGradeCalculator {
    public static void main(String[] args) {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();
        String grade = studentGradeCalculator.calculateStudentMarks();
        if (grade == null && grade.isEmpty()){
            return;
        }
        System.out.println("Grade: " +grade);
    }

    public String calculateStudentMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Validate number of subjects
        if (numSubjects <= 0) {
            System.out.println("Invalid number of subjects.");
            return null;
        }

        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scanner.nextInt();

            // Validate marks
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered.");
                return null;
            }

            totalMarks += marks;
        }
        System.out.println("Total Marks: " +totalMarks);
        double averagePercentage = (double) totalMarks / numSubjects;
        System.out.println("Average Percentage: " +averagePercentage);
        String grade = calculateGrade(averagePercentage);

        scanner.close();
        return grade;
    }

    private static String calculateGrade(double averagePercentage) {
        int score = (int) averagePercentage / 10;
        String grade;
        switch (score) {
            case 10:
            case 9:
                grade = "O";
                break;
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "B";
                break;
            case 6:
                grade = "C";
                break;
            case 5:
                grade = "D";
                break;
            default:
                grade = "F";
                break;
        }
        return grade;
    }
}