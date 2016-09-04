package gamelogic;

import java.awt.*;
import java.util.*;

import static constants.FpsConstants.*;

/**
 * Created by tim on 2016-08-29.
 */
public class FpsCounter {

    private final Font counterFont = new Font(Font.MONOSPACED, Font.PLAIN, FONT_SIZE);
    private final Queue<Long> frameTimes = new ArrayDeque<>();
    private long frameTime = 0, sleepTime = 1;

    public void addFrame() {
        frameTimes.add(System.nanoTime());
    }

    public int getFps() {
        long currentTime = System.nanoTime();

        while (!frameTimes.isEmpty() && currentTime - frameTimes.peek() > SMOOTHING_DURATION)
            frameTimes.poll();

        return (int) (SECOND / SMOOTHING_DURATION) * frameTimes.size();
    }

    public void draw(Graphics g) {
        g.setFont(counterFont);
        g.drawString(String.format("%d FPS", getFps()), 5, 5 + FONT_SIZE);
        showUtilization(g);
    }

    public void setUtilization(long frameTime, long sleepTime) {
        this.frameTime = frameTime;
        this.sleepTime = sleepTime;
    }

    public void showUtilization(Graphics g) {
        int utilization = (int) Math.round(15d * frameTime / (frameTime + sleepTime));

        StringBuilder utilizationBar = new StringBuilder(UTILIZATION_SIZE);

        for (int i = 0; i < utilization; i++)
            utilizationBar.append('█');

        for (int i = utilization; i < UTILIZATION_SIZE; i++)
            utilizationBar.append('░');

        g.drawString(utilizationBar.toString(), 5, 2 * (5 + FONT_SIZE));
    }

}
