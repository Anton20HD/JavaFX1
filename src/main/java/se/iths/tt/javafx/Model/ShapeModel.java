package se.iths.tt.javafx.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.tt.javafx.Shapes.ShapeType;
import se.iths.tt.javafx.Shapes.Shape;


import java.util.*;

@FunctionalInterface
interface Command {
    void execute();

}
public class ShapeModel {


    Deque<Command> undoHistory = new ArrayDeque<>();

    public ObservableList<Shape> shapeList;

    public ObservableList<ShapeType> shapeTypesList;

    private final ObjectProperty<Color> colorPickerChooser;

    private final StringProperty sizeChooser;

    private final ObjectProperty<ShapeType> currentShapeType = new SimpleObjectProperty<>(ShapeType.CIRCLE);

    private Color color;

    private double x;
    private double y;


    public ShapeModel() {

        this.sizeChooser = new SimpleStringProperty("60");
        this.colorPickerChooser = new SimpleObjectProperty<>(Color.GREEN);
        this.shapeList = FXCollections.observableArrayList();
        this.shapeTypesList = FXCollections.observableArrayList(ShapeType.values());




    }



    public ObjectProperty<ShapeType> CurrentShapeType() {
            return currentShapeType;


    }

    public ShapeType getCurrentShapeType() {

        return currentShapeType.get();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void addToShapes(Shape shape) {

        if (!(shape == null))
            this.shapeList.add(shape);

    }


    public Color getColorPickerChooser() {
        return colorPickerChooser.get();
    }

    public ObjectProperty<Color> colorPickerChooserProperty() {
        return colorPickerChooser;
    }

    public ObservableList<Shape> getShapeObservableList() {
        return shapeList;
    }

    public void addUndo(Shape shape) {

        Command undo = () ->shapeList.remove(shape);
        undoHistory.push(undo);

    }
    public void undoCommand() {

        Command undo = undoHistory.pop();
        undo.execute();


    }

    public double getShapeSizeAsDoubled() {

        return Double.parseDouble(getSizeChooser());
    }

    public String getSizeChooser() {
        return sizeChooser.get();
    }

    public StringProperty sizeChooserProperty() {
        return sizeChooser;
    }

    public Optional <Shape> checkIfInsideShape() {
            return shapeList.stream()
                    .filter(shape -> shape.isInsideShape(getX(),getY()))
                    .reduce((first,second) -> second);



        }


//    public void selectedShapesContain(Shape shape) {
//            if(shapeList.contains(shape)) {
//                shape.setColor(Color.TRANSPARENT);
//                shapeList.remove(shape);
//
//            }else {
//                shape.setColor(Color.TRANSPARENT);
//                shapeList.add(shape);
//
//            }


//    public void createObjects() {
//
//        Shape createObject = ShapeFactory.creatingShapes
//                (getCurrentShapeType(), getX(), getY(),getColorPickerSelect(), (int) getShapeSizeAsDoubled());
//
//        shapeList.add(createObject);







}
