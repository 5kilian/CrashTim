import javax.swing.*;

/**
 * Created by tim on 18.07.16.
 */
public class Game extends JFrame {

    GameLoopThread gameThread;

    public Game() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("CrashTim");

        GameField level = new GameField();
        add(level);

        setVisible(true);

        gameThread = new GameLoopThread(level);
        gameThread.run();
    }

    public static void main(String[] args) {
        new Game();
    }
}
