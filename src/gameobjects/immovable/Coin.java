package gameobjects.immovable;

import gameobjects.GameObject;
import gameobjects.gamemodel.GameModel;

import java.awt.*;

import static constants.ModelConstants.COIN_SOURCE;

/**
 * Created by tim on 9/4/16.
 */
public class Coin extends GameObject {

    public Coin() {
        model = new GameModel(COIN_SOURCE);
    }

    @Override
    public void update() {

    }
}
