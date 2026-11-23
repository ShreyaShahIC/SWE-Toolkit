package awtdrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

// Tutorial 2: a Shape with a radius. fillOval takes the top-left corner, width and height.
public class Circle extends Shape {
    private final int radius;

    public Circle(Point position, Color colour, int radius) {
        super(position, colour);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(colour);
        g.fillOval(position.x - radius, position.y - radius, 2 * radius, 2 * radius);  // centred on position
    }
}
