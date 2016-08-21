import constants.Constants;

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
        long startTime, frameTime, sleepTime;
        long sleepTimeMs, sleepTimeNs;


        while (isRunning) {

            startTime = System.nanoTime();

            //synchronized (gameField) {
            gameField.repaint();
            //System.out.println(System.nanoTime()-startTime);
            //}

            frameTime = System.nanoTime() - startTime;

            sleepTime = TARGET_FRAMETIME - frameTime;
            sleepTimeMs = sleepTime / MILLISECOND;
            sleepTimeNs = sleepTime % MILLISECOND;

            gameField.setUtilization(frameTime, sleepTime);

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
