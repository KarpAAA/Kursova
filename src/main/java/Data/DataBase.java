package Data;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DataBase {
    final static String filename = "C:\\Users\\ivank\\IdeaProjects\\Kursova\\src\\main\\java\\Data\\data.txt";
    private static DataBase instance = null;
    private DataBase(){

    }

    public static synchronized DataBase getInstance(){
        if(instance == null) instance = new DataBase();
        return instance;
    }
    public List<Car> getData(){
        List<Car> cars = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            cars = (List<Car>) in.readObject();

            file.close();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ArrayList<Car>(cars);
    }

    public void addCar(Car car){

        try {
            List<Car> tempList = getData();
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            tempList.add(car);
            clearFile();
            out.writeObject(tempList);

            file.close();
            out.close();
        } catch (IOException e ) {
            throw new RuntimeException(e);
        }

    }
    public void removeCarById(int id){

        try {

            List<Car> newList = getData().stream().filter(car -> car.getId() != id).toList();
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            clearFile();
            out.writeObject(newList);

            file.close();
            out.close();
        } catch (IOException e ) {
            throw new RuntimeException(e);
        }

    }
    private void clearFile(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.close();
    }
}
