package gamelogic;

import gamefield.GameField;

import static constants.FpsConstants.*;

/**
 * Created by tim on 8/21/16.
 */
public class GameLoopThread extends Thread {

    private GameField gameField;
    private long lastUpdateTime;
    private boolean isRunning = false;

    public GameLoopThread(GameField gameField) {
        this.gameField = gameField;
    }


    /**
     * TODO static fps -> dynamic fps (do not use sleep)
     */
    @Override
    public void run() {
        long startTime, frameTime, sleepTime;
        long sleepTimeMs, sleepTimeNs;


        lastUpdateTime = System.nanoTime();

        while (isRunning) {

            startTime = System.nanoTime();

            synchronized (gameField) {
                updateGamefield();

                frameTime = System.nanoTime() - startTime;

                sleepTime = TARGET_FRAMETIME - frameTime;
                sleepTimeMs = sleepTime / MILLISECOND;
                sleepTimeNs = sleepTime % MILLISECOND;

                gameField.getFpsCounter().addFrame();
                gameField.getFpsCounter().setUtilization(frameTime, sleepTime);
            }

            try {
                if (sleepTime > 0)
                    sleep(sleepTimeMs, (int) sleepTimeNs);
            } catch (Exception ignored) { }
        }
    }

    private void updateGamefield() {
        long newUpdateTime = System.nanoTime();
        long updateDuration = newUpdateTime - lastUpdateTime;
        gameField.update(updateDuration);
        lastUpdateTime = newUpdateTime;

        gameField.draw();
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
