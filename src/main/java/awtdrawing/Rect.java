package awtdrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

// Tutorial 2: a Shape with width and height. fillRect(x, y, width, height).
public class Rect extends Shape {
    protected int width;
    protected int height;

    public Rect(Point position, Color colour, int width, int height) {
        super(position, colour);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(colour);
        g.fillRect(position.x, position.y, width, height);
    }
}
