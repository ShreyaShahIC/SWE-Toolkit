package shapestudio;

// Tutorials 3-4: circle centred on its position.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Shape {
    private final int radius;

    public Circle(Point position, Color colour, int radius) {
        super(position, colour);
        this.radius = radius;
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(colour);
        // fillOval takes the top-left corner, so shift by the radius to centre on the click
        g.fillOval(position.x - radius, position.y - radius, 2 * radius, 2 * radius);
    }
}
