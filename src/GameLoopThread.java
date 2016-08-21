import constants.Constants;

import javax.naming.Context;
import javax.sql.rowset.spi.SyncFactory;

/**
 * Created by tim on 8/21/16.
 */
public class GameLoopThread extends Thread {
    boolean isRunning;
    GameField gameField;

     public GameLoopThread(GameField gameField) {
         this.gameField = gameField;
         isRunning = true;
     }

    /**
     * TODO static fps -> dynamic fps (do not use sleep)
     */
    @Override
     public void run() {
         long TPS = 1000 / Constants.FPS;
         long startTime, sleepTime;

         while (isRunning) {

             startTime = System.nanoTime();

             //synchronized (gameField) {
                 gameField.repaint();
                //System.out.println(System.nanoTime()-startTime);
             //}

             sleepTime = TPS - System.nanoTime() - startTime;
             try {
                 if (sleepTime > 0) {
                     sleep(sleepTime);
                 }
             } catch (Exception ignored) { }
         }
     }

     public void setRunning(boolean running) {
         isRunning = running;
     }

}
