package se.iths.tt.javafx.Shapes;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.tt.javafx.ShapeType;

public abstract class Shape {

   private final double x;
   private final double y;
   private final double width;
   private final double height;

   private final SimpleObjectProperty<Color> color = new SimpleObjectProperty<>();



    public Shape(double x, double y, double width, double height,Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public double getWidth() {
        return width;
    }

//    public void setWidth(double width) {
//        this.width = width;
//    }

    public double getHeight() {
        return height;
    }

//    public void setHeight(double height) {
//        this.height = height;
//    }


    public SimpleObjectProperty<Color> colorProperty() {
        return color;
    }

    public Color getColor() {
        return color.get();
    }

    public abstract void draw(GraphicsContext context);


    public static Shape creatingShapes(ShapeType type, double x, double y, double height, double width,Color color) {

        return switch (type) {
            case CIRCLE -> new Circle(x, y, width, height,color);
            case RECTANGLE -> new Rectangle(x, y, width, height,color);
        };
    }



}