package Pieces;

import Model.*;

public class Pawn extends Piece{

    public Pawn(Color color, int row, int col)
    {
        super(color, row, col);
    }
    @Override
    public boolean canMove(Board board, int desRow, int desCol) {

        int direction = (color==Color.WHITE) ?1 :-1;
        //white upar hai they can come down and increase index

        int startRow = (color==Color.WHITE)?1:6;

        int rowdiff = desRow - row;
        int colDiff = Math.abs(desCol - col);

        Piece target = board.getPiece(desRow, desCol);

        if(colDiff ==0 && rowdiff ==direction && target==null)//straight
                return true;

        if(colDiff == 0 && row== startRow && rowdiff == direction*2 )//double move
        {
            int midRow = startRow + direction;
            if(board.getPiece(midRow, col)== null && target==null)
            {
                return true;
            }
        }

        if(colDiff==1 && rowdiff == direction && target!=null && target.getColor()!=this.color)//diag
        {
            return true;
        }
        return false;

    }
}
