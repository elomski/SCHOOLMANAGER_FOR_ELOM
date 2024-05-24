package  com.example.schoolmanager.controllers;

import com.example.schoolmanager.db.IDBConfig;
import com.example.schoolmanager.models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private ComboBox<String> classromIdCol;

    @FXML
    private DatePicker dateofbirthCol;

    @FXML
    private TextField firstnameCol;

    @FXML
    private TextField lastnameCol;

    @FXML
    private TextField placeofbirthCol;

    @FXML
    private ComboBox<String> stateCol;

    private Connection connection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            connection = IDBConfig.getConnection();
            if (this.connection != null) {
                String req = "SELECT * FROM classrom";
                PreparedStatement preparedStatement = this.connection.prepareStatement(req);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    classromIdCol.getItems().add(String.valueOf(resultSet.getInt("id")));
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        stateCol.getItems().add("O");
        stateCol.getItems().add("1");
        stateCol.getItems().add("2");

    }


    public void create(){

        String firstname = firstnameCol.getText();
        String lastname  = lastnameCol.getText();
        Date dateOfBirth = Date.valueOf(dateofbirthCol.getValue());
        String placeOfBirth = placeofbirthCol.getText();
        int state = Integer.parseInt(stateCol.getValue());
        int classromId = Integer.parseInt(classromIdCol.getValue());

        Student student = new Student();

        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setDateOfBirth(dateOfBirth);
        student.setPlaceOfBirth(placeOfBirth);
        student.setState(state);
        student.setClassromId(classromId);

        student.create(student);

    }
}
