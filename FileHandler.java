import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    static String file = "student.dat";

    public static ArrayList<Student> readData() {

        ArrayList<Student> list = new ArrayList<>();

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            list = (ArrayList<Student>) in.readObject();
            in.close();
        } 
        catch (FileNotFoundException e) {
            
        } 
        catch (Exception e) {
            System.out.println("Error reading file");
        }

        return list;
    }

    public static void writeData(ArrayList<Student> list) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(list);
            out.close();
        } 
        catch (Exception e) {
            System.out.println("Error writing file");
        }
    }
}