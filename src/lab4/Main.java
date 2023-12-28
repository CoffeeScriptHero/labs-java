package lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Main class is a main class responsible for starting program (via main execution method).
 *
 */
public class Main {

    // Execution method
    public static void main(String[] args) {
        int C11 = 1309 % 11; // 0  Визначити клас студент, який складається як мінімум з 5-и полів.

        Student student1 = new Student("Denys", "Kozarenko", 20, List.of(11D, 10D, 12D, 10.6D, 11D));
        Student student2 = new Student("Joe", "Biden", 78, List.of(2.6D, 5D, 3.2D, 4D, 5.4D));
        Student student3 = new Student("Ernest", "Protas", 24, List.of(8.5D, 10D, 9.7D, 11D, 9D));
        Student student4 = new Student("Emmanuel", "Macron", 44, List.of(7D, 12D, 10.2D, 9.4D, 4D));
        Student student5 = new Student("John", "Doe", 30, List.of(2D, 11D, 9.5D, 8.3D, 6.9D));
        Student[] students = {student1, student2, student3, student4, student5};

        // Comparators that based on comparing student's average grade
        Comparator<Student> averageGradeAscending  = Comparator.comparing(Student::getAverageGrade);
        Comparator<Student> averageGradeDescending = Comparator.comparing(Student::getAverageGrade).reversed();

        System.out.println("Students sorted by average grade (ascending): ");
        printStudents(getSortedStudentsArray(students, averageGradeAscending));

        System.out.println("Students sorted by average grade (descending): ");
        printStudents(getSortedStudentsArray(students, averageGradeDescending));

        System.out.println("Students sorted by age (ascending): ");
        printStudents(getSortedStudentsArray(students, Comparator.comparing(Student::getAge)));

        System.out.println("Students sorted by age (descending): ");
        printStudents(getSortedStudentsArray(students, Comparator.comparing(Student::getAge).reversed()));
    }

    // Method that returns sorted students array (it uses provided comparator for sorting)
    private static Student[] getSortedStudentsArray(Student[] students, Comparator<Student> comparator) {
        return Arrays.stream(students).sorted(comparator).toArray(Student[]::new);
    }

    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("\t" + student);
        }
        System.out.println();
    }
}
