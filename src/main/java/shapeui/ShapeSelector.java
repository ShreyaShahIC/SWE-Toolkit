package shapeui;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

// Tutorial 4: a JPanel subclass holding radio buttons. A ButtonGroup makes them mutually exclusive.
// ShapeSelector IS a JPanel, so it can call add() on itself.
public class ShapeSelector extends JPanel {
    private final JRadioButton circle = new JRadioButton("Circle");
    private final JRadioButton rect = new JRadioButton("Rectangle");
    private final JRadioButton square = new JRadioButton("Square");

    public ShapeSelector() {
        ButtonGroup group = new ButtonGroup();
        group.add(circle);
        group.add(rect);
        group.add(square);
        add(circle);
        add(rect);
        add(square);
        circle.setSelected(true);
    }

    public String getCurrentShape() {
        if (rect.isSelected()) return "Rectangle";
        if (square.isSelected()) return "Square";
        return "Circle";
    }
}
