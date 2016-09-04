package gameobjects.gamemodel;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.ModelConstants.*;

/**
 * Created by Derp on 21.08.2016.
 */
public class Polygon {

    private static final Pattern POLYGON_PATTERN = Pattern.compile("\\(([0-9a-f]{4}),([0-9a-f]{4}),([0-9a-f]{4})\\)(?::([0-9a-f]{6}))?");
    private static final Stroke ANTIALIAS_ARTIFACT_STROKE = new BasicStroke(0.075f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
    private static final Stroke WIREFRAME_STROKE = new BasicStroke(0.15f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);

    private Color fillColor = null;
    private Shape shape;


    public Polygon(String constructionString, Map<String, Vertex> vertices) {
        if (!isValidConstructionString(constructionString))
            throw new IllegalArgumentException("Construction string for gamemodel.Vertex is not valid: " + constructionString);

        Matcher m = POLYGON_PATTERN.matcher(constructionString);
        m.find();

        Vertex[] polygonVertices = new Vertex[3];
        for (int i = 0; i < 3; i++) {
            String vertexId = m.group(i + 1);

            if (!vertices.containsKey(vertexId))
                throw new IllegalArgumentException("gamemodel.Vertex does not exist: " + vertexId);

            polygonVertices[i] = vertices.get(vertexId);
        }

        generateShapeFromVertices(polygonVertices);


        if (m.group(4) != null) {
            fillColor = Color.decode('#' + m.group(4));
        }
    }

    public Polygon(Vertex... vertices) {
        generateShapeFromVertices(vertices);
    }

    private void generateShapeFromVertices(Vertex... vertices) {
        GeneralPath path = new GeneralPath();

        path.moveTo(vertices[0].getX(), vertices[0].getY());

        for (int i = 1; i < vertices.length; i++) {
            Vertex currentVertex = vertices[i];

            path.lineTo(currentVertex.getX(), currentVertex.getY());
        }

        path.closePath();


        shape = path;
    }

    public Shape getShape() {
        return shape;
    }

    public static boolean isValidConstructionString(String constructionString) {
        return POLYGON_PATTERN.matcher(constructionString).matches();
    }

    public void draw(Graphics2D g) {
        if (fillColor == null)
            drawWireframe(g);
        else
            drawFill(g);
    }

    private void drawWireframe(Graphics2D g) {
        g.setStroke(WIREFRAME_STROKE);
        g.setColor(WIREFRAME_COLOR);
        g.draw(shape);
    }

    private void drawFill(Graphics2D g) {
        g.setColor(fillColor);
        g.setStroke(ANTIALIAS_ARTIFACT_STROKE);

        g.draw(shape);
        g.fill(shape);
    }
}
