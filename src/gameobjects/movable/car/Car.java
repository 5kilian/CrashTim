package gameobjects.movable.car;

import gameobjects.gamemodel.GameModel;
import gameobjects.movable.MovableGameObject;

import static constants.ModelConstants.CAR_SOURCE;

/**
 * Created by tim on 2016-09-04.
 */
public abstract class Car extends MovableGameObject {

    protected double velocity = 1;
    protected double phi = 0;
    protected char direction = 'l';

    public Car(int x, int y) {
        super(x, y);
        model = new GameModel(CAR_SOURCE);
    }

    @Override
    public void update(double duration) {
        if (direction == 'l') turnLeft();
        else turnRight();
    }

    public void turnLeft() {
        setXY(getX() + Math.cos(getPhi()), getY() + Math.sin(getPhi()));
        setPhi(phi - 0.1*velocity);
    }

    public void turnRight() {
        setXY(getX() + Math.cos(getPhi()), getY() + Math.sin(getPhi()));
        setPhi(phi + 0.1*velocity);
    }

    public void setPhi(double n) {
        phi = n % 360;
    }

    public double getPhi() {
        return phi % 360;
    }
}
