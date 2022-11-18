package se.iths.tt.javafx.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {


    public Square(double x, double y, Color color, int size) {
        super(x, y, color, size);
    }

    @Override
    public void draw(GraphicsContext context) {

        context.setFill(getColor());
        context.setStroke(getColor());
        double y = getY();
        double x = getX();
        context.fillRect(x, y, getSize(), getSize());
        context.strokeRect(x, y, getSize(), getSize());
    }

    @Override
    public boolean isInsideShape(double mouseX, double mouseY) {
        double distX = Math.abs(mouseX - getX());
        double distY = Math.abs(mouseY - getY());


        return distX <= getSize() && distY <= getSize();
    }

    @Override
    public String svgFormat() {
        String convertedColor = "#" + getColor().toString().substring(2,10);
        return "<rect x=\"" + (getX() - getSize()/2) + "\" " +
                "y=\"" + (getY() - getSize()/2) + "\" " +
                "width=\"" + (getSize()) + "\" " +
                "height=\"" + (getSize()) + "\" " +
                "fill=\"" + convertedColor + "\" />";


    }


}

