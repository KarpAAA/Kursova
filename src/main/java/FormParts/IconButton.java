package FormParts;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class IconButton extends JButton {
    private static final Border emptyBorder = BorderFactory.createEmptyBorder();
    private static final Color mainColor = new Color(74, 97, 78);

    public IconButton(Icon icon,Rectangle r){
        super(icon);
        this.setBounds(r);
        this.setPreferredSize(new Dimension(30,28));
        this.setBackground(mainColor);
        this.setBorder(emptyBorder);
        this.setContentAreaFilled(false);
    }
}
