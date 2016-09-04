package gamemodel;

import java.awt.geom.Point2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Derp on 21.08.2016.
 */
public class Vertex {

    private static final Pattern VERTEX_PATTERN = Pattern.compile("([0-9a-f]{4}):(\\d+(?:\\.\\d+)?),(\\d+(?:\\.\\d+)?)");

    private final String id;
    private final Point2D location;

    public Vertex(String constructionString) {
        Matcher m = VERTEX_PATTERN.matcher(constructionString);

        if (!m.matches())
            throw new IllegalArgumentException("Construction string for gamemodel.Vertex is not valid: " + constructionString);

        id = m.group(1);

        double x = Double.parseDouble(m.group(2));
        double y = Double.parseDouble(m.group(3));
        location = new Point2D.Double(x, y);
    }

    public String getId() {
        return id;
    }

    public double getX() {
        return location.getX();
    }

    public double getY() {
        return location.getY();
    }

    public static boolean isValidConstructionString(String constructionString) {
        return VERTEX_PATTERN.matcher(constructionString).matches();
    }

}
