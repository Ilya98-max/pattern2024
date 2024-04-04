package edu.pattern.shapes.observer.impl;

import edu.pattern.shapes.model.Rectangle;

import edu.pattern.shapes.model.RectangleState;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.RectangleObserver;
import edu.pattern.shapes.service.RectangleService;


public class RectangleObserverImpl implements RectangleObserver {
    @Override
    public void update(Rectangle rectangle) {
        RectangleState state = RectangleState.detect(rectangle.getTopLeft(), rectangle.getTopRight(),
                rectangle.getBottomLeft(), rectangle.getBottomRight());
        switch (state) {
            case VALID:
                handleValidRectangle(rectangle);
                break;
            case SQUARE:
                handleSquareRectangle(rectangle);
                break;
            case RHOMBUS:
                handleRhombusRectangle(rectangle);
                break;
            case TRAPEZOID:
                handleTrapezoidRectangle(rectangle);
                break;
            case INVALID:
                handleInvalidRectangle(rectangle);
                break;
        }
    }

    private void handleValidRectangle(Rectangle rectangle) {
        RectangleService service = new RectangleService();
        double perimeter = service.calculatePerimeter(rectangle);
        int key = rectangle.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key,perimeter);
    }

    private void handleSquareRectangle(Rectangle rectangle) {

        System.out.println("Square rectangle detected. Side lengths are equal.");

    }

    private void handleRhombusRectangle(Rectangle rectangle) {

        System.out.println("Rhombus rectangle detected. Side lengths are equal but adjacent sides are not.");

    }

    private void handleTrapezoidRectangle(Rectangle rectangle) {

        System.out.println("Trapezoid rectangle detected. Two pairs of adjacent sides have equal lengths.");

    }

    private void handleInvalidRectangle(Rectangle rectangle) {

        System.out.println("Invalid rectangle detected. Side lengths do not meet the criteria for valid rectangles.");

    }
}
