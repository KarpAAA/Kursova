package FormParts;

import Data.Car;
import Data.DataBaseController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table extends JTable {
    final private String[] columnsNames = {"ID","Mark","Color","Price","Efficiency"};
    private final DataBaseController db = DataBaseController.getInstance();
    private final DefaultTableModel tableModel;

    List<Car> dataList;

    public Table(){
        super(new DefaultTableModel());
        tableModel = (DefaultTableModel) this.getModel();

        dataList = db.getDataList();

        tableModel.setDataVector(formDataToArray(dataList),columnsNames);
        this.setFocusable(false);
        this.setDefaultEditor(Object.class, null);
    }

    public List<Car> getDataList(){
        return dataList;
    }
    public List<Car> getCurrentTableData(){
        List<Car> resList = new ArrayList<>();
        var dataVector  = tableModel.getDataVector();

        for(var vector: dataVector){
            resList.add( new Car(vector.get(1).toString(),vector.get(2).toString(),Double.parseDouble((String) vector.get(3)),
                    Double.parseDouble((String) vector.get(4))));
        }

        return resList;
    }
    private static  String[] carToStringArray(Car car){
        return new String[]{
                String.valueOf(car.getId()),
                String.valueOf(car.mark()),
                String.valueOf(car.color()),
                String.valueOf(car.price()),
                String.valueOf(car.efficiency())
        };
    }
    private String[][] formDataToArray(List<Car> list){
        String[][] data = new String[list.size()][columnsNames.length];

        for(int i=0;i<list.size();++i){
            data[i] = carToStringArray(list.get(i));
        }
        return data;
    }

    public void addCarToTable(Car car){
        tableModel.addRow(carToStringArray(car));
        dataList.add(car);
        db.addCar(car);
    }
    public void deleteCarFromTable(int id){
        for(int i=0;i<tableModel.getRowCount();++i){
            if(Integer.parseInt((String)tableModel.getValueAt(i,0)) == id){
                tableModel.removeRow(i);
                break;
            }
        }
        dataList = dataList.stream().filter( car -> car.getId()!=id).collect(Collectors.toList());
        db.deleteById(id);
    }
    public void reloadData(){
        dataList = db.getDataList();
        tableModel.setDataVector(formDataToArray(dataList),columnsNames);
    }
    public void setDataToTable(List<Car> carList){
        tableModel.setDataVector(formDataToArray(carList),columnsNames);
    }

}
