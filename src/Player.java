import org.academiadecodigo.simplegraphics.graphics.Color;

public class Player {

    private Cell graphic;
    private MyKeyboard keyboard;

    public Player() {
        graphic = new Cell(new int[]{0, 0}, Color.GREEN);
        keyboard = new MyKeyboard(this);
        keyboard.init();
    }

    public void moveUp() {
        if (graphic.isPainting()) {
            Grid.paintTrace(graphic.getPosition());
        }
        if (graphic.getSprite().getY() > Grid.getPadding()) {
            graphic.getSprite().translate(0, -Grid.getSquareLength());
            graphic.getPosition().goUp();
        }
    }

    public void moveDown() {
        if (graphic.isPainting()) {
            Grid.paintTrace(graphic.getPosition());
        }
        if (graphic.getSprite().getY() < Grid.getPadding() + Grid.getGridSideLength() - Grid.getSquareLength()) {
            graphic.getSprite().translate(0, Grid.getSquareLength());
            graphic.getPosition().goDown();
        }

    }

    public void moveLeft() {
        if (graphic.isPainting()) {
            Grid.paintTrace(graphic.getPosition());
        }
        if (graphic.getSprite().getX() > Grid.getPadding()) {
            graphic.getSprite().translate(-Grid.getSquareLength(), 0);
            graphic.getPosition().goLeft();
        }
    }

    public void moveRight() {
        if (graphic.isPainting()) {
            Grid.paintTrace(graphic.getPosition());
        }
        if (graphic.getSprite().getX() < Grid.getPadding() + Grid.getGridSideLength() - Grid.getSquareLength()) {
            graphic.getSprite().translate(Grid.getSquareLength(), 0);
            graphic.getPosition().goRight();
        }

    }

    public void paintSquare() {
        graphic.setPainting(true);
        Grid.paintTrace(graphic.getPosition());
    }

    public void stopPaintingSquare() {
        graphic.setPainting(false);
    }
}

