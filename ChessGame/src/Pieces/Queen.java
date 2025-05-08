package Pieces;

import Model.*;

public class Queen  extends Piece {

    public Queen(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int desRow, int desCol) {
        int rowDiff = desRow - row;
        int colDiff = desCol - col;

        if ((row==desRow || col==colDiff || Math.abs(rowDiff) == Math.abs(colDiff))){
                int rowStep = Integer.compare(desRow, row);
                int colStep = Integer.compare(desCol, col);

                int currRow = row + rowStep;
                int currCol = col + colStep;

                while(row!=desRow || col!=desCol)
                {
                    if(board.getPiece(currRow, currCol)!=null)
                            return false;
                    currRow += rowStep;
                    currCol += colStep;
                }
            Piece target = board.getPiece(desRow, desCol);
            return target == null || target.getColor() != this.color;
        }
        return false;
    }
}
