package se.iths.tt.javafx;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import se.iths.tt.javafx.Model.ShapeModel;
import se.iths.tt.javafx.Shapes.Shape;
import se.iths.tt.javafx.Shapes.ShapeFactory;


import java.io.File;

public class HelloController {


    public ShapeFactory shapeFactory;
    public Button eraserButton;
    public Button undoButton;

    public Button redoButton;
    public BorderPane scenePane;
    public ColorPicker myColorPicker;
    public ChoiceBox<String> myChoiceBox;
    public GraphicsContext context;
    public Canvas canvas;
    public ShapeModel model;




    public void initialize() {
        context = canvas.getGraphicsContext2D();
        model.getShapeObservableList().addListener((ListChangeListener<Shape>) e -> listChanged());
        myColorPicker.valueProperty().bindBidirectional(model.colorPickerSelectProperty());
    }

    public HelloController() {

        this.model = new ShapeModel();
        this.shapeFactory = new ShapeFactory();
    }

//
//    private int count = 0;
//
//    private final Shape[] shapes = new Shape[30];

    private final String[] menuAlternatives = {"Sparning", "Testing?", "Exit?"};

    public void canvasClicked(MouseEvent mouseEvent) {

        Shape shape = returnNewShapes(model.getCurrentShape(), mouseEvent.getX(), mouseEvent.getY(), myColorPicker.getValue(),50);

        model.addShapes(shape);




    }
    public void listChanged() {

        var context = canvas.getGraphicsContext2D();
        model.getShapeObservableList().forEach(s -> s.draw(context));

    }

    public Shape returnNewShapes(ShapeType shapeType,double x, double y, Color myColorPicker,double size) {


        return ShapeFactory.creatingShapes(shapeType, x,y,myColorPicker,size);
    }



    public void undoClicked() {

        model.addToRedoHistory();
        model.undo();


    }

    public void redo() {

       model.addToUndoHistory();
       model.redo();

    }

    public void handleClick() {

        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(scenePane.getScene().getWindow());




    }


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
