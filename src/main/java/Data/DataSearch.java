package Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataSearch {
    final static String filename = "C:\\Users\\ivank\\IdeaProjects\\Kursova\\src\\main\\java\\Data\\dataSearch.txt";
    private static DataSearch instance = null;
    private DataSearch(){

    }

    public static synchronized DataSearch getInstance(){
        if(instance == null) instance = new DataSearch();
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
