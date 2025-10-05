import java.util.Scanner;


class Student {
    int rollno;
    String name;
    String course;
    int marks;

    void addstudent(Scanner sc) {
        System.out.println("add rollno : ");
        rollno = sc.nextInt();
        System.out.println("enter name : ");
        name = sc.nextLine();
        System.out.println("enter cource : ");
        course = sc.nextLine();
        System.out.println("enter marks : ");
        marks = sc.nextInt();

    }
    void displaydetails() {
        System.out.println("name = " + name);
        System.out.println("rollno = " + rollno);
        System.out.println("course = " + course);
        System.out.println("marks = " + marks);
    }



}

public class labassignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        int choice;

        do{
            System.out.println("--menu--");
            System.out.println("1. input student details");
            System.out.println("2. display student details ");
            System.out.println("3. exit");
            System.out.println("enter your choice ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    student.addstudent(sc);
                    break;

                case 2:
                    student.displaydetails();
                    break;

                case 3:
                    System.out.println("exiting program ");
                    break;
            
                default:
                    break;
            }
        } while(choice !=3);

        sc.close();

        
    }

    
}
