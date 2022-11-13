package se.iths.tt.javafx.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {


    public Circle(double x, double y, Color color, int size) {
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
    public boolean isInsideShape(double mouseX, double mouseY) {
        double distX = mouseX - getX();
        double distY = mouseY - getY();
        double distance = Math.sqrt((distX * distX) + (distY * distY));

        return distance <= getSize();



    }

    @Override
    public String svgFormat() {
        return "<circle cx=\"" + getX() + "\" " +
                "cy=\"" + getY() + "\" " +
                "r=\"" + getSize() +
                "\" fill=\"#" + getColor().toString().substring(2,10) + "\" />";
    }
}







