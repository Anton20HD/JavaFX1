package se.iths.tt.javafx.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {


    public Rectangle(double x, double y, Color color, double size) {
        super(x, y, color, size);
    }

    @Override
    public void draw(GraphicsContext context) {

        context.setFill(getColor());
        context.setStroke(getColor());
        double y = getY();
        double x = getX();
        context.fillRect(x,y,getSize(),getSize());
        context.strokeRect(x,y,getSize(),getSize());
    }

    @Override
    public Shape getShapeCopy() {
        return new Rectangle(getX(),getY(),getColor(),getSize());
    }
}


