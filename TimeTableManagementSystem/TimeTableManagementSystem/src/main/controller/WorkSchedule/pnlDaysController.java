package main.controller.WorkSchedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class pnlDaysController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnAdd;

    @FXML
    private BorderPane pnlMain;

    @FXML
    void handleEvents(ActionEvent event) {

        try {
            if (event.getSource() == btnAdd) {
                pnlMain.getChildren().removeAll();
                Parent root = FXMLLoader.load(getClass().getResource("../../views/WorkSchedule/WorkingDays.fxml"));
                pnlMain.setCenter(root);
            } else if (event.getSource() == btnDelete) {
                pnlMain.getChildren().removeAll();
                Parent root = FXMLLoader.load(getClass().getResource("../../views/WorkSchedule/WorkingDaysDelete.fxml"));
                pnlMain.setCenter(root);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlMain.getChildren().removeAll();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../../views/WorkSchedule/WorkingDays.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pnlMain.setCenter(root);
    }
}