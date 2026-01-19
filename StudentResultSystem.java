import java.util.Scanner;

public class StudentResultSystem {

    // Method to validate marks
    static boolean isValidMark(int mark) {
        return mark >= 0 && mark <= 100;
    }

    // Method to calculate grade
    static char calculateGrade(double percentage) {
        if (percentage >= 90) return 'A';
        else if (percentage >= 75) return 'B';
        else if (percentage >= 60) return 'C';
        else if (percentage >= 50) return 'D';
        else return 'F';
    }

    // Method to display grade description using switch
    static void gradeDescription(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("Grade: A (Excellent)");
                break;
            case 'B':
                System.out.println("Grade: B (Very Good)");
                break;
            case 'C':
                System.out.println("Grade: C (Good)");
                break;
            case 'D':
                System.out.println("Grade: D (Pass)");
                break;
            case 'F':
                System.out.println("Grade: F (Fail)");
                break;
            default:
                System.out.println("Invalid Grade");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter Student Name (or type EXIT to stop): ");
            String name = sc.next();

            if (name.equalsIgnoreCase("EXIT")) {
                break; // stop entering students
            }

            int total = 0;
            int subjects = 5;

            for (int i = 1; i <= subjects; i++) {
                System.out.print("Enter mark for subject " + i + ": ");
                int mark = sc.nextInt();

                if (!isValidMark(mark)) {
                    System.out.println("❌ Invalid mark! Enter between 0 and 100.");
                    i--;        // re-enter same subject
                    continue;   // skip remaining code
                }

                total += mark;
            }

            double percentage = total / (double) subjects;
            char grade = calculateGrade(percentage);

            System.out.println("\n----- Result Summary -----");
            System.out.println("Student Name : " + name);
            System.out.println("Total Marks  : " + total);
            System.out.println("Percentage   : " + percentage + "%");
            gradeDescription(grade);
            System.out.println("--------------------------");
        }

        sc.close();
        System.out.println("Program Ended 😊");
    }
}
