module se.iths.tt.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.tt.javafx to javafx.fxml;
    exports se.iths.tt.javafx;
    opens se.iths.tt.javafx.Shapes to javafx.fxml;
    exports se.iths.tt.javafx.Shapes;
    exports se.iths.tt.javafx.Model;
    opens se.iths.tt.javafx.Model to javafx.fxml;
}