package gameobjects;

import gameobjects.gamemodel.GameModel;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by tim on 9/4/16.
 */
public abstract class GameObject {

    protected GameModel model;
    protected Point2D location;

    public abstract void update();

    public void draw(Graphics2D g) {
        model.draw(g);
    }
}
