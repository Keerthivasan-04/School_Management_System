package models;

/**
 * This class is responsible for maintaining the student
 * id, name, grade, fees paid, total fees
 */

public class Student {
    private int id;
    private String name;
    private int grade;
    private int totalFees;
    private int feesPaid;

    public Student(int id, String name, int grade, int totalFees) {
        try {
            if (id <= 0) throw new IllegalArgumentException("Invalid ID");
            if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name required");
            if (grade <= 0) throw new IllegalArgumentException("Grade must be positive");
            if (totalFees <= 0) throw new IllegalArgumentException("Total fees must be positive");

            this.id = id;
            this.name = name;
            this.grade = grade;
            this.totalFees = totalFees;
            this.feesPaid = 0;

        } catch (Exception e) {
            System.out.println("Error creating student: " + e.getMessage());
        }
    }

    public void payFees(int amount) {
        try {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
            if (feesPaid + amount > totalFees) {
                throw new IllegalArgumentException("Payment exceeds total fees");
            }

            feesPaid += amount;

        } catch (Exception e) {
            System.out.println("Error paying fees: " + e.getMessage());
        }
    }

    public int getRemainingFees() {
        return totalFees - feesPaid;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', paid=" + feesPaid +
                ", remaining=" + getRemainingFees() + "}";
    }
}
