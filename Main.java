import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int ch;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 Add");
            System.out.println("2 View");
            System.out.println("3 Search");
            System.out.println("4 Update");
            System.out.println("5 Delete");
            System.out.println("6 Exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            if (ch == 1) {
                add();
            } 
            else if (ch == 2) {
                view();
            } 
            else if (ch == 3) {
                search();
            } 
            else if (ch == 4) {
                update();
            } 
            else if (ch == 5) {
                delete();
            }

        } while (ch != 6);

        System.out.println("Exited!!!");
    }

    // add
    static void add() {

        ArrayList<Student> list = FileHandler.readData();

        System.out.print("Enter id: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println("ID already there");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        if(marks<0 || marks>100) {
            System.out.println("Invalid marks");
            return;
        }
        if(name.trim().isEmpty()) {
            System.out.println("Invalid name");
            return;
        }

        Student s = new Student(id, name, marks);
        list.add(s);

        FileHandler.writeData(list);

        System.out.println("Added");
    }

    // VIEW
    static void view() {

        ArrayList<Student> list = FileHandler.readData();

        if (list.size() == 0) {
            System.out.println("No data");
            return;
        }

        for (Student s : list) {
            System.out.println(s);
        }
    }

    // SEARCH
    static void search() {

        ArrayList<Student> list = FileHandler.readData();

        System.out.print("Enter id: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println("Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Not found");
    }

    // UPDATE
    static void update() {

        ArrayList<Student> list = FileHandler.readData();

        System.out.print("Enter id: ");
        int id = sc.nextInt();

        for (Student s : list) {

            if (s.getId() == id) {

                sc.nextLine();

                System.out.print("New name: ");
                String name = sc.nextLine();

                System.out.print("New marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);

                FileHandler.writeData(list);

                System.out.println("Updated");
                return;
            }
        }

        System.out.println("ID not found");
    }

    // DELETE
    static void delete() {

        ArrayList<Student> list = FileHandler.readData();

        System.out.print("Enter id: ");
        int id = sc.nextInt();

        Iterator<Student> it = list.iterator();

        while (it.hasNext()) {
            Student s = it.next();

            if (s.getId() == id) {
                it.remove();
                FileHandler.writeData(list);
                System.out.println("Deleted");
                return;
            }
        }

        System.out.println("ID not found");
    }
}