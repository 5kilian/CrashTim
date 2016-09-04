package gameobjects.movable;

import gameobjects.gamemodel.GameModel;

import static constants.ModelConstants.CAR_SOURCE;

/**
 * Created by tim on 9/4/16.
 */
public abstract class Car extends MovableGameObject {

    public Car() {
        model = new GameModel(CAR_SOURCE);
    }
}
