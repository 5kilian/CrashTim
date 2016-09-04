package gamefield;

import gamelogic.FpsCounter;
import gameobjects.GameObject;
import gameobjects.movable.DummyCar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.util.List;


/**
 * Created by tim on 20.07.16.
 */
public class GameField extends JPanel {

    private FpsCounter fpsCounter;
    private List<GameObject> gameObjects;

    private AffineTransform cameraTransform = AffineTransform.getScaleInstance(25, 25);

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
        setRenderingHints(g);

        g.setTransform(cameraTransform);

        for (GameObject object : gameObjects) {
            object.draw(g);
        }
    }

    private void setRenderingHints(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    public FpsCounter getFpsCounter() {
        return fpsCounter;
    }
}
