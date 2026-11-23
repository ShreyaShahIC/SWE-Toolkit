package shapestudio;

// Tutorials 3-4: rectangle; fields protected so Square can use them.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rect extends Shape {
    protected int width;
    protected int height;

    public Rect(Point position, Color colour, int width, int height) {
        super(position, colour);
        this.width = width;
        this.height = height;
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(colour);
        g.fillRect(position.x, position.y, width, height);
    }
}
