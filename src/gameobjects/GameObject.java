package gameobjects;

import gameobjects.gamemodel.GameModel;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 * Created by tim on 2016-09-04.
 */
public abstract class GameObject {

    protected GameModel model;
    protected Point2D location;
    protected double rotation;

    public GameObject(int x, int y) {
        location = new Point2D.Double(x, y);
    }

    public abstract void update(double duration);

    public void draw(Graphics2D g) {
        AffineTransform savedTransform = g.getTransform();

        g.translate(location.getX(), location.getY());
        g.rotate(rotation);

        model.draw(g);

        g.setTransform(savedTransform);
    }

    public void setX(double x) {
        location.setLocation(x, getY());
    }

    public double getX() {
        return location.getX();
    }

    public void setY(double y) {
        location.setLocation(getX(), y);
    }

    public double getY() {
        return location.getY();
    }

    public void setXY(double x, double y) {
        location.setLocation(x, y);
    }
}
