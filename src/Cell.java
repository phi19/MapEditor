import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private Rectangle sprite;
    private Color color;
    private Position position;
    private boolean painting;

    public Cell(int[] pos, Color color) {
        this.position = new Position(pos);
        this.color = color;
        sprite = new Rectangle(position.xInPixels(), position.yInPixels(), Grid.getSquareLength(), Grid.getSquareLength());
        sprite.setColor(color);
        sprite.fill();
        painting = false;
    }

    public boolean isPainting() {
        return painting;
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }

    public Position getPosition() {
        return position;
    }

    public Rectangle getSprite() {
        return sprite;
    }
}
