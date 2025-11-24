package models;

/**
 * This class is responsible for maintaining the
 * teacher's id, name, salary
 */
public class Teacher {
    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    public Teacher(int id, String name, int salary) {
        try {
            if (id <= 0) throw new IllegalArgumentException("Invalid ID");
            if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name required");
            if (salary <= 0) throw new IllegalArgumentException("Salary must be positive");

            this.id = id;
            this.name = name;
            this.salary = salary;
            this.salaryEarned = 0;

        } catch (Exception e) {
            System.out.println("Error creating teacher: " + e.getMessage());
        }
    }

    public void receiveSalary(int amount) {
        try {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
            salaryEarned += amount;
        } catch (Exception e) {
            System.out.println("Error giving salary: " + e.getMessage());
        }
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getSalaryEarned() {
        return salaryEarned;
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "', earned=" + salaryEarned + "}";
    }
}
