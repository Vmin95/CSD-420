/*
 *Julia Gonzalez 
 * Module 10.2
 * 7/20/25
 * CSD420
 */

module mod10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens mod10 to javafx.fxml;
    exports mod10;
}