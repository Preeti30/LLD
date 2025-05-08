package Pieces;

import Model.*;

public class King extends Piece {

    public King(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int desRow, int desCol) {
        int rowDiff = Math.abs(desRow - row);
        int colDiff = Math.abs(desCol - col);

        if (rowDiff <= 1 && colDiff <= 1 && (rowDiff+colDiff != 0));
        {
            Piece target = board.getPiece(desRow, desCol);
            return target==null || target.getColor() != this.color;
        }
    }
}
