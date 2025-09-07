import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private String course;
    private float marks;
    private char grade;

    public void inputStudent(Scanner sc) {
        System.out.print("Enter Roll Number: ");
        rollNumber = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks (0-100): ");
        marks = sc.nextFloat();

        calculateGrade();
    }

    public void calculateGrade() {
        if (marks >= 90)
            grade = 'A';
        else if (marks >= 80)
            grade = 'B';
        else if (marks >= 70)
            grade = 'C';
        else if (marks >= 60)
            grade = 'D';
        else
            grade = 'F';
    }

    public void displayStudent() {
        System.out.println("Roll No: " + rollNumber + ", Name: " + name +
                           ", Course: " + course + ", Marks: " + marks +
                           ", Grade: " + grade);
    }
}

class StudentManagementSystem {
    private Student[] students;
    private int count;

    public StudentManagementSystem(int size) {
        students = new Student[size];
        count = 0;
    }

    public void addStudent(Scanner sc) {
        if (count < students.length) {
            Student s = new Student();
            s.inputStudent(sc);
            students[count++] = s;
            System.out.println("Student added successfully.\n");
        } else {
            System.out.println("Student list is full.\n");
        }
    }

    public void displayAllStudents() {
        if (count == 0) {
            System.out.println("No students to display.\n");
            return;
        }

        System.out.println("\n--- All Student Records ---");
        for (int i = 0; i < count; i++) {
            students[i].displayStudent();
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem(5); // Max 5 students

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sms.addStudent(sc);
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.\n");
            }
        }
    }
}

