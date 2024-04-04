package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.RectangleFactory;
import edu.pattern.shapes.model.Point;
import edu.pattern.shapes.model.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class RectangleFactoryImpl implements RectangleFactory {
    @Override
    public List<Rectangle> createRectanglesFromFile(String filePath) {
        List<Rectangle> rectangles = new ArrayList<>();
        try (InputStream inputStream = RectangleFactoryImpl.class.getResourceAsStream(filePath)) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 BufferedReader reader = new BufferedReader(inputStreamReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] stringPoints = line.split(";");
                    if (stringPoints.length == 4) {
                        Point[] points = new Point[4];
                        for (int i = 0; i < 4; i++) {
                            String[] xy = stringPoints[i].split(",");
                            if (xy.length == 2) {
                                try {
                                    double x = Double.parseDouble(xy[0]);
                                    double y = Double.parseDouble(xy[1]);
                                    points[i] = new Point(x, y);
                                } catch (NumberFormatException e) {

                                }
                            }
                        }
                        Rectangle rectangle = new Rectangle(points[0], points[1], points[2], points[3]);
                        rectangles.add(rectangle);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rectangles;
    }
}

