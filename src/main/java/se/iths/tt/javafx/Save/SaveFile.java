package se.iths.tt.javafx.Save;

import javafx.scene.image.Image;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se.iths.tt.javafx.Model.ShapeModel;
import se.iths.tt.javafx.Shapes.Shape;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SaveFile {

    FileChooser fileChooser = new FileChooser();

    public void save(ShapeModel shapeModel, Stage stage) {
        saveSetUp();
        Path path = fileChooser.showSaveDialog(stage.getOwner()).toPath();
        setSVGToPath(shapeModel, path);


    }

    private void saveSetUp() {
        fileChooser.setTitle("Save SVG file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));

    }

    private void setSVGToPath(ShapeModel shapeModel, Path path) {

        try {
            Files.write(path, SVGToString(shapeModel));
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    private List<String> SVGToString(ShapeModel shapeModel) {

        List<String> svg = new ArrayList<>();
        getSVGString(shapeModel, svg);

        return svg;

    }

    private void getSVGString(ShapeModel shapeModel, List<String> svg) {
        svg.add("<svg width=\"700\" height=\"600\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
        addShapes(svg, shapeModel);
        svg.add("</svg>");


    }

    private void addShapes(List<String> svg, ShapeModel shapeModel) {
        shapeModel.getShapeObservableList().forEach(shape -> addSVGShapes(svg, shape));

    }

    private void addSVGShapes(List<String> svg, Shape shape) {

        svg.add(shape.svgFormat());

    }



}