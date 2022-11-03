package se.iths.tt.javafx;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import se.iths.tt.javafx.Model.shapeModel;
import se.iths.tt.javafx.Shapes.Shape;


import java.util.Arrays;

public class HelloController {


    public Button eraserButton;
    public BorderPane scenePane;
    public ColorPicker myColorPicker;
    public ChoiceBox<String> myChoiceBox;
    public GraphicsContext context;
    public Canvas canvas;
    public shapeModel model;

    public int historyIndex = -1;

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        model.getShapeObservableList().addListener((ListChangeListener<Shape>) e -> listChanged());   //listchanged om inte redraw funkar.
        myColorPicker.valueProperty().bindBidirectional(model.colorPickerSelectProperty());
    }

    public HelloController() {

        this.model = new shapeModel();

    }

//
//    private int count = 0;
//
//    private final Shape[] shapes = new Shape[30];

    private final String[] menuAlternatives = {"Sparning", "Testing?", "Exit?"};

    public void canvasClicked(MouseEvent mouseEvent) {

        Shape shape = Shape.creatingShapes(model.getCurrentShape(),mouseEvent.getX(),mouseEvent.getY(),50,50,myColorPicker.getValue());

        model.addShapes(shape);
//        redraw();
        listChanged();

//        shapes[count] = shape;
//        count++;
      //  paintCanvas();

    }
    public void listChanged() {

        var context = canvas.getGraphicsContext2D();

        for (Shape s : model.getShapeObservableList()) {
            s.draw(context);
        }

    }
//    public void redraw() {
//
//        GraphicsContext context = canvas.getGraphicsContext2D();
//
//
//        context.clearRect(0, 0, canvas.getWidth(),canvas.getHeight());
//        for (int i = 0; i <= historyIndex; i++) {
//            model.getShapeObservableList().get(i).draw(context);
//
//
//        }
//    }


//
//    public void undo() {
//
//        if(historyIndex >= 0) {
//            historyIndex--;
//            redraw();
//        }
//
//
//    }

//    public void redo() {
//
//        if(historyIndex < model.getShapeObservableList().size()-1) {
//            historyIndex++;
//            model.getShapeObservableList(),(historyIndex).
//        }
//
//    }


    public void onCircleClicked(ActionEvent e) {

        model.setCurrentShape(ShapeType.CIRCLE);


    }

    public void onRectangleClicked(ActionEvent e) {


        model.setCurrentShape(ShapeType.RECTANGLE);

    }

    public void exitAction(ActionEvent actionEvent) {
        Platform.exit();

    }

    public void eraser() {

        context.setFill(Color.WHITE);
        context.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
       // context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }



}




//
//    public void createCircle(ActionEvent event) {
//
//        context.setFill(Color.BLUE);
//        context.fillOval(200,200,200,200);
//
//

//    public void changeColor(ActionEvent event) {
//
//
//        colorFill.setOnAction(e -> {
//            context.setFill(colorFill.getValue());
//        });
//
//        Color myColor = myColorPicker.getValue();
//        scenePane.setBackground(new Background(new BackgroundFill(myColor, null, null)));





//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        myChoiceBox.getItems().addAll(menuAlternatives);
//
//    }

//    public void paintCanvas() {
//
//        GraphicsContext context = canvas.getGraphicsContext2D();
//        context.setFill(Color.WHITE);
//        context.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
//        Arrays.stream(shapes, 0, count).forEach(s -> s.draw(context));
//
//
//    }
