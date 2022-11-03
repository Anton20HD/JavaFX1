package se.iths.tt.javafx.Model;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.tt.javafx.ShapeType;
import se.iths.tt.javafx.Shapes.Shape;

public class shapeModel {

    private final ObservableList<Shape> shapeList;
    private final ObjectProperty<Color> colorPickerSelect;


//ObservableList<Shape> shapes =FXCollections.observableArrayList(shape -> new Observable[]{shape.colorProperty()});
//ObjectProperty<Color> colorPickerSelect = new SimpleObjectProperty<>(Color.GREEN);

private ShapeType currentShape;

    public shapeModel() {

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

        if(!(shape == null))
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
}
