package Dialogs;

import Data.Car;
import Data.DataSearch;
import Utilities.Validator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class AddDialog extends JDialog {
    JTextField tModel = new JTextField();
    JTextField tColor = new JTextField();
    JTextField tPrice = new JTextField();
    JTextField tEfficiency = new JTextField();
    JComboBox<String> comboBoxSearch = new JComboBox<>();

    enum EnteringField {
        MODEL, PRICE, EFFICIENCY, COLOR, NONE
    }

    private EnteringField field = EnteringField.NONE;

    public AddDialog(Color mainColor, ClickListener cl) {
        super();

        this.setTitle("Adding new element");
        this.setLayout(null);
        this.setSize(new Dimension(310, 380));
        this.setBackground(Color.WHITE);
        this.setLocation(235, 110);

        addComponents(mainColor, cl);
        this.setVisible(true);
    }

    private void addComponents(Color mainColor, ClickListener cl) {
        comboBoxSearch.setVisible(false);
        comboBoxSearch.setBounds(10, 100, 270, 30);
        comboBoxSearch.setBackground(new Color(241, 238, 142));
        comboBoxSearch.setOpaque(true);
        comboBoxSearch.setFocusable(false);


        JLabel labelNote = new JLabel("Add new Car");
        labelNote.setFont(new Font(Font.DIALOG, 0, 18));
        labelNote.setBounds(5, 10, 280, 20);
        labelNote.setHorizontalAlignment(SwingConstants.LEFT);


        JLabel labelModel = new JLabel("Enter car model:");
        labelModel.setBounds(15, 35, 270, 10);
        labelModel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelColor = new JLabel("Enter car color:");
        labelColor.setBounds(15, 95, 270, 10);
        labelColor.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelPrice = new JLabel("Enter car price:");
        labelPrice.setBounds(15, 155, 270, 10);
        labelPrice.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelEfficency = new JLabel("Enter car efficency:");
        labelEfficency.setBounds(15, 215, 270, 10);
        labelEfficency.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(labelModel);
        this.add(labelColor);
        this.add(labelPrice);
        this.add(labelEfficency);
        this.add(comboBoxSearch);


        tModel.setBounds(15, 50, 270, 30);
        tModel.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                tColor.setVisible(false);
                labelColor.setVisible(false);
                field = EnteringField.MODEL;
                List<String> dataSource = getDataByField(field);
                dataSource = dataSource.stream().filter(str -> (str.contains(tModel.getText())) && !tModel.getText().isEmpty()).collect(Collectors.toList());
                if (dataSource.size() != 0) {

                    String[] arr = new String[dataSource.size()];
                    arr = dataSource.toArray(arr);
                    comboBoxSearch.setBounds(15, 85, 270, 30);

                    comboBoxSearch.setModel(new DefaultComboBoxModel<>(arr));
                    comboBoxSearch.setVisible(true);

                } else {
                    comboBoxSearch.setVisible(false);
                    field = EnteringField.NONE;
                    makeAllVisible(labelModel, labelColor, labelEfficency, labelPrice);
                }

            }
        });
        tModel.addActionListener( l ->{
            tModel.setText(comboBoxSearch.getSelectedItem().toString());
            makeAllVisible(labelModel,labelColor,labelEfficency,labelPrice);
            comboBoxSearch.setVisible(false);
        });

        tColor.setBounds(15, 110, 270, 30);
        tColor.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                tPrice.setVisible(false);
                labelPrice.setVisible(false);
                field = EnteringField.COLOR;
                List<String> dataSource = getDataByField(field);
                dataSource = dataSource.stream().filter(str -> (str.contains(tColor.getText())) && !tColor.getText().isEmpty()).collect(Collectors.toList());
                if (dataSource.size() != 0) {

                    String[] arr = new String[dataSource.size()];
                    arr = dataSource.toArray(arr);
                    comboBoxSearch.setBounds(15, 145, 270, 30);

                    comboBoxSearch.setModel(new DefaultComboBoxModel<>(arr));
                    comboBoxSearch.setVisible(true);

                } else {
                    comboBoxSearch.setVisible(false);
                    field = EnteringField.NONE;
                    makeAllVisible(labelModel, labelColor, labelEfficency, labelPrice);
                }

            }
        });
        tColor.addActionListener( l ->{
            tColor.setText(comboBoxSearch.getSelectedItem().toString());
            makeAllVisible(labelModel,labelColor,labelEfficency,labelPrice);
            comboBoxSearch.setVisible(false);
        });

        tPrice.setBounds(15, 170, 270, 30);
        tPrice.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                tEfficiency.setVisible(false);
                labelEfficency.setVisible(false);
                field = EnteringField.PRICE;
                List<String> dataSource = getDataByField(field);
                dataSource = dataSource.stream().filter(str -> (str.contains(tPrice.getText())) && !tPrice.getText().isEmpty()).collect(Collectors.toList());
                if (dataSource.size() != 0) {

                    String[] arr = new String[dataSource.size()];
                    arr = dataSource.toArray(arr);
                    comboBoxSearch.setBounds(15, 205, 270, 30);

                    comboBoxSearch.setModel(new DefaultComboBoxModel<>(arr));
                    comboBoxSearch.setVisible(true);

                } else {
                    comboBoxSearch.setVisible(false);
                    field = EnteringField.NONE;
                    makeAllVisible(labelModel, labelColor, labelEfficency, labelPrice);
                }

            }
        });
        tPrice.addActionListener( l ->{
            tPrice.setText(comboBoxSearch.getSelectedItem().toString());
            makeAllVisible(labelModel,labelColor,labelEfficency,labelPrice);
            comboBoxSearch.setVisible(false);
        });

        tEfficiency.setBounds(15, 230, 270, 30);
        tEfficiency.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                field = EnteringField.EFFICIENCY;
                List<String> dataSource = getDataByField(field);
                dataSource = dataSource.stream().filter(str -> (str.contains(tEfficiency.getText())) && !tEfficiency.getText().isEmpty()).collect(Collectors.toList());
                if (dataSource.size() != 0) {

                    String[] arr = new String[dataSource.size()];
                    arr = dataSource.toArray(arr);
                    comboBoxSearch.setBounds(15, 265, 270, 30);

                    comboBoxSearch.setModel(new DefaultComboBoxModel<>(arr));
                    comboBoxSearch.setVisible(true);

                } else {
                    comboBoxSearch.setVisible(false);
                    field = EnteringField.NONE;
                    makeAllVisible(labelModel, labelColor, labelEfficency, labelPrice);
                }

            }
        });
        tEfficiency.addActionListener( l ->{
            tEfficiency.setText(comboBoxSearch.getSelectedItem().toString());
            makeAllVisible(labelModel,labelColor,labelEfficency,labelPrice);
            comboBoxSearch.setVisible(false);
        });

        this.add(tModel);
        this.add(tColor);
        this.add(tPrice);
        this.add(tEfficiency);
        comboBoxSearch.addActionListener(e -> {
            choosingFromComboBox(field, comboBoxSearch.getSelectedItem().toString());
            comboBoxSearch.setVisible(false);
            makeAllVisible(labelModel, labelColor, labelPrice, labelEfficency);
        });

        JButton buttonAdd = new JButton("ADD");
        buttonAdd.setBounds(15, 290, 270, 45);
        buttonAdd.setBackground(mainColor);
        buttonAdd.setForeground(Color.WHITE);
        buttonAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonAdd.setFocusable(false);
        buttonAdd.addActionListener((e) -> {
            if (fieldCheck()) {
                cl.onButtonClicked(formingObject());
                this.dispose();
            }
        });

        this.add(buttonAdd);

    }
    private void choosingFromComboBox(EnteringField ef, String text) {
        if (ef == EnteringField.COLOR) tColor.setText(text);
        else if (ef == EnteringField.MODEL) tModel.setText(text);
        else if (ef == EnteringField.EFFICIENCY)
            tEfficiency.setText(text);
        else if (ef == EnteringField.PRICE)
            tPrice.setText(text);

    }
    private boolean fieldCheck() {

        double price;
        double efficiency;
        try {
            if (tModel.getText().isEmpty() || tColor.getText().isEmpty()
                    || tPrice.getText().isEmpty() || tEfficiency.getText().isEmpty()) {
                throw new IllegalArgumentException();
            }

            price = Double.parseDouble(tPrice.getText());
            efficiency = Double.parseDouble(tEfficiency.getText());

            if (Validator.isNumeric(tModel.getText()) || Validator.isNumeric(tColor.getText()))
                throw new IllegalArgumentException();


        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }


        return true;

    }
    private List<Car> getDataFromDataSearch() {
        DataSearch ds = DataSearch.getInstance();
        return ds.getData();
    }
    private List<String> getDataByField(EnteringField ef) {
        List<Car> list = getDataFromDataSearch();
        if (ef == EnteringField.COLOR) {
            var setRes = list.stream().map(Car::color).collect(Collectors.toSet());
            return new ArrayList<>(setRes);
        } else if (ef == EnteringField.MODEL) {
            var setRes = list.stream().map(Car::mark).collect(Collectors.toSet());
            return new ArrayList<>(setRes);
        } else if (ef == EnteringField.EFFICIENCY) {
            var setRes = list.stream().map(car -> String.valueOf(car.efficiency())).collect(Collectors.toSet());
            return new ArrayList<>(setRes);
        } else if (ef == EnteringField.PRICE) {
            var setRes = list.stream().map(car -> String.valueOf(car.price())).collect(Collectors.toSet());
            return new ArrayList<>(setRes);
        } else return null;

    }
    private Car formingObject() {


        return new Car(tModel.getText(),
                tColor.getText(),
                Double.parseDouble(tPrice.getText()),
                Double.parseDouble(tEfficiency.getText()));
    }
    private void makeAllVisible(JLabel l1, JLabel l2, JLabel l3, JLabel l4) {
        tEfficiency.setVisible(true);
        tColor.setVisible(true);
        tModel.setVisible(true);
        tPrice.setVisible(true);
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);

    }
    public interface ClickListener {
        void onButtonClicked(Car car);
    }
}
