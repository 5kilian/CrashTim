package gameobjects.movable.car;

import gameobjects.gamemodel.GameModel;
import gameobjects.movable.MovableGameObject;

import static constants.ModelConstants.CAR_SOURCE;

/**
 * Created by tim on 2016-09-04.
 */
public abstract class Car extends MovableGameObject {

    protected double velocity = 0;

    public Car(int x, int y) {
        super(x, y);
        model = new GameModel(CAR_SOURCE);
    }
}
