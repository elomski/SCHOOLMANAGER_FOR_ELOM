package com.example.schoolmanager.models;

import com.example.schoolmanager.db.IDBConfig;
import com.example.schoolmanager.interfaces.StudentInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student implements StudentInterface {

    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String placeOfBirth;
    private int state;
    private int classromId;
    private Connection connection;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getClassromId() {
        return classromId;
    }

    public void setClassromId(int classromId) {
        this.classromId = classromId;
    }

    @Override
    public void create(Student student) {
        try {
            connection = IDBConfig.getConnection();

            if (this.connection != null) {

                String request = "INSERT INTO student(firstname, lastname, dateOfBirth, placeOfBirth, state, classromId) VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = this.connection.prepareStatement(request);
                preparedStatement.setString(1, firstname);
                preparedStatement.setString(2, lastname);
                preparedStatement.setDate(3, dateOfBirth);
                preparedStatement.setString(4, placeOfBirth);
                preparedStatement.setInt(5, state);
                preparedStatement.setInt(6, classromId);

                preparedStatement.executeUpdate();
                preparedStatement.close();
                this.connection.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
