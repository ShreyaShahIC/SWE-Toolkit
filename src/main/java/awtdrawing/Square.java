package awtdrawing;

import java.awt.Color;
import java.awt.Point;

// Tutorial 2: "a constructor containing one line and nothing else". A Square IS a Rect.
public class Square extends Rect {
    public Square(Point position, Color colour, int side) {
        super(position, colour, side, side);
    }
}
