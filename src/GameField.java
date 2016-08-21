import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by tim on 20.07.16.
 */
public class GameField extends JPanel {

    public GameField() {
        setBackground(Color.GREEN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                setBackground(Color.RED);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        System.out.println("asdaibsufa");
        update();
        draw();
    }


    public void update() {

    }

    public void draw() {

    }
}
