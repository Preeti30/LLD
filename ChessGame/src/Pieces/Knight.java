package Pieces;

import Model.*;

public class Knight extends Piece {

    public Knight(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int desRow, int desCol) {
            int rowDiff = Math.abs(desRow-row);
            int colDiff = Math.abs(desCol-col);

            if((rowDiff==2 && colDiff==1) ||(rowDiff==1 && colDiff==2))
            {
                Piece target = board.getPiece(desRow, desCol);
                return target==null || target.getColor()!=this.color;
            }
            return false;
    }
}
