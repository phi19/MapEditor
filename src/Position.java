public class Position {

    private int row;
    private int col;

    public Position(int[] coordinates) {
        row = coordinates[0];
        col = coordinates[1];
    }

    public void goUp() {
        row--;
    }

    public void goDown() {
        row++;
    }

    public void goLeft() {
        col--;
    }

    public void goRight() {
        col++;
    }

    public int yInPixels() {
        return Grid.getPadding() + row*Grid.getSquareLength();
    }

    public int xInPixels() {
        return Grid.getPadding() + col * Grid.getSquareLength();
    }
}
