package awtdrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

// Tutorial 2: superclass extracted from Circle and Rect (Refactor > Extract > Superclass).
// abstract draw(): every concrete shape must say how it draws itself.
public abstract class Shape {
    protected Point position;
    protected Color colour;

    public Shape(Point position, Color colour) {
        this.position = position;
        this.colour = colour;
    }

    public abstract void draw(Graphics g);
}
