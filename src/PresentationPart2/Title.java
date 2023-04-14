package PresentationPart2;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Title extends JLabel {
    public Title(String title, Color backgroundColor) {
        this.setText(title);
        this.setBackground(backgroundColor);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Monospaced", 3, 20));
        this.setHorizontalAlignment(0);
        this.setOpaque(true);
    }
}
