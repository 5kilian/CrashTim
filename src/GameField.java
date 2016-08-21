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
    }


    public void update() {

    }

    public void draw() {

    }

    private class FpsCounter {

        private static final long SECOND = 1_000_000_000;
        private static final long SMOOTHING_DURATION = 250 * 1_000_000; // 250ms
        private static final int FONT_SIZE = 12;

        private final Font counterFont = new Font(Font.MONOSPACED, Font.PLAIN, FONT_SIZE);

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
            g.drawString(String.format("%d FPS", getFps()), 5, 5 + FONT_SIZE);

        }

    }
}
