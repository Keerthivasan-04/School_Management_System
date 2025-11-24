package management;

import models.Student;
import models.Teacher;

import java.util.*;

public class School {
    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private int totalMoneyEarned;
    private int totalMoneySpent;

    public void addStudent(Student student) {
        try {
            if (student == null) throw new IllegalArgumentException("Student cannot be null");
            studentList.add(student);
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void addTeacher(Teacher teacher) {
        try {
            if (teacher == null) throw new IllegalArgumentException("Teacher cannot be null");
            teacherList.add(teacher);
        } catch (Exception e) {
            System.out.println("Error adding teacher: " + e.getMessage());
        }
    }

    public void updateMoneyEarned(int amount) {
        try {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
            totalMoneyEarned += amount;
        } catch (Exception e) {
            System.out.println("Error updating earnings: " + e.getMessage());
        }
    }

    public void payTeacher(Teacher teacher) {
        try {
            if (teacher == null) throw new IllegalArgumentException("Teacher cannot be null");

            if (getBalance() < teacher.getSalary())
                throw new IllegalArgumentException("Not enough money to pay salary");

            teacher.receiveSalary(teacher.getSalary());
            totalMoneySpent += teacher.getSalary();

        } catch (Exception e) {
            System.out.println("Error paying salary: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(studentList);
    }

    public List<Teacher> getAllTeachers() {
        return Collections.unmodifiableList(teacherList);
    }

    public int getBalance() {
        return totalMoneyEarned - totalMoneySpent;
    }
}
