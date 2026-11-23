package awtdrawing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Tutorial 2: a Frame (window) holding a Canvas. The window listener ends the program on close.
public class AwtMain {
    public static void main(String[] args) {
        Frame f = new Frame("My window");
        AwtDrawing drawing = new AwtDrawing();
        drawing.setSize(600, 400);
        drawing.setBackground(Color.WHITE);
        f.add(drawing);                       // Frame's default BorderLayout puts it in the centre
        f.setSize(600, 430);
        f.addWindowListener(new WindowAdapter() {   // anonymous subclass of WindowAdapter
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.setVisible(true);                   // starts the event (message) loop thread
    }
}
