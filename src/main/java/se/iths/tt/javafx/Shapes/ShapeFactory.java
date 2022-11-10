package se.iths.tt.javafx.Shapes;

import javafx.scene.paint.Color;
import se.iths.tt.javafx.ShapeType;

public class ShapeFactory {

    public static Shape creatingShapes(ShapeType shapeType, double x, double y, Color color, double size) {

        return switch (shapeType) {
            case CIRCLE -> new Circle(x, y,color,size);
            case RECTANGLE -> new Rectangle(x, y,color,size);
        };
    }




}
