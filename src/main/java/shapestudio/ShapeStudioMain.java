package shapestudio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

// Tutorial 3: JFrame + controls panel (combo box, slider, buttons) + drawing panel + stats label.
// Click the drawing to add the selected shape at the mouse position.
public class ShapeStudioMain {
    private static Color currentColour = Color.MAGENTA;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {             // build Swing on the Event Dispatch Thread
            JFrame frame = new JFrame("Shape Studio");
            Drawing drawing = new Drawing();

            JComboBox<String> choice = new JComboBox<>(new String[]{"Circle", "Rect", "Square", "Triangle"});
            JSlider sizeSlider = new JSlider(10, 100, 30);   // min, max, start
            JButton colourBtn = new JButton("Colour");
            JButton undo = new JButton("Undo");
            JButton clear = new JButton("Clear all");
            JLabel stats = new JLabel(drawing.getStats());

            JPanel controls = new JPanel(new FlowLayout());
            controls.add(choice);
            controls.add(sizeSlider);
            controls.add(colourBtn);
            controls.add(undo);
            controls.add(clear);

            // Lambda listeners (short form)
            undo.addActionListener(e -> { drawing.undo(); stats.setText(drawing.getStats()); });
            clear.addActionListener(e -> { drawing.clear(); stats.setText(drawing.getStats()); });

            // Anonymous-class listener (the form used in the lectures)
            colourBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Color chosen = JColorChooser.showDialog(colourBtn, "Choose colour", currentColour);
                    if (chosen != null) {                 // null if the user pressed Cancel
                        currentColour = chosen;
                        colourBtn.setBackground(chosen);
                    }
                }
            });

            // Slider listener: react while dragging
            sizeSlider.addChangeListener(e -> sizeSlider.setToolTipText("Size " + sizeSlider.getValue()));

            drawing.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String selected = (String) choice.getSelectedItem();
                    int size = sizeSlider.getValue();
                    if (selected.equals("Circle")) {           // .equals, never == for Strings
                        drawing.addCircle(e.getPoint(), currentColour, size);
                    } else if (selected.equals("Rect")) {
                        drawing.addRect(e.getPoint(), currentColour, size * 2, size);
                    } else if (selected.equals("Square")) {
                        drawing.addSquare(e.getPoint(), currentColour, size);
                    } else {
                        drawing.addTriangle(e.getPoint(), currentColour, size);
                    }
                    stats.setText(drawing.getStats());
                }
            });

            frame.add(controls, BorderLayout.NORTH);
            frame.add(drawing, BorderLayout.CENTER);
            frame.add(stats, BorderLayout.SOUTH);
            frame.setSize(700, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);                     // last
        });
    }
}
