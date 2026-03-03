import java.util.Scanner;

class Student {

    private String name;
    private int rollNo;
    private double marks;

    private static int totalStudents = 0;

    // Constructor with strict validation
    public Student(String name, int rollNo, double marks) {

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }

        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;

        totalStudents++;
    }

    public String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }

    public void displayDetails() {
        System.out.println("Name      : " + name);
        System.out.println("Roll No   : " + rollNo);
        System.out.println("Marks     : " + marks);
        System.out.println("Grade     : " + calculateGrade());
        System.out.println("----------------------------");
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine();

            Student[] students = new Student[n];

            for (int i = 0; i < n; i++) {

                System.out.println("\nEnter details for Student " + (i + 1));

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Roll No: ");
                int roll = sc.nextInt();

                System.out.print("Marks: ");
                double marks = sc.nextDouble();
                sc.nextLine();

                // If invalid marks → exception thrown here
                students[i] = new Student(name, roll, marks);
            }

            System.out.println("\n===== Student Details =====");

            for (Student s : students) {
                s.displayDetails();
            }

            System.out.println("Total Students Created: " + Student.getTotalStudents());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Program terminated due to invalid input.");
            System.exit(1);
        }

        sc.close();
    }
}
