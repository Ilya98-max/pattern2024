package edu.pattern.shapes.main;

import edu.pattern.shapes.creator.RectangleFactory;
import edu.pattern.shapes.creator.impl.RectangleFactoryImpl;
import edu.pattern.shapes.model.Rectangle;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.service.RectangleService;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        RectangleFactory rectangleFactory = new RectangleFactoryImpl();
        List<Rectangle> rectangles = rectangleFactory.createRectanglesFromFile("/Rectangle.txt");

        Warehouse warehouse = Warehouse.getInstance();
        for (Rectangle rectangle : rectangles) {
            warehouse.put(rectangle.getId(), RectangleService.calculatePerimeter(rectangle));
        }

        System.out.println(warehouse);
    }
}
