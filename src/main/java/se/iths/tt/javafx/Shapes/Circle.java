package se.iths.tt.javafx.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {


    public Circle(double x, double y, Color color, double size) {
        super(x, y, color, size);
    }

    @Override
    public void draw(GraphicsContext context) {

        context.setFill(getColor());
        context.setStroke(getColor());
        double y = getY();
        double x = getX();
        context.fillOval( x,y,getSize(),getSize());


    }

    @Override
    public Shape getShapeCopy() {
        return new Circle(getX(),getY(),getColor(),getSize());
    }
}







