import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");
        int salary = sc.nextInt();

        System.out.print("Enter bonus: ");
        int bonus = sc.nextInt();

        Employee e1 = new Employee(salary);

        System.out.println("\nEmployee Object Created");
        System.out.println("Employee Identity Hash Code: "
                + System.identityHashCode(e1));

        e1.display(bonus);

        sc.close();
    }
}
