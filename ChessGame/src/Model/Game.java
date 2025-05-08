package Model;
import Model.*;
import Exception.*;
import Pieces.*;
import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class Game {

    Board board;
    Player[] players;
    int currentPlayer;

    public Game()
    {
        board = new Board();
        players = new Player[]{new Player(Color.WHITE), new Player(Color.BLACK)};
        currentPlayer = 0;
    }

    public void start()
    {
        while(!isGameOver())
        {
            Player player = players[currentPlayer];
            System.out.println("Playing Player is "+ player.getColor());

            Move move = getMove();
            try
            {
                player.makeMove(board, move);
            }
            catch(InvalidMoveException e)
            {
                System.out.println(e.getMessage());
            }
            currentPlayer = (currentPlayer+1)%2;
            displayResult();
        }
    }

    boolean isGameOver()
    {
        return board.isCheckmate(players[0].getColor()) || board.isCheckmate(players[1].getColor()) ||
                board.isStalemate(players[0].getColor()) || board.isStalemate(players[1].getColor());
    }

    Move getMove()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter src row");
        int srcRow = scanner.nextInt();
        System.out.println("Enter src col");
        int srcCol = scanner.nextInt();
        System.out.println("Enter dest row");
        int destRow = scanner.nextInt();
        System.out.println("Enter dest col");
        int destCol = scanner.nextInt();

        Piece piece = board.getPiece(srcRow, srcCol);

        if(piece == null || piece.getColor()!= players[currentPlayer].getColor())
        {
            System.out.println("Incorrect selection");
        }
        return new Move(piece, destRow, destCol);
    }

    public void displayResult()
    {
        if(board.isCheckmate(Color.WHITE))
        {
            System.out.println("Black wins");
        }
        else if(board.isCheckmate(Color.BLACK))
        {
            System.out.println(Color.BLACK);
        }
        else
        {
            if(board.isStalemate(Color.WHITE) || board.isStalemate(Color.BLACK))
            {
                System.out.println("System end in stalemate");
            }
        }
    }

}
