import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;
    Random random = new Random();
    Board(int size, int numberOfSnakes, int numberOfLadders)
    {
        initializeBoard(size);
        addSnakesAndLadders(cells, numberOfSnakes, numberOfLadders);
    }

    public void addSnakesAndLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        System.out.println("ss");
        while(numberOfSnakes>0)
        {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

            if(snakeTail>snakeHead)
                continue;
            Jump jumpobj = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.setJump(jumpobj);
            numberOfSnakes--;
        }

        while(numberOfLadders>0)
        {
            int LadderHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int LadderTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            Jump jumpobj = new Jump(LadderHead, LadderTail);
            Cell cellobj = getCell(LadderHead);
            cellobj.setJump(jumpobj);
            numberOfLadders--;
        }
    }



    public Cell getCell(int snakeHead) {

        int row = snakeHead/cells.length;
        int column = snakeHead% cells.length;
        return cells[row][column];
    }

    public void initializeBoard(int size)
    {
        System.out.println("Ini");
        cells = new Cell[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                cells[i][j] = new Cell();
            }
        }
    }

}
