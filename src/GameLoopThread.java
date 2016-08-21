import constants.Constants;

import javax.naming.Context;
import javax.sql.rowset.spi.SyncFactory;

/**
 * Created by tim on 8/21/16.
 */
public class GameLoopThread extends Thread {

    private static final long MILLISECOND = 1_000_000;
    private static final long TARGET_FRAMETIME = 1_000_000_000 / Constants.FPS;

    private GameField gameField;
    private boolean isRunning;

    public GameLoopThread(GameField gameField) {
        this.gameField = gameField;
        isRunning = true;
    }


    /**
     * TODO static fps -> dynamic fps (do not use sleep)
     */
    @Override
    public void run() {
        long startTime, endTime, sleepTime;
        long sleepTimeMs, sleepTimeNs;


        while (isRunning) {

            startTime = System.nanoTime();

            //synchronized (gameField) {
            gameField.repaint();
            //System.out.println(System.nanoTime()-startTime);
            //}

            endTime = System.nanoTime();

            sleepTime = TARGET_FRAMETIME - endTime + startTime;
            sleepTimeMs = sleepTime / MILLISECOND;
            sleepTimeNs = sleepTime % MILLISECOND;

            try {
                if (sleepTime > 0) {
                    sleep(sleepTimeMs, (int) sleepTimeNs);
                }
            } catch (Exception ignored) {
            }
        }
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

}
