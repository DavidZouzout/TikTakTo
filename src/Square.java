import javax.swing.*;
import java.awt.*;

public class Square extends JButton {
    private final Color color;
    private int player;

    public Square(Color color, int player) {
        this.color = color;
        this.player = player;
    }

    public void setSquare(int player) {
        this.player = player;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        switch (this.player) {
            case GameBoard.PLAYER_NONE:
                //do nothing
                break;
            case GameBoard.PLAYER_O:
                g.setColor(Color.green);
                g.drawOval(4,4, this.getWidth() - 8, this.getHeight() -8);
                break;
            case GameBoard.PLAYER_X:
                g.setColor(Color.green);
                g.drawLine(0,0, this.getWidth(), this.getHeight());
                g.drawLine(0, this.getHeight(),this.getWidth(),0);
                break;
        }
    }
    public boolean isXSquare(){
        return this.player == GameBoard.PLAYER_X;
    }
    public boolean isOSquare(){
        return this.player == GameBoard.PLAYER_O;
    }
}
