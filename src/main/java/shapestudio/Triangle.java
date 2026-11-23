package shapestudio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

// Tutorial 3 extra: a new Shape. Nothing else in the drawing loop has to change: that's polymorphism.
public class Triangle extends Shape {
    private final int size;

    public Triangle(Point position, Color colour, int size) {
        super(position, colour);
        this.size = size;
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(colour);
        int[] xs = {position.x, position.x - size, position.x + size};
        int[] ys = {position.y - size, position.y + size, position.y + size};
        g.fillPolygon(xs, ys, 3);
    }
}
