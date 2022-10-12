package Dialogs;

import javax.swing.*;
import java.awt.*;

public class DeleteDialog extends JDialog {

    public DeleteDialog(Color mainColor, DeleteDialog.ClickListener clickListener) {
        super();

        this.setTitle("Deleting element");
        this.setLayout(null);
        this.setSize(new Dimension(320, 200));
        this.setBackground(Color.WHITE);
        this.setLocation(235,210);

        addComponents(mainColor,clickListener);
        this.setVisible(true);
    }

    private void addComponents(Color mainColor, DeleteDialog.ClickListener clickListener){

        JLabel labelText = new JLabel();
        labelText.setText("Enter element id:");
        labelText.setBounds(10,10,290,30);
        labelText.setFont(new Font(Font.DIALOG,0,20));
        labelText.setHorizontalTextPosition(SwingConstants.CENTER);

        JTextField idTextField = new JTextField();
        idTextField.setBounds(10, 50, 290, 30);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 100, 290, 45);
        confirmButton.setBackground(mainColor);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setHorizontalTextPosition(SwingConstants.CENTER);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener( e -> {
            clickListener.onButtonClicked(Integer.parseInt(idTextField.getText()));
            this.dispose();
        });

        this.add(labelText);
        this.add(idTextField);
        this.add(confirmButton);

    }

    public interface ClickListener{
        void onButtonClicked(int id);
    }
}
