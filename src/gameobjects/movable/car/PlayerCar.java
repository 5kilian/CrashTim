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
    public void update(long duration) {
        location.setLocation(getX(), getY()+velocity);
    }

    public void keyPressed(KeyEvent e) {
        Log.d("Key pressed");
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Log.d("Space pressed");
            velocity = 1;
        } else Log.d("Other key pressed");
    }

    public void keyReleased(KeyEvent e) {
        velocity = 0;
        Log.d("Key released");
    }
}
