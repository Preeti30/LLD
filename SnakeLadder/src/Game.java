import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playerdequeue;
    Player winner;
    public Game()
    {
        initializeGame();
    }

    private void initializeGame() {
        System.out.println("Initializing game");
        board = new Board(10, 10, 10);
//        System.out.println("Before calling addPlayers() b");
        dice = new Dice(1);
//        System.out.println("Before calling addPlayers() d");
        winner = null;
        playerdequeue = new LinkedList<>();
//        System.out.println("Before calling addPlayers()");
        addPlayers();
//        System.out.println("After calling addPlayers()");
    }

    private void addPlayers() {
        System.out.println("Adding players");
        Player player1 = new Player(1, 0);
        Player player2 = new Player(2, 0);
        playerdequeue.add(player1);
        playerdequeue.add(player2);
    }

    public void startGame()
    {
        System.out.println("Lets start the game");
        while(winner==null)
        {
            Player playerturn = playerdequeue.pollFirst();
            System.out.println("Current player is player" + playerturn.id);
            playerdequeue.offerLast(playerturn);
            int diceNumber = dice.rollDice();
            System.out.println("Dice rolled with "+ diceNumber);
            int newPosition = playerturn.current_position + diceNumber;
            System.out.println("Player newPosition is " + newPosition);
            int finalPosition = jumpCheck(newPosition);
            System.out.println("Player finalPosition is " + finalPosition);
            playerturn.current_position = finalPosition;
            if(finalPosition >= board.cells.length * board.cells.length-1)
            {
                System.out.println("Winner is " + playerturn) ;
                winner = playerturn;

            }
        }
    }

    public int jumpCheck(int newPosition) {
        if(newPosition> board.cells.length * board.cells.length -1)
        {
            return newPosition;
        }
        Cell cell = board.getCell(newPosition);
        if(cell.jump!=null)
        {
            String entity = (cell.jump.startPosition < cell.jump.endPosition)?"ladder":"snake";
            System.out.println("Entity came is "+ entity);
            return cell.jump.endPosition;
        }
        return newPosition;
    }
}
