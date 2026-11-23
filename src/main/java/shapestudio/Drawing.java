package shapestudio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

// Tutorials 3-4: the package's only public face. Storage lives in package-private ShapeDB,
// so the user interface can't touch the list directly (encapsulation at package level).
// Swing drawing: override paintComponent, call super first, and call repaint() after changes.
public class Drawing extends JPanel {
    private final ShapeDB db = new ShapeDB();

    public Drawing() {
        setBackground(Color.WHITE);
    }

    public void addCircle(Point p, Color c, int radius)  { db.add(new Circle(p, c, radius)); repaint(); }
    public void addRect(Point p, Color c, int w, int h)  { db.add(new Rect(p, c, w, h)); repaint(); }
    public void addSquare(Point p, Color c, int side)    { db.add(new Square(p, c, side)); repaint(); }
    public void addTriangle(Point p, Color c, int size)  { db.add(new Triangle(p, c, size)); repaint(); }

    public void undo()  { db.removeLast(); repaint(); }
    public void clear() { db.clear(); repaint(); }

    public int getShapeCount() { return db.count(); }

    public String getStats() {
        return "Circles: " + db.countOf(Circle.class)
             + "  Rects: " + db.countOf(Rect.class)
             + "  Squares: " + db.countOf(Square.class)
             + "  Triangles: " + db.countOf(Triangle.class);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);   // clears the background first
        db.drawAll(g);
    }
}
