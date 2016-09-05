package gameobjects.movable.car;

import gameobjects.gamemodel.GameModel;
import logger.Log;

import java.awt.event.*;

import static constants.ModelConstants.CAR_SOURCE;

/**
 * Created by tim on 04.09.2016.
 */
public class PlayerCar extends Car {

    public PlayerCar(int x, int y) {
        super(x, y);
        model = new GameModel(CAR_SOURCE);
    }

    @Override
    public void update(double duration) {
        super.update(duration);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            direction = 'l';
        }
    }

    public void keyReleased(KeyEvent e) {
        direction = 'r';
    }
}
