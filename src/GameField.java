import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;


/**
 * Created by tim on 20.07.16.
 */
public class GameField extends JPanel {

    private FpsCounter fpsCounter;

    public GameField() {
        setBackground(Color.GREEN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                setBackground(Color.RED);
            }
        });
        fpsCounter = new FpsCounter();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        fpsCounter.draw(graphics);

        update();
        draw();
    }


    public void update() {

    }

    public void draw() {

    }

    public FpsCounter getFpsCounter() {
        return fpsCounter;
    }
}
