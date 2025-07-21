package mod10;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    //initialize UI
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 610, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        String styleSheet = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(styleSheet);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
