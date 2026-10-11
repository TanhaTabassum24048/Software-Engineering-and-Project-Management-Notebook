public class Employee {
    int salary;

    Employee(int salary) {
        this.salary = salary;
    }

    void display(int bonus) {
        System.out.println("\nInside display() Method:");
        System.out.println("Salary (Instance Variable): " + salary);
        System.out.println("Bonus (Local Variable): " + bonus);

        class Report {
            void show() {
                System.out.println("Report: Employee salary is " + salary);
            }
        }

        Report r1 = new Report();

        System.out.println("\nReport Object Created");
        System.out.println("Report Identity Hash Code: "
                + System.identityHashCode(r1));

        r1.show();
    }
}

