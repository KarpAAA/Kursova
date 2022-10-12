package Dialogs;

import Data.Car;

import javax.swing.*;
import java.awt.*;

public class AddDialog extends JDialog{
    JTextField tModel = new JTextField();
    JTextField tColor = new JTextField();
    JTextField tPrice = new JTextField();
    JTextField tEfficiency = new JTextField();

    public AddDialog(Color mainColor,ClickListener cl) {
        super();

        this.setTitle("Adding new element");
        this.setLayout(null);
        this.setSize(new Dimension(310, 380));
        this.setBackground(Color.WHITE);
        this.setLocation(235,110);

        addComponents(mainColor,cl);
        this.setVisible(true);
    }

    private void addComponents(Color mainColor,ClickListener cl) {
        JLabel labelNote = new JLabel("Add new Car");
        labelNote.setFont(new Font(Font.DIALOG, 0, 18));
        labelNote.setBounds(5, 10, 280, 20);
        labelNote.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(labelNote);

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




        tModel.setBounds(15, 50, 270, 30);
        tColor.setBounds(15, 110, 270, 30);
        tPrice.setBounds(15, 170, 270, 30);
        tEfficiency.setBounds(15, 230, 270, 30);

        this.add(tModel);
        this.add(tColor);
        this.add(tPrice);
        this.add(tEfficiency);


        JButton buttonAdd = new JButton("ADD");
        buttonAdd.setBounds(15, 290, 270, 45);
        buttonAdd.setBackground(mainColor);
        buttonAdd.setForeground(Color.WHITE);
        buttonAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonAdd.setFocusable(false);
        buttonAdd.addActionListener((e) -> {
            if (fieldCheck()){
                cl.onButtonClicked(formingObject());
                this.dispose();
            }
        });

        this.add(buttonAdd);

    }

    private boolean fieldCheck() {
        if (tModel.getText().isEmpty() || tColor.getText().isEmpty()
                || tPrice.getText().isEmpty() || tEfficiency.getText().isEmpty()) {
            return false;
        } else if (Double.valueOf(tPrice.getText()).isNaN()) {
            return false;
        } else if (Double.valueOf(tEfficiency.getText()).isNaN()) {
            return false;
        } else return true;

    }

    private Car formingObject() {
        String mark = tModel.getText();
       // mark = mark.replace(mark.charAt(0), Character.toUpperCase(mark.charAt(0)));
        return new Car(mark,
                tColor.getText(),
                Double.parseDouble(tPrice.getText()),
                Double.parseDouble(tEfficiency.getText()));
    }

    public  interface ClickListener {
        void onButtonClicked(Car car);
    }
}
