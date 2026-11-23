package shapeui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

// Tutorial 4: a button that opens a JColorChooser dialog and remembers the chosen colour.
public class ColourSelector extends JPanel {
    private Color currentColour = Color.BLACK;
    private final JButton btn1 = new JButton("Choose colour");

    public ColourSelector() {
        showColour();
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColour = JColorChooser.showDialog(btn1, "Choose Colour", currentColour);
                if (newColour != null) {          // null when the user cancels
                    currentColour = newColour;
                    showColour();
                }
            }
        });
        add(btn1);
    }

    // Paint the button in the chosen colour, with text that stays readable on it.
    private void showColour() {
        btn1.setBackground(currentColour);
        int brightness = currentColour.getRed() + currentColour.getGreen() + currentColour.getBlue();
        btn1.setForeground(brightness < 384 ? Color.WHITE : Color.BLACK);
        btn1.setOpaque(true);
    }

    public Color getCurrentColour() {
        return currentColour;
    }
}
