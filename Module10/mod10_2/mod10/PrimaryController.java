package mod10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PrimaryController {
    // Database connection details
    static String url = "jdbc:mysql://localhost:3306/databasedb";
    static String user = "student1";
    static String pass = "pass";

    // FXML fields linked to UI elements
    @FXML
    private TextField ID;                // Input field for user to provide an ID for searching/updating
    @FXML
    private TextField idField;           // Displays the fan's ID from the database
    @FXML
    private TextField firstNameField;    // Displays or updates the fan's first name
    @FXML
    private TextField lastNameField;     // Displays or updates the fan's last name
    @FXML 
    private TextField favoriteTeamField; // Displays or updates the fan's favorite team

    /**
     * This method is triggered by the UI to retrieve and display a fan's information 
     * from the database based on the entered ID.
     */
    @FXML
    private void display() {
        try {
            // Connect to the database
            Connection con = DriverManager.getConnection(url, user, pass);
            
            // Create a statement for executing SQL queries
            Statement stmt = con.createStatement();
            
            // Query the fans table for a record matching the entered ID
            ResultSet rs = stmt.executeQuery("SELECT * FROM fans WHERE ID = " + ID.getText());

            // Iterate through the result set (should be at most one record)
            while (rs.next()) {
                // Retrieve values from the result set
                int id = rs.getInt("id");
                String first = rs.getString("FIRSTNAME");
                String last = rs.getString("LASTNAME");
                String favorite = rs.getString("FAVORITETEAM");

                // Set the UI fields with retrieved values
                idField.setText(String.valueOf(id));
                firstNameField.setText(first);
                lastNameField.setText(last);
                favoriteTeamField.setText(favorite);
            }
            
        } catch (SQLException e) {
            // Print any SQL-related errors
            System.out.print(e);
        }
    }

    /**
     * This method updates the fan's information in the database 
     * for the given ID with the new values entered in the UI fields.
     */
    @FXML
    private void update() {
        try {
            // Establish database connection
            Connection con = DriverManager.getConnection(url, user, pass);
            
            // Prepare the SQL UPDATE statement with placeholders (?)
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE fans SET FIRSTNAME = ?, LASTNAME= ?, FAVORITETEAM = ? WHERE ID = ?"
            );
            
            // Bind parameters to the prepared statement
            stmt.setString(4, ID.getText());                 // WHERE ID = ?
            stmt.setString(1, firstNameField.getText());     // FIRSTNAME = ?
            stmt.setString(2, lastNameField.getText());      // LASTNAME = ?
            stmt.setString(3, favoriteTeamField.getText());  // FAVORITETEAM = ?

            // Execute the UPDATE command
            stmt.executeUpdate();

            // Show confirmation alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Database updated");
            alert.show();

            // Clear the input fields after successful update
            idField.clear();
            firstNameField.clear();
            lastNameField.clear();
            favoriteTeamField.clear();
            ID.clear();

        } catch (Exception e) {
            // Print any exceptions (SQL or otherwise)
            System.out.print(e);
        }
    }
}