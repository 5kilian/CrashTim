import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;


/**
 * Created by tim on 20.07.16.
 */
public class GameField extends JPanel {

    FpsCounter counter = new FpsCounter();

    public GameField() {
        setBackground(Color.GREEN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                setBackground(Color.RED);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        update();
        draw();
        counter.addFrame();
        counter.draw(graphics);
        showUtilization(graphics);

    }


    public void update() {

    }

    public void draw() {

    }

    private class FpsCounter {

        private static final long SECOND = 1_000_000_000;
        private static final long SMOOTHING_DURATION = 250 * 1_000_000; // 250ms

        private final Font counterFont = new Font(Font.MONOSPACED, Font.PLAIN, Constants.FONT_SIZE);

        Queue<Long> frameTimes = new ArrayDeque<>();

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
            g.drawString(String.format("%d FPS", getFps()), 5, 5 + Constants.FONT_SIZE);

        }

    }


    private static final int UTILIZATION_SIZE = 30;
    private long frameTime = 0, sleepTime = 1;

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

        g.drawString(utilizationBar.toString(), 5, 2 * (5 + Constants.FONT_SIZE));
    }
}
