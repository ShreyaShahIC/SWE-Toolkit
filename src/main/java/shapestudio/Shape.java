package shapestudio;

// Tutorials 3-4: abstract superclass. draw() is package-private and abstract.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
    protected Point position;
    protected Color colour;

    public Shape(Point position, Color colour) {
        this.position = position;
        this.colour = colour;
    }

    abstract void draw(Graphics g);   // package-private and abstract: each shape draws itself
}
