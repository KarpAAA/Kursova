package FormParts;

import Task.Task;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskButton extends JButton {
    private static final Border emptyBorder = BorderFactory.createEmptyBorder();
    private final String task;

    public TaskButton(String name, String task, Task action) {
        super(name);
        this.task = task;
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(80, 30));
        this.setBackground(Color.WHITE);
        this.setBorder(emptyBorder);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.doTask();
            }
        });
    }

}
