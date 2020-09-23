package main.controller.Location;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.model.*;
import main.service.BuildingService;
import main.service.LecturerService;
import main.service.PrefLecturerService;
import main.service.PrefTagService;
import main.service.impl.BuildingServiceImpl;
import main.service.impl.LectureServiceImpl;
import main.service.impl.PrefLecturerServiceImpl;
import main.service.impl.PrefTagServiceImpl;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddPrefLecturerController implements Initializable {

    @FXML
    private TextField txtLecOpt;

    @FXML
    private Button btnSaveLecOptions;

    @FXML
    private TextField txtRoomOpt1;



    private ArrayList<Lecturer> lecturerId = new ArrayList<>();
    private ArrayList<String> lecturerName = new ArrayList<>();
    private AutoCompletionBinding<String> autoCompletionBinding;
    private ArrayList<String> roomName = new ArrayList<>();
    private AutoCompletionBinding<String> autoCompletionBinding2;

    private PrefLecturerService prefLecturerService;

    public AddPrefLecturerController() {
        this.prefLecturerService = new PrefLecturerServiceImpl();
    }

    @FXML
    void getBuildingId(ActionEvent event) {
        String lecturer = txtLecOpt.getText();
        System.out.println("ccccccccccccc:"+lecturer);
        try {
            PrefLecturerService lecturerService = new PrefLecturerServiceImpl();

            int buildingId = lecturerService.getBuildingIdFromLecturer(lecturer);

            ArrayList<Room> list = lecturerService.getRoomNamesFromRooms(buildingId);

            for (Room room : list
            ) {
                roomName.add(room.getRoom());
            }

            if(autoCompletionBinding2!=null){
                autoCompletionBinding2.dispose();
            }
            autoCompletionBinding2  = TextFields.bindAutoCompletion(txtRoomOpt1, roomName);

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void getLecturer() {
        LecturerService lecturerService = new LectureServiceImpl();

        ArrayList<Lecturer> list = null;
        try {
            list = lecturerService.getAllLecturerDetails();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lecturerId = new ArrayList<>();
        lecturerName = new ArrayList<>();

        for (Lecturer lecturer : list
        ) {
            lecturerId.add(lecturer);
            lecturerName.add(lecturer.getEmpName());
        }
        for (String lecturer : lecturerName
        ) {
            System.out.println(lecturer);
        }
        if(autoCompletionBinding!=null){
            autoCompletionBinding.dispose();
        }
        autoCompletionBinding  = TextFields.bindAutoCompletion(txtLecOpt, lecturerName);

    }

    @FXML
    void saveRoomLecturer(ActionEvent event) throws SQLException {

//        System.out.println("wwwww");
        String lecturer = txtLecOpt.getText();
        String room = txtRoomOpt1.getText();

        int lecturerId=0;
        int roomId=0;

            if(room != null) {
                    roomId = prefLecturerService.getRoomId(room);
                    System.out.println("wwwwwROOMID:" + roomId);

            }else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle(null);
                al.setContentText("Please Select Room! ");
                al.setHeaderText(null);
                al.showAndWait();
            }


        if(lecturer != null) {
            lecturerId = prefLecturerService.getLecturerIdFromLecturers(lecturer);
            System.out.println("wwwwwTAGID:" + lecturerId);
        }else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle(null);
            al.setContentText("Please Select Lecturer !");
            al.setHeaderText(null);
            al.showAndWait();
        }

        prefLecturer prefLecturer = new prefLecturer();
        prefLecturer.setEmployeeId(lecturerId);
        prefLecturer.setRoomId(roomId);

        boolean isAdded = false;

                if(lecturer != null){
                    if(room != null){

                        isAdded = this.prefLecturerService.savePrefLecturerRoom(prefLecturer);
                        if (isAdded) {

                            Alert al = new Alert(Alert.AlertType.INFORMATION);
                            al.setTitle(null);
                            al.setContentText("Added Successfully!!!");
                            al.setHeaderText(null);
                            al.showAndWait();
//                            this.getAllDetails();
                        } else {
                            Alert al = new Alert(Alert.AlertType.ERROR);
                            al.setTitle(null);
                            al.setContentText("Added Failed!!!");
                            al.setHeaderText(null);
                            al.showAndWait();
                        }
                    }else {
                        Alert al = new Alert(Alert.AlertType.ERROR);
                        al.setTitle(null);
                        al.setContentText("Please Select Room!!");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                }else {
                    Alert al = new Alert(Alert.AlertType.ERROR);
                    al.setTitle(null);
                    al.setContentText("Please Select Lecturer!!");
                    al.setHeaderText(null);
                    al.showAndWait();
                }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.getLecturer();
    }
}
