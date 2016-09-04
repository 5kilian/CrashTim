package gameobjects.movable.car;

import constants.ModelConstants;
import gameobjects.gamemodel.GameModel;

import java.awt.geom.Point2D;

/**
 * Created by Derp on 04.09.2016.
 */
public class DummyCar extends Car {

    public DummyCar() {
        this(0, 0);
    }

    public DummyCar(int x, int y) {
        super(x, y);
        rotation = 25;
        model = new GameModel(ModelConstants.CAR_SOURCE);
    }

    @Override
    public void update(long duration) {

    }
}
