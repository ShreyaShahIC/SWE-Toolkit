package awtdrawing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

// Tutorial 2: subclass Canvas and override paint(). You never call paint yourself:
// the window system calls it whenever the canvas needs drawing.
public class AwtDrawing extends Canvas {
    private final ArrayList<Shape> shapes = new ArrayList<>();

    public AwtDrawing() {
        shapes.add(new Circle(new Point(100, 100), Color.RED, 40));
        shapes.add(new Rect(new Point(200, 60), Color.BLUE, 120, 80));
        shapes.add(new Square(new Point(380, 60), new Color(45, 160, 90), 80));   // Color(r, g, b) ints 0-255
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 100, 100);
        for (Shape s : shapes) {
            s.draw(g);              // polymorphism: each shape's own draw runs
        }
    }
}
