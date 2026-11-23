package shapeui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// Tutorial 4: Main only builds the window and adds the controller's main panel.
public class ShapeUIMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shape App");
            DrawingUIController controller = new DrawingUIController();
            frame.add(controller.getMainPanel());
            frame.setSize(500, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
