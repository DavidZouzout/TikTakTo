import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameBoard extends JPanel {
    private final static ArrayList<ArrayList<Square>> boardData = new ArrayList<>();
    public static final int BOARD_LENGTH = 3;
    public static final int PLAYER_X = 0;
    public static final int PLAYER_O = 1;
    public static final int PLAYER_NONE = 2;
    static boolean isXTurn = false;
    Square x = null;
    Square O = null;

    public GameBoard() {
        this.setBackground(Color.BLUE);
        GridLayout gridLayout = new GridLayout(BOARD_LENGTH, BOARD_LENGTH);
        this.setLayout(gridLayout);

        boolean black = false;
        boolean setPlayer = false;

        for (int row = 0; row < BOARD_LENGTH; row++) {
            ArrayList<Square> currentRow = new ArrayList<>();
            for (int column = 0; column < BOARD_LENGTH; column++) {
                int player = PLAYER_NONE;
                Square square;
                if (black) square = new Square(Color.BLACK, player);
                else square = new Square(Color.WHITE, player);
                int finalRow = row;
                int finalColumn = column;

                square.addActionListener((event) -> {
                    if (isXTurn) {
                        square.setSquare(PLAYER_X);
                        isXTurn = !isXTurn;
                    } else {
                        square.setSquare(PLAYER_O);
                        isXTurn = !isXTurn;
                    }

                                     /* X Rows*/
                    if(boardData.get(0).get(0).isXSquare() && boardData.get(0).get(1).isXSquare() && boardData.get(0).get(2).isXSquare())
                           System.out.println("X Wins");
                    if(boardData.get(1).get(0).isXSquare() && boardData.get(1).get(1).isXSquare() && boardData.get(0).get(2).isXSquare())
                        System.out.println("X Wins");
                    if(boardData.get(2).get(0).isXSquare() && boardData.get(2).get(1).isXSquare() && boardData.get(2).get(2).isXSquare())
                        System.out.println("X Wins");
                    /* X Columns*/
                    if(boardData.get(0).get(0).isXSquare() && boardData.get(1).get(0).isXSquare() && boardData.get(2).get(0).isXSquare())
                        System.out.println("X Wins");
                    if(boardData.get(0).get(1).isXSquare() && boardData.get(1).get(1).isXSquare() && boardData.get(2).get(1).isXSquare())
                        System.out.println("X Wins");
                    if(boardData.get(0).get(2).isXSquare() && boardData.get(1).get(2).isXSquare() && boardData.get(2).get(2).isXSquare())
                        System.out.println("X Wins");
                    /* O column */
                    if(boardData.get(0).get(0).isOSquare() && boardData.get(1).get(0).isOSquare() && boardData.get(2).get(0).isOSquare())
                        System.out.println("X Wins");
                    if(boardData.get(0).get(1).isOSquare() && boardData.get(1).get(1).isOSquare() && boardData.get(2).get(1).isOSquare())
                        System.out.println("X Wins");
                    if(boardData.get(0).get(2).isOSquare() && boardData.get(1).get(2).isOSquare() && boardData.get(2).get(2).isOSquare())
                        System.out.println("X Wins");

                    /* O Row */
                    if(boardData.get(0).get(0).isOSquare() && boardData.get(0).get(1).isOSquare() && boardData.get(0).get(2).isOSquare())
                        System.out.println("O Wins");
                    if(boardData.get(1).get(0).isOSquare() && boardData.get(1).get(1).isOSquare() && boardData.get(0).get(2).isOSquare())
                        System.out.println("O Wins");
                    if(boardData.get(2).get(0).isOSquare() && boardData.get(2).get(1).isOSquare() && boardData.get(2).get(2).isOSquare())
                        System.out.println("O Wins");





                        repaint();

                });
                this.add(square);
                currentRow.add(square);
                black = !black;
                setPlayer = !setPlayer;
                boardData.add(currentRow);
            }
        }
    }
}

