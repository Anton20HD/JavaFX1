package se.iths.tt.javafx.Model;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.tt.javafx.ShapeType;
import se.iths.tt.javafx.Shapes.Shape;
import se.iths.tt.javafx.Shapes.ShapeFactory;


import java.util.*;

public class ShapeModel {


   // Stack<Shape> undoHistory = new Stack<>();
  //  Stack<Shape> redoHistory = new Stack<>();

//    private final Deque<Deque<Shape>> undoHistory;
//    private final Deque<Deque<Shape>> redoHistory;


    private final ObservableList<Shape> shapeList;
    private final ObjectProperty<Color> colorPickerSelect;

    private final int historyIndex = -1;
    private ShapeType currentShape;

    public ShapeModel() {

        this.undoHistory = new ArrayDeque<>();
        this.redoHistory = new ArrayDeque<>();
        this.colorPickerSelect = new SimpleObjectProperty<>(Color.GREEN);
        this.shapeList = FXCollections.observableArrayList(shape -> new Observable[]{
                shape.colorProperty()


        });
    }


    public ShapeType getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(ShapeType currentShape) {
        this.currentShape = currentShape;
    }


    public void addShapes(Shape shape) {

        if (!(shape == null))
            this.shapeList.add(shape);

    }


    public Color getColorPickerSelect() {
        return colorPickerSelect.get();
    }

    public ObjectProperty<Color> colorPickerSelectProperty() {
        return colorPickerSelect;
    }

    public ObservableList<Shape> getShapeObservableList() {
        return shapeList;
    }

    public Deque<Deque<Shape>> getUndoHistory() {


        return undoHistory;
    }

    public Deque<Deque<Shape>> getRedoHistory() {
        return redoHistory;
    }


    public Deque<Shape> getTempList() {
        Deque<Shape> tempList = new ArrayDeque<>();
        getShapeObservableList().forEach(shape -> tempList.add(shape.getShapeCopy()));
            return tempList;


    }

    public void addToUndoHistory() {
        undoHistory.add(getTempList());

    }

    public void addToRedoHistory() {
        redoHistory.add(getTempList());


    }


    public void undo() {

        if(undoHistory.isEmpty())
            return;

        addToRedoHistory();
        shapeList.clear();
        shapeList.addAll(undoHistory.removeLast());







    }
    public void redo() {

        if(redoHistory.isEmpty())
            return;

        addToUndoHistory();
        shapeList.clear();
        shapeList.addAll(redoHistory.removeLast());
    }


}


