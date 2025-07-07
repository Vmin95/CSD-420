module mod7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens mod7 to javafx.fxml;
    exports mod7;
}