package se.iths.tt.javafx.Shapes;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class Shape {

   private final double x;
   private final double y;
   private double size;
   private final SimpleObjectProperty<Color> color = new SimpleObjectProperty<>();



    public Shape(double x, double y, Color color, double size) {
        this.x = x;
        this.y = y;
        this.size = size;

        setColor(color);

    }



    public void setColor(Color color) {

        this.color.set(color);
    }

    public double getX() {
        return x;
    }

//    public void setX(double x) {
//        this.x = x;
//    }

    public double getY() {
        return y;
    }


    public double getSize() {
        return size;
    }
    public void setSize(int size) {

        this.size = size;
    }

    public SimpleObjectProperty<Color> colorProperty() {
        return color;
    }

    public Color getColor() {
        return color.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Double.compare(shape.x, x) == 0 && Double.compare(shape.y, y) == 0 && Double.compare(shape.size, size) == 0 && color.equals(shape.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, size, color);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", size=" + size +
                ", color=" + color +
                '}';
    }

    public abstract void draw(GraphicsContext context);

    public abstract boolean isInsideShape(double mouseX, double mouseY);

    public abstract String svgFormat();


}