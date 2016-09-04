package gameobjects.immovable;

import gameobjects.GameObject;
import gameobjects.gamemodel.GameModel;

import static constants.ModelConstants.COIN_SOURCE;

/**
 * Created by tim on 2016-09-04.
 */
public class Coin extends GameObject {

    public Coin(int x, int y) {
        super(x, y);
        model = new GameModel(COIN_SOURCE);
    }

    @Override
    public void update(double duration) {

    }
}
