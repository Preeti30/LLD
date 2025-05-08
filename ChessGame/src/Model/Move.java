package Model;

import Pieces.Piece;

public class Move {
    public int getDestRow() {
        return destRow;
    }

    public int getDestCol() {
        return destCol;
    }

    public Piece getPiece() {
        return piece;
    }

    int destRow;

    public void setDestCol(int destCol) {
        this.destCol = destCol;
    }

    public void setDestRow(int destRow) {
        this.destRow = destRow;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    int destCol;
    Piece piece;

    public Move(Piece piece, int destRow, int destCol)
    {
        this.piece = piece;
        this.destRow = destRow;
        this.destCol = destCol;
    }


}
