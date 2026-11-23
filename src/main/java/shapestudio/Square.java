package shapestudio;

// Tutorials 3-4: a Square IS a Rect with equal sides.
import java.awt.Color;
import java.awt.Point;

public class Square extends Rect {
    public Square(Point position, Color colour, int side) {
        super(position, colour, side, side);   // a square is a rect with equal sides
    }
}
