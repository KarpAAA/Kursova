package Dialogs;

import javax.swing.*;
import java.awt.*;

public class ConfirmationDialog extends JDialog {

    public ConfirmationDialog(Color mainColor,ReloadListener reloadListener) {
        super();

        this.setTitle("Confirmation");
        this.setLayout(null);
        this.setSize(new Dimension(325, 150));
        this.setBackground(Color.WHITE);
        this.setLocation(235, 205);

        addComponents(mainColor,reloadListener);

        this.setVisible(true);
    }

    private void addComponents(Color mainColor,ReloadListener reloadListener) {

        JLabel labelText = new JLabel();
        labelText.setText("You sure you want to reload data?");
        labelText.setBounds(10, 10, 290, 30);
        labelText.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        labelText.setHorizontalTextPosition(SwingConstants.CENTER);


        JButton confirmButton = new JButton("YES");
        confirmButton.setBounds(10, 60, 140, 40);
        confirmButton.setBackground(mainColor);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setHorizontalTextPosition(SwingConstants.CENTER);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(e -> {
            reloadListener.reload();
            this.dispose();
        });

        JButton cancelButton = new JButton("NO");
        cancelButton.setBounds(160, 60, 140, 40);
        cancelButton.setBackground(mainColor);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(e -> {
            this.dispose();
        });


        this.add(labelText);
        this.add(confirmButton);
        this.add(cancelButton);
    }
    public interface ReloadListener{
        void reload();
    }
}
