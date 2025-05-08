package Pieces;

import Model.*;

public class Bishop extends Piece {

    public Bishop(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int desRow, int desCol) {
        int rowDiff = desRow - row;
        int colDiff = desCol - col;

        if (rowDiff != colDiff)
            return false;

        int rowStep = Integer.compare(desRow, row);
        int colStep = Integer.compare(desCol, col);

        int currRow = row + rowStep;
        int currCol = col + colStep;

        while(currCol!= desCol || currRow!= desRow){
            if(board.getPiece(currRow, currCol)!=null)
            {
                return false;
            }
            currRow = currRow + rowStep;
            currCol = currCol + colStep;
        }
        Piece target = board.getPiece(desRow, desCol);
        return target==null || target.getColor() != this.color;
    }
}
