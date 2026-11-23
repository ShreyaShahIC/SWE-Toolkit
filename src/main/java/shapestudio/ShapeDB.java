package shapestudio;

// Tutorial 4: storage class. Package-private: only the shapestudio package can use it.
import java.awt.Graphics;
import java.util.ArrayList;

class ShapeDB {                        // package-private: only the shapes package can see it
    private final ArrayList<Shape> shapes = new ArrayList<>();

    void add(Shape s) {
        shapes.add(s);
    }

    void removeLast() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
        }
    }

    void clear() {
        shapes.clear();
    }

    int count() {
        return shapes.size();
    }

    int countOf(Class<? extends Shape> type) {
        int n = 0;
        for (Shape s : shapes) {
            if (s.getClass() == type) n++;   // exact class, so a Square is not counted as a Rect
        }
        return n;
    }

    void drawAll(Graphics g) {
        for (Shape s : shapes) {
            s.draw(g);                      // polymorphism: each shape's own draw runs
        }
    }
}
