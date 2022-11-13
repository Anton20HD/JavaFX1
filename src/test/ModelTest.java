import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.tt.javafx.Model.ShapeModel;

public class ModelTest {

        ShapeModel shapeModel = new ShapeModel();



        @Test
        void testingDefaultColorShape() {


               var actual = shapeModel.getColorPickerChooser();

                var expected = Color.GREEN;

                Assertions.assertEquals(expected,actual);


        }

        @Test
        void testingDefaultShapeSize() {

            var actual = shapeModel.getSizeChooser();

            var expected = "60";

            Assertions.assertEquals(expected,actual);


        }


}
