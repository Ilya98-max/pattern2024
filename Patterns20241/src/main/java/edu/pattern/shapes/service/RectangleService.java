package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Rectangle;

public class RectangleService {
    public static double calculatePerimeter(Rectangle rectangle) {
        double side1 = rectangle.getTopLeft().distanceTo(rectangle.getTopRight());
        double side2 = rectangle.getTopLeft().distanceTo(rectangle.getBottomLeft());
        return 2 * (side1 + side2);
    }

    public static boolean isRhombus(Rectangle rectangle) {
        double side1 = rectangle.getTopLeft().distanceTo(rectangle.getTopRight());
        double side2 = rectangle.getTopLeft().distanceTo(rectangle.getBottomLeft());
        double side3 = rectangle.getTopRight().distanceTo(rectangle.getBottomRight());
        double side4 = rectangle.getBottomLeft().distanceTo(rectangle.getBottomRight());
        return side1 == side2 && side2 == side3 && side3 == side4;
    }
    public static boolean isSquare(Rectangle rectangle) {
        double side1 = rectangle.getTopLeft().distanceTo(rectangle.getTopRight());
        double side2 = rectangle.getTopLeft().distanceTo(rectangle.getBottomLeft());
        double side3 = rectangle.getTopRight().distanceTo(rectangle.getBottomRight());
        double side4 = rectangle.getBottomLeft().distanceTo(rectangle.getBottomRight());
        return side1 == side2 && side2 == side3 && side3 == side4;
    }

    public static boolean isConvex(Rectangle rectangle) {
        return true;
    }

    public static boolean isTrapezoid(Rectangle rectangle) {
        return false;
    }



}
