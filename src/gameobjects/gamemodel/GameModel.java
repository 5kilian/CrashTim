package gameobjects.gamemodel;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Derp on 21.08.2016.
 */
public class GameModel {

    private List<Polygon> polygons = new ArrayList<>();

    public GameModel(String source) {
        this(new File(source));
    }

    public GameModel(File source) {
        try (BufferedReader sourceReader = new BufferedReader(new FileReader(source))) {

            Map<String, Vertex> vertices = new HashMap<>();
            List<String> polygonConstructors = new ArrayList<>();

            String line;
            while ((line = sourceReader.readLine()) != null) {

                if (Vertex.isValidConstructionString(line)) {
                    Vertex vertex = new Vertex(line);

                    vertices.put(vertex.getId(), vertex);
                } else if (Polygon.isValidConstructionString(line)) {
                    polygonConstructors.add(line);
                }
            }

            polygons.addAll(polygonConstructors.stream().map(polygonConstructor -> new Polygon(polygonConstructor, vertices)).collect(Collectors.toList()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        for (Polygon p : polygons) {
            p.draw(g);
        }
    }

}
