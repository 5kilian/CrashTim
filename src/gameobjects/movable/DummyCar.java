package gameobjects.movable;

import constants.ModelConstants;
import gameobjects.gamemodel.GameModel;

/**
 * Created by Derp on 04.09.2016.
 */
public class DummyCar extends Car {

    public DummyCar() {
        model = new GameModel(ModelConstants.CAR_SOURCE);
    }

    @Override
    public void update() {

    }
}
