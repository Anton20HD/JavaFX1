package se.iths.tt.javafx.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {


    public Rectangle(double x, double y, double width, double height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(GraphicsContext context) {

        context.setFill(getColor());
        context.setStroke(getColor());
        double y = getY();
        double x = getX();
        context.fillRect(x,y,getWidth(),getHeight());
        context.strokeRect(x,y,getWidth(),getHeight());
    }
}


