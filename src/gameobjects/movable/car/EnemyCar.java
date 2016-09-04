package gameobjects.movable.car;

import gameobjects.gamemodel.GameModel;

import static constants.ModelConstants.CAR_SOURCE;

/**
 * Created by tim on 9/4/16.
 */
public class EnemyCar extends Car {

    public EnemyCar(int x, int y) {
        super(x, y);
        model = new GameModel(CAR_SOURCE);
    }

    @Override
    public void update(double duration) {

    }
}
