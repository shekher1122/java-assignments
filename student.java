import java.util.Scanner;


// task 1 -----------


class Student {
    private int rollNumber;
    private String name;
    private String course;
    private float marks;
    private char grade;

    
    public void inputStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        rollNumber = sc.nextInt();
        sc.nextLine(); 

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
        System.out.println("\n--- Student Details ---");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.inputStudent();
        s.displayStudent();
    }
}





