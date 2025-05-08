package Pieces;


import Model.Color;
import Model.Board;

public class Rook extends Piece{

    public Rook(Color color, int row, int col)
    {
        super(color, row, col);
    }
    @Override
    public boolean canMove(Board board, int desRow, int desCol) {
        if(row!=desRow && col!=desCol)
        {
            return false;
        }
        int rowStep = Integer.compare(desRow, row);
        int colStep = Integer.compare(desCol, col); // if(destRow>row) return 1, if(destRow<row) return -1, if equal , return 0;

        int currRow = row + rowStep;
        int currCol = col + colStep;

        while(currRow!=desRow ||currCol!=desCol )
        {
            if(board.getPiece(currRow, currCol)!=null)
            {
                return false;
            }
            currRow += rowStep;
            currCol += colStep;
        }

        Piece target = board.getPiece(desRow, desCol);
        return target==null || target.getColor()!=this.color;
    }
}
