import javax.swing.*;

/**
 * Created by tim on 18.07.16.
 */
public class CrashTim extends JFrame {

    public CrashTim() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("CrashTim");

        GameField level = new GameField();
        add(level);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CrashTim();
    }
}
