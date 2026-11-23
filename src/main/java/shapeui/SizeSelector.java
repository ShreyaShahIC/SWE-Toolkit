package shapeui;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

// Tutorial 4: CircleDimsSelector, generalised. A label above a slider, inside a nested JPanel
// with GridLayout(2, 1). One instance per dimension you need (radius, width, height...).
public class SizeSelector extends JPanel {
    private final JSlider slider;

    public SizeSelector(String labelText, int min, int max, int start) {
        JPanel controls = new JPanel(new GridLayout(2, 1));
        JLabel label = new JLabel(labelText);
        slider = new JSlider(min, max, start);
        controls.add(label);
        controls.add(slider);
        add(controls);
    }

    public int getCurrentValue() {
        return slider.getValue();
    }
}
