package gameobjects.movable.car;

import gameobjects.gamemodel.GameModel;

import static constants.ModelConstants.ENEMY_CAR_SOURCE;

/**
 * Created by tim on 2016-09-04.
 */
public class EnemyCar extends Car {

    public EnemyCar(int x, int y) {
        super(x, y);
        model = new GameModel(ENEMY_CAR_SOURCE);
    }

    @Override
    public void update(long duration) {

    }
}
