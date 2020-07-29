package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.dbconnection.DBConnection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/Main.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Time Table Management System");
        primaryStage.initStyle(StageStyle.UNDECORATED);


        primaryStage.show();
        DBConnection.getInstance();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
