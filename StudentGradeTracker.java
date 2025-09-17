import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> marks;

    Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    void addMark(int mark) {
        marks.add(mark);
    }

    double getAverage() {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    int getHighest() {
        int highest = Integer.MIN_VALUE;
        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }

    int getLowest() {
        int lowest = Integer.MAX_VALUE;
        for (int mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        return lowest;
    }

    void displayReport() {
        System.out.println("==================================");
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.printf("Average: %.2f\n", getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("==================================");
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Welcome to Student Grade Tracker!");
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of subjects for " + name + ": ");
            int numSubjects = sc.nextInt();

            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter mark for subject " + (j + 1) + ": ");
                int mark = sc.nextInt();
                student.addMark(mark);
            }
            sc.nextLine(); // consume newline
            students.add(student);
        }

        // Display Summary Report
        System.out.println("\n======= Student Summary Report =======");
        for (Student s : students) {
            s.displayReport();
        }

        sc.close();
    }
}
