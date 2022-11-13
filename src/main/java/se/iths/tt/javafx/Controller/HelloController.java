package se.iths.tt.javafx.Controller;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import se.iths.tt.javafx.Model.ShapeModel;
import se.iths.tt.javafx.Save.SaveFile;
import se.iths.tt.javafx.Shapes.Shape;
import se.iths.tt.javafx.Shapes.ShapeFactory;
import se.iths.tt.javafx.Shapes.ShapeType;


public class HelloController {


    public Button eraserButton;
    public Button undoButton;
    public ToggleButton selectMode;
    public TextField sizeChooser;
    public BorderPane scenePane;
    public ColorPicker myColorPicker;
    public GraphicsContext context;
    public Canvas canvas;

    public Stage stage;

    public ChoiceBox<ShapeType> choiceBox;


    ShapeModel model = new ShapeModel();






    public void initialize() {
        context = canvas.getGraphicsContext2D();
        model.getShapeObservableList().addListener((ListChangeListener<Shape>) e -> draw());
        myColorPicker.valueProperty().bindBidirectional(model.colorPickerChooserProperty());
        sizeChooser.textProperty().bindBidirectional(model.sizeChooserProperty());
        choiceBox.setItems(model.shapeTypesList);
        choiceBox.setValue(ShapeType.CIRCLE);
        choiceBox.valueProperty().bindBidirectional(model.CurrentShapeType());


    }


    public void canvasClicked(MouseEvent mouseEvent) {

        mouseModel(mouseEvent);

        if (selectMode.isSelected()) {

            if (choiceBox.getValue().equals(ShapeType.CIRCLE)) {
                updateCircle();
            }
            updateSquare();
            draw();
        } else {
            createShapesOnCanvas();
        }

    }




    public void draw() {

        model.getShapeObservableList().forEach(s -> s.draw(context));

    }

    public void createShapesOnCanvas() {

        Shape shape = ShapeFactory.creatingShapes(model.getCurrentShapeType(), model.getX(), model.getY(), myColorPicker.getValue(), Integer.parseInt(model.getSizeChooser()));
        model.addToShapes(shape);
        model.addUndo(shape);

    }

    public void undoClicked() {

            model.undoCommand();
            eraser();

            model.checkIfInsideShape().ifPresent(shape -> shape.setColor(model.getColorPickerChooser()));
            draw();


    }


    public void save() {

        new SaveFile().save(model,stage);





    }
    public void setStage(Stage stage) {

        this.stage = stage;

    }



    public void updateCircle() {

        if(model.checkIfInsideShape().isEmpty())
            return;

        eraser();
        model.checkIfInsideShape().ifPresent(shape -> shape.setColor(model.getColorPickerChooser()));
        model.checkIfInsideShape().ifPresent(shape -> shape.setSize((int) model.getShapeSizeAsDoubled()));

    }

    public void updateSquare() {

        if(model.checkIfInsideShape().isEmpty())
            return;

        eraser();
        model.checkIfInsideShape().ifPresent(shape -> shape.setColor(model.getColorPickerChooser()));
        model.checkIfInsideShape().ifPresent(shape -> shape.setSize((int) model.getShapeSizeAsDoubled()));
    }





    public void exitAction(ActionEvent actionEvent) {
        Platform.exit();

    }
    private void mouseModel(MouseEvent mouseEvent) {

        model.setX(mouseEvent.getX());
        model.setY(mouseEvent.getY());
    }

    public void eraser() {

        context.setFill(Color.WHITE);
        context.fillRect(0,0,canvas.getWidth(), canvas.getHeight());

    }



}


