package Pieces;

import Model.*;

public abstract class Piece {

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    protected Color color;
    protected int row;
    protected int col;

    public Piece(Color color, int row, int col)
    {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public abstract boolean canMove(Board board, int desRow, int desCol);
}
