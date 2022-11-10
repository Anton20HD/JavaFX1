package se.iths.tt.javafx.Shapes;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

   private final double x;
   private final double y;

   private final double size;

   private final SimpleObjectProperty<Color> color = new SimpleObjectProperty<>();



    public Shape(double x, double y, Color color, double size) {
        this.x = x;
        this.y = y;
        this.size = size;

        setColor(color);

    }



//    public void creatingShapes(double x, double y, int width, int height) {
//
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//
//    }

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

//    public void setY(double y) {
//        this.y = y;
//    }

    public double getSize() {
        return size;
    }


    public SimpleObjectProperty<Color> colorProperty() {
        return color;
    }

    public Color getColor() {
        return color.get();
    }

    public abstract void draw(GraphicsContext context);

    public abstract Shape getShapeCopy();

}