package constants;

import static constants.Constants.*;

/**
 * Created by tim on 9/4/16.
 */
public class FpsConstants {

    public static final int FONT_SIZE = 12;
    public static final long FPS = 60;

    public static final long TARGET_FRAMETIME = SECOND / FPS;
    public static final long SMOOTHING_DURATION = 250 * 1_000_000; // 250ms
    public static final int UTILIZATION_SIZE = 30;

}

