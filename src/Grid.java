import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedHashMap;
import java.util.Map;

public class Grid {

    private static Rectangle grid;
    private static final int PADDING = 10;
    private static final int gridSideLength = 720;
    private static final int squaresNumber = 60;
    private static final int squareLength = gridSideLength / squaresNumber;

    private static Color paintingColor;
    private static Color standardColor;
    private static Map<Rectangle, Color> map;

    public static void init(boolean limits) {
        grid = new Rectangle(PADDING, PADDING, gridSideLength, gridSideLength);
        grid.draw();

        map = new LinkedHashMap<>();

        for (int y = 0; y < squaresNumber; y++) {
            for (int x = 0; x < squaresNumber; x++) {
                Rectangle square = new Rectangle( PADDING + x*squareLength, PADDING + y*squareLength, squareLength, squareLength);
                square.draw();
                map.put(square, Color.WHITE);
            }
        }

        paintingColor = Color.BLACK;
        standardColor = Color.WHITE;

        if (limits) {
            withLimits();
        } else {
            clearScreen();
        }

    }

    public static void withLimits() {
        for (int v = 0; v < squaresNumber; v++) {
            Line horLine = new Line(PADDING + v*squareLength, PADDING, PADDING + v*squareLength, PADDING + gridSideLength);
            Line verLine = new Line(PADDING, PADDING + v*squareLength, PADDING + gridSideLength, PADDING + v*squareLength);
            horLine.draw();
            verLine.draw();
        }

    }


    public static void repaint(Map.Entry<Rectangle, Color> entry) {
        entry.getKey().setColor(paintingColor);
        entry.setValue(paintingColor);
        entry.getKey().fill();
    }

    public static void paintTrace(Position pos) {
        for (Map.Entry<Rectangle, Color> entry : map.entrySet()) {
            if (entry.getKey().getX() == pos.xInPixels() && entry.getKey().getY() == pos.yInPixels()) {
                repaint(entry);
            }
        }
    }

    public static void loadSquares(Color[] values) {
        int counter = 0;
        for (Map.Entry<Rectangle, Color> entry : map.entrySet()) {
            map.put(entry.getKey(), values[counter]);
            entry.getKey().setColor(values[counter]);
            entry.getKey().fill();
            counter++;
        }
    }

    public static void clearScreen() {
        for (Map.Entry<Rectangle, Color> entry : map.entrySet()) {
            entry.getKey().setColor(standardColor);
            map.put(entry.getKey(), standardColor);
            entry.getKey().fill();
        }
    }

    public static void changeColor(Color color) {
        paintingColor = color;
    }

    public static int getPadding() {
        return PADDING;
    }

    public static int getSquareLength() {
        return squareLength;
    }

    public static int getGridSideLength() {
        return gridSideLength;
    }

    public static Map<Rectangle, Color> getMap() {
        return map;
    }
}
