package gameobjects.movable.car;

import gameobjects.gamemodel.GameModel;
import gameobjects.movable.MovableGameObject;

import static constants.ModelConstants.CAR_SOURCE;

/**
 * Created by tim on 9/4/16.
 */
public abstract class Car extends MovableGameObject {

    public Car(int x, int y) {
        super(x, y);
        model = new GameModel(CAR_SOURCE);
    }
}
