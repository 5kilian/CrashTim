package gamefield;

import gamelogic.FpsCounter;
import gameobjects.GameObject;
import gameobjects.immovable.Coin;
import gameobjects.movable.car.CoinCar;
import gameobjects.movable.car.DummyCar;
import gameobjects.movable.car.EnemyCar;
import gameobjects.movable.car.PlayerCar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        setBackground(new Color(143, 188, 143));
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                setBackground(new Color(188, 143, 188));
            }
        });
        fpsCounter = new FpsCounter();
        gameObjects = new ArrayList<>();


        initializeComponents();
    }

    public void initializeComponents() {
        gameObjects.add(new DummyCar());

        PlayerCar player = new PlayerCar(10, 2);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);
                player.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                super.keyReleased(keyEvent);
                player.keyReleased(keyEvent);
            }
        });
        gameObjects.add(player);
        gameObjects.add(new CoinCar(20, 2));
        gameObjects.add(new Coin(30, 2));
        gameObjects.add(new EnemyCar(10, 20));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        fpsCounter.draw(graphics);
        draw((Graphics2D) graphics);
    }


    public void update(double duration) {
        for (GameObject object : gameObjects) {
            object.update(duration);
        }
    }

    public void draw() {
        repaint();
    }

    private void draw(Graphics2D g) {
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
