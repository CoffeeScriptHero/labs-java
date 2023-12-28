package lab4;

import java.util.List;

/**
 *
 * The Student class is a model of real-life student.
 * It contains both personal information about student (such as first name, last name, age)
 * and information about student's grades for semester, and it's average grade.
 * <br/><br/>
 * This class has only one constructor, it accepts personal information and List of semester grades.
 * <br/><br/>
 * There are also getters for all fields, and one private method calculateAverageGrade that stands for calculating
 * student's average grade.
 *
 */
public class Student {

    private final String firstName;
    private final String lastName;

    private int age;
    private List<Double> semesterGrades;
    private double averageGrade;

    // Constructor. Accepts personal information and List<Double> of grades for semester
    public Student(String firstName, String lastName, int age, List<Double> semesterGrades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.semesterGrades = semesterGrades;
        this.averageGrade = calculateAverageGrade();
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<Double> getSemesterGrades() {
        return semesterGrades;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    // Method to calculate average grade of student based on its semester grades
    // Grades must be in range from 2 (inclusive) to 12 (inclusive)
    private double calculateAverageGrade() {
        if (semesterGrades == null || semesterGrades.isEmpty()) {
            return 0;
        }
        return semesterGrades.stream()
            .filter(grade -> grade >= 2 && grade <= 12)
            .reduce(0D, Double::sum) / semesterGrades.size();
    }

    // Override toString method to display student in string format
    @Override
    public String toString() {
        return String.format("Student %s %s, age: %d, average grade: %.2f", firstName, lastName, age, averageGrade);
    }
}
