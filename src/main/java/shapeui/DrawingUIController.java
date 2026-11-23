package shapeui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import shapestudio.Drawing;

// Tutorial 4: coding from a design. The controller owns mainPanel, which holds the controls
// panel and the Drawing. Its mouse listener reads every selector to decide what to add.
public class DrawingUIController {
    private final JPanel mainPanel = new JPanel(new GridLayout(2, 1));    // controls on top, drawing below
    private final JPanel controlsPanel = new JPanel(new GridLayout(3, 2)); // six cells
    private final Drawing drawing = new Drawing();

    private final ShapeSelector sSel = new ShapeSelector();
    private final ColourSelector cSel = new ColourSelector();
    private final SizeSelector radiusSel = new SizeSelector("Circle radius", 1, 100, 20);
    private final SizeSelector widthSel = new SizeSelector("Rectangle width / square side", 1, 200, 60);
    private final SizeSelector heightSel = new SizeSelector("Rectangle height", 1, 200, 30);
    private final JLabel stats = new JLabel();

    public DrawingUIController() {
        controlsPanel.add(sSel);
        controlsPanel.add(cSel);
        controlsPanel.add(radiusSel);
        controlsPanel.add(widthSel);
        controlsPanel.add(heightSel);
        controlsPanel.add(stats);
        mainPanel.add(controlsPanel);
        mainPanel.add(drawing);
        updateStats();

        drawing.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point p = e.getPoint();
                Color colour = cSel.getCurrentColour();
                switch (sSel.getCurrentShape()) {
                    case "Rectangle":
                        drawing.addRect(p, colour, widthSel.getCurrentValue(), heightSel.getCurrentValue());
                        break;
                    case "Square":
                        drawing.addSquare(p, colour, widthSel.getCurrentValue());
                        break;
                    default:
                        drawing.addCircle(p, colour, radiusSel.getCurrentValue());
                }
                updateStats();
            }
        });
    }

    private void updateStats() {
        stats.setText("<html>" + drawing.getStats() + "</html>");   // <html> lets a JLabel wrap
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
