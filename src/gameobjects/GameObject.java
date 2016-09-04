package gameobjects;

import gameobjects.gamemodel.GameModel;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 * Created by tim on 9/4/16.
 */
public abstract class GameObject {

    protected GameModel model;
    protected Point2D location;
    protected double rotation;

    public abstract void update(long duration);

    public void draw(Graphics2D g) {
        AffineTransform savedTransform = g.getTransform();

        g.translate(location.getX(), location.getY());
        g.rotate(rotation);

        model.draw(g);

        g.setTransform(savedTransform);
    }
}
