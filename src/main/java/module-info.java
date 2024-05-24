module com.example.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.schoolmanager to javafx.fxml;
    exports com.example.schoolmanager;

    opens com.example.schoolmanager.controllers to javafx.fxml;
    exports com.example.schoolmanager.controllers;

    opens com.example.schoolmanager.models to javafx.base;
    exports com.example.schoolmanager.models;


}