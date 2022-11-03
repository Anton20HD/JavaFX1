package se.iths.tt.javafx.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {


    public Circle(double x, double y, double width, double height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(GraphicsContext context) {

        context.setFill(getColor());
        context.setStroke(getColor());
        double y = getY();
        double x = getX();
        context.fillOval( x,y,getWidth(),getHeight());


    }
}







