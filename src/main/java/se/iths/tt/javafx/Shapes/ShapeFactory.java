package se.iths.tt.javafx.Shapes;

import javafx.scene.paint.Color;

public class ShapeFactory {

    public static Shape creatingShapes(ShapeType shapeType, double x, double y, Color color, int size) {

        return switch (shapeType) {
            case CIRCLE -> new Circle(x, y,color,size);
            case SQUARE -> new Square(x, y,color,size);
        };
    }




}
