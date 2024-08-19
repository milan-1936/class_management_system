package com.example.studentdashboard.insertintodb;

import com.example.studentdashboard.database.DatabaseConnection;
import com.example.studentdashboard.messages.Message;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class AddNewStudentIntoDataBase {

    FileInputStream fileInputStream;
    public void insertIntoDb(TextField stuRnInput,
                             TextField stuNameInput,
                             TextField stuSectionInput,
                             ComboBox<String> selectGender,
                             TextField bcnInput,
                             TextField emisInput,
                             DatePicker dobInput,
                             TextField fatherNameInput,
                             TextField motherNameInput,
                             TextField contactInput,
                             TextField addressInput,
                             TextField problemInput,
                             ComboBox<String> bgInput,
                             DatePicker dojInput,
                             ComboBox<String> religionInput,
                             TextField castInput,
                             TextField prevSclInput,
                             TextField cojInput,
                             TextField houseInput,
                             Label message,
                             ImageView choosedImage,
                             Button chooseImage,
                             File file){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();

        PreparedStatement preparedStatement = null;
        String insertQuery = "INSERT INTO dev_scl_test2.student_detail " +
                "(rn, student_name, student_img, section, gender, b_c_n, emis_code, d_o_b, " +
                "father_name, mother_name, contact, address, problem, b_group, d_o_j, religion, " +
                "cast, prev_scl, c_o_j, house) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connectDB.prepareStatement(insertQuery);

            // Set parameters
            preparedStatement.setInt(1, Integer.parseInt(stuRnInput.getText()));
            preparedStatement.setString(2, stuNameInput.getText());

            // Debug: Check image data
            fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(3, fileInputStream, (int) file.length());
            preparedStatement.setString(4, stuSectionInput.getText());
            preparedStatement.setString(5, selectGender.getValue());
            preparedStatement.setString(6, bcnInput.getText());
            preparedStatement.setString(7, emisInput.getText());
            preparedStatement.setString(8, dobInput.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStatement.setString(9, fatherNameInput.getText());
            preparedStatement.setString(10, motherNameInput.getText());
            preparedStatement.setString(11, contactInput.getText());
            preparedStatement.setString(12, addressInput.getText());
            preparedStatement.setString(13, problemInput.getText());
            preparedStatement.setString(14, bgInput.getValue());
            preparedStatement.setString(15, dojInput.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStatement.setString(16, religionInput.getValue());
            preparedStatement.setString(17, castInput.getText());
            preparedStatement.setString(18, prevSclInput.getText());
            preparedStatement.setString(19, cojInput.getText());
            preparedStatement.setString(20, houseInput.getText());
            preparedStatement.addBatch();

            // Execute the update
            preparedStatement.executeBatch();

            // Success message
            Message mymessage = new Message();
            mymessage.showMessageAndFadeAway("Data Insertion Successful", message);

            // Clear all the mentioned input Fields
            clearInputFields(stuRnInput, stuNameInput, stuSectionInput, selectGender, bcnInput, emisInput, dobInput, fatherNameInput, motherNameInput, contactInput, addressInput, problemInput, bgInput, dojInput, religionInput, castInput, prevSclInput, cojInput, houseInput, choosedImage);

        } catch (SQLException e) {
            e.printStackTrace(); // Log detailed error information
            throw new RuntimeException("Database error occurred: " + e.getMessage(), e);
        } catch (NullPointerException e) {
            Message err = new Message();
            err.showMessageAndFadeAway("खै त फोटो हालेको", message);
            throw new NullPointerException();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // Ensure resources are closed
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connectDB != null) connectDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //    method to choose file and have image data into binary format

    //  method to clear all the input fields after inserting data into database
    private void clearInputFields(TextField stuRnInput,
                                  TextField stuNameInput,
                                  TextField stuSectionInput,
                                  ComboBox<String> selectGender,
                                  TextField bcnInput,
                                  TextField emisInput,
                                  DatePicker dobInput,
                                  TextField fatherNameInput,
                                  TextField motherNameInput,
                                  TextField contactInput,
                                  TextField addressInput,
                                  TextField problemInput,
                                  ComboBox<String> bgInput,
                                  DatePicker dojInput,
                                  ComboBox<String> religionInput,
                                  TextField castInput,
                                  TextField prevSclInput,
                                  TextField cojInput,
                                  TextField houseInput,
                                  ImageView choosedImage) {
        stuRnInput.clear();
        stuNameInput.clear();
        choosedImage.setImage(null);
        stuSectionInput.clear();
        selectGender.getItems().add("Gender");
        bcnInput.clear();
        emisInput.clear();
        dobInput.setValue(null);
        fatherNameInput.clear();
        motherNameInput.clear();
        contactInput.clear();
        addressInput.clear();
        problemInput.clear();
        bgInput.getItems().add("Blood Group");
        dojInput.setValue(null);
        religionInput.getItems().add("Religion");
        castInput.clear();
        prevSclInput.clear();
        cojInput.clear();
        houseInput.clear();
    }

}
