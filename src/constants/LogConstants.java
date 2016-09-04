package constants;

import java.time.format.DateTimeFormatter;

/**
 * Created by Derp on 04.09.2016.
 */
public class LogConstants {

    public static String LOG_TAG_DEBUG = "DEBUG";
    public static String LOG_TAG_VERBOSE = "VERBOSE";
    public static String LOG_TAG_INFO = "INFO";
    public static String LOG_TAG_WARNING = "WARNING";
    public static String LOG_TAG_ERROR = "ERROR";

    public static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
}
