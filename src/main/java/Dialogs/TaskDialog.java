package Dialogs;

import Utilities.Validator;

import javax.swing.*;
import java.awt.*;

public class TaskDialog extends JDialog {

    public TaskDialog(Color mainColor, TaskDialogStructure td,TaskDialogOnDoButtonClicked dl) {
        super();

        this.setTitle(td.getTitle());
        this.setLayout(null);
        this.setSize(new Dimension(600, 180));
        this.setBackground(Color.WHITE);
        this.setLocation(235, 205);

        addComponents(mainColor,td,dl);

        this.setVisible(true);
    }
    public TaskDialog(Color mainColor, TaskDialogStructure td,TaskDialogOnDoButtonClickedWithTextField dlTextField) {
        super();

        this.setTitle(td.getTitle());
        this.setLayout(null);
        this.setSize(new Dimension(600, 180));
        this.setBackground(Color.WHITE);
        this.setLocation(235, 205);

        addComponents(mainColor,td,dlTextField);

        this.setVisible(true);
    }

    private void addComponents(Color mainColor, TaskDialogStructure td,TaskDialogOnDoButtonClicked dl){

        JLabel labelText = new JLabel();
        labelText.setText(td.getTask());
        labelText.setBounds(10, 10, 550, 60);
        labelText.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        labelText.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton confirmButton = new JButton("Do task");
        confirmButton.setBounds(10, 80, 550, 40);
        confirmButton.setBackground(mainColor);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setHorizontalTextPosition(SwingConstants.CENTER);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(e -> {
            dl.performTask();
            this.dispose();
        });

        this.add(labelText);
        this.add(confirmButton);

    }
    private void addComponents(Color mainColor, TaskDialogStructure td,TaskDialogOnDoButtonClickedWithTextField dlTextField){

        JLabel labelText = new JLabel();
        labelText.setText(td.getTask());
        labelText.setBounds(10, 10, 550, 30);
        labelText.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        labelText.setHorizontalTextPosition(SwingConstants.CENTER);

        JTextField tAdditionalField = new JTextField();
        tAdditionalField.setBounds(10, 50 , 550 , 30);

        this.add(tAdditionalField);

        JButton confirmButton = new JButton("Do task");
        confirmButton.setBounds(10, 80, 550, 40);
        confirmButton.setBackground(mainColor);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setHorizontalTextPosition(SwingConstants.CENTER);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(e -> {
            if(!tAdditionalField.getText().isEmpty()){
                try{
                    if(Validator.isNumeric(tAdditionalField.getText()))throw new IllegalArgumentException();
                }
                catch(IllegalArgumentException exception){
                    exception.printStackTrace();
                    this.dispose();
                    return;
                }
                dlTextField.performTask(tAdditionalField.getText());
                this.dispose();
            }
        });

        this.add(labelText);
        this.add(confirmButton);

    }
    public interface TaskDialogOnDoButtonClicked{
        void performTask();
    }
    public interface TaskDialogOnDoButtonClickedWithTextField{
        void performTask(String value);
    }
}
