public class MainStudent {
    public static void main(String[] args) {
        Student s1 = new Student();

        System.out.println("Student Object Created");
        System.out.println("Object Identity Hash Code: "
                + System.identityHashCode(s1));

        s1.display();
    }
}