package Data;

import java.util.ArrayList;
import java.util.List;

public class DataBaseController {
    private final DataBase db;
    static  DataBaseController instance;
    private DataBaseController() {
        db = DataBase.getInstance();
    }

    public List<Car> getDataList() {
        List<Car> list = db.getData();
        if (list != null) return list;
        else return new ArrayList<>();
    }

    public void addCar(Car car) {
        if (car == null) return;
        else {
            db.addCar(car);
        }
    }

    public void deleteById(int id) {
        db.removeCarById(id);
    }

    public static DataBaseController getInstance(){
        if(instance==null) instance = new DataBaseController();
        return instance;
    }

}
