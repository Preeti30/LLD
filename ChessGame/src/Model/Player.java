package Model;

import Pieces.Piece;
import Exception.*;
public class Player {

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    Color color;
    public Player(Color color)
    {
        this.color = color;
    }

    void makeMove(Board board, Move move)
    {
        Piece piece = move.getPiece();
        int destRow = move.getDestRow();
        int destCol = move.getDestCol();
        if(board.isValidMove(piece,destRow, destCol))
        {
            int srcRow = piece.getRow();
            int srcCol = piece.getCol();

            board.setPiece(srcRow, srcCol, null);
            board.setPiece(destRow, destCol, piece);
            piece.setRow(destRow);
            piece.setCol(destCol);
        }
        else {
            throw new InvalidMoveException("Invalid move");
        }
    }
}
