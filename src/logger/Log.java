package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by tim on 9/4/16.
 */
public final class Log {

    private static BufferedWriter writer = null;

    private Log() { }

    public static void d(String message) {
        write("DEBUG: " + message);
    }

    public static void i(String message) {
        write("INFO: " + message);
    }

    public static void v(String message) {
        write("VERBOSE: " + message);
    }

    public static void w(String message) {
        write("WARNING: " + message);
    }

    public static void e(String message) {
        write("ERROR: " + message);
    }

    private static void write(String message) {
        message = getFormatedDate() + " : " + message + "\r\n";
        try {
            getBufferedWriter().write(message);
            getBufferedWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedWriter getBufferedWriter() throws IOException {
        if (writer == null) {
            File src = new File("log/"+ getFormatedDate() + ".txt");
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

    private static String getFormatedDate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toLocalDateTime().toString();
    }
}
