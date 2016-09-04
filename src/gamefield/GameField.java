package gamefield;

import gamelogic.FpsCounter;
import gameobjects.GameObject;
import gameobjects.movable.DummyCar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by tim on 20.07.16.
 */
public class GameField extends JPanel {

    private FpsCounter fpsCounter;
    private List<GameObject> gameObjects;

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
        gameObjects = new ArrayList<GameObject>();

        gameObjects.add(new DummyCar());
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        fpsCounter.draw(graphics);

        update();
        draw((Graphics2D) graphics);
    }


    public void update() {
        for (GameObject object : gameObjects) {
            object.update();
        }
    }

    public void draw(Graphics2D g) {
        for (GameObject object : gameObjects) {
            object.draw(g);
        }
    }

    public FpsCounter getFpsCounter() {
        return fpsCounter;
    }
}
