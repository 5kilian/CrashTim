package logger;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import static constants.LogConstants.*;

/**
 * Created by tim on 9/4/16.
 */
public final class Log {

    private static BufferedWriter writer = null;

    private Log() { }

    public static void d(String message) {
        log(LOG_TAG_DEBUG, message);
    }

    public static void i(String message) {
        log(LOG_TAG_INFO, message);
    }

    public static void v(String message) {
        log(LOG_TAG_VERBOSE, message);
    }

    public static void w(String message) {
        log(LOG_TAG_WARNING, message);
    }

    public static void e(String message) {
        log(LOG_TAG_ERROR, message);
    }

    private static void log(String tag, String message) {
        log(tag + ": " + message);
    }

    private static void log(String message) {
        String formattedMessage = getFormattedDate(TIME_DATE_FORMAT) + " : " + message + "\r\n";

        System.out.println(formattedMessage);
        write(formattedMessage);
    }

    private static void write(String message) {
        try {
            getBufferedWriter().write(message);
            getBufferedWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedWriter getBufferedWriter() throws IOException {
        if (writer == null) {
            File src = new File("log/"+ getFormattedDate(DATE_FORMAT) +"/"+ getFormattedDate(TIME_FORMAT) + ".txt");
            System.out.println(src.getAbsolutePath());
            if (!src.exists()) {
                if (!src.getParentFile().exists())
                    src.getParentFile().mkdirs();
                src.createNewFile();
            }
            writer = new BufferedWriter(new FileWriter(src));
        }
        return writer;
    }

    private static String getFormattedDate(DateTimeFormatter formatter) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toLocalDateTime().format(formatter);
    }
}
