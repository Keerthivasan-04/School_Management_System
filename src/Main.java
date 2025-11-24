import management.School;
import models.Student;
import models.Teacher;

public class Main {
    public static void main(String[] args) {
            School school = new School();

            Student s1 = new Student(1, "Arun", 10, 30000);
            Student s2 = new Student(2, "Divya", 9, 25000);

            Teacher t1 = new Teacher(1, "Kiran", 8000);
            Teacher t2 = new Teacher(2, "Meena", 9000);

            school.addStudent(s1);
            school.addStudent(s2);

            school.addTeacher(t1);
            school.addTeacher(t2);

            s1.payFees(10000);
            school.updateMoneyEarned(10000);

            s2.payFees(15000);
            school.updateMoneyEarned(15000);

            school.payTeacher(t1);
            school.payTeacher(t2);

            System.out.println("School Balance: " + school.getBalance());
            System.out.println(s1);
            System.out.println(t1);
        }
}
