package com.example.studentdashboard.academicprofile;

import com.example.studentdashboard.cgpadataplot.MonthCount;
import com.example.studentdashboard.database.DatabaseConnection;
import com.example.studentdashboard.querymachine.QueryMachine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcademicProfileTable {
    public ObservableList<AcademicProfileTableData> academicProfileData(Label acProfileStuName,
                                                                        TextField academicProfileRn,
                                                                        TableColumn<AcademicProfileTableData, String> examName,
                                                                        TableColumn<AcademicProfileTableData, Double> englishMarks,
                                                                        TableColumn<AcademicProfileTableData, Double> nepaliMarks,
                                                                        TableColumn<AcademicProfileTableData, Double> mathMarks,
                                                                        TableColumn<AcademicProfileTableData, Double> scienceMarks,
                                                                        TableColumn<AcademicProfileTableData, Double> socialMarks,
                                                                        TableColumn<AcademicProfileTableData, Double> optIMarks,
                                                                        TableColumn<AcademicProfileTableData, Double> optIiMarks,
                                                                        TableColumn<AcademicProfileTableData, Double> acCgpa,
                                                                        TableView<AcademicProfileTableData> academicProfileTable) throws SQLException {
        int rn;
        try {
            rn = Integer.parseInt(academicProfileRn.getText());
            System.out.println(rn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid roll number format. Please enter a valid integer.", e);
        }

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection conn = connectNow.getDBConnect();
        QueryMachine makeQuery = new QueryMachine();
        String query = makeQuery.academicProfileQueryMachine();
        MonthCount count = new MonthCount();
        int totalMonth = count.availableMonth();
        String[] month = {"bm.", "jm.", "am.", "sm.", "bm1.", "am1.", "km.", "mm1.", "pm.", "mm.", "fm.", "cm."};
        String[] realMonth = {"First Exam", "Second Exam", "Third Exam", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Push", "Magh", "Fagun", "Chait"};
        ObservableList<AcademicProfileTableData> list = FXCollections.observableArrayList();

        // Print the query before executing
        System.out.println("Executing query: " + query);

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, rn);
            System.out.println("Setting roll number: " + rn);

            try (ResultSet rst = pst.executeQuery()) {
                if (rst.next()) {
                    acProfileStuName.setText(rst.getString("student_name"));
                    for (int i = 0; i < totalMonth && i < month.length; i++) {
                        list.add(new AcademicProfileTableData(
                                rst.getInt("rn"),
                                realMonth[i],
                                rst.getDouble(month[i] + "english"),
                                rst.getDouble(month[i] + "nepali"),
                                rst.getDouble(month[i] + "math"),
                                rst.getDouble(month[i] + "science"),
                                rst.getDouble(month[i] + "social"),
                                rst.getDouble(month[i] + "opt_i"),
                                rst.getDouble(month[i] + "opt_ii"),
                                rst.getDouble(month[i] + "cgpa")
                        ));
                        System.out.println("Fetched English marks: " + rst.getDouble(month[i]+"english"));
                    }
                } else {
                    throw new SQLException("No data found for the given roll number.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching academic profile data", e);
        }

        // Set CellValueFactory outside the loop
        examName.setCellValueFactory(new PropertyValueFactory<>("examName"));
        englishMarks.setCellValueFactory(new PropertyValueFactory<>("englishMarks"));
        nepaliMarks.setCellValueFactory(new PropertyValueFactory<>("nepaliMarks"));
        mathMarks.setCellValueFactory(new PropertyValueFactory<>("mathMarks"));
        scienceMarks.setCellValueFactory(new PropertyValueFactory<>("scienceMarks"));
        socialMarks.setCellValueFactory(new PropertyValueFactory<>("socialMarks"));
        optIMarks.setCellValueFactory(new PropertyValueFactory<>("optIMarks"));
        optIiMarks.setCellValueFactory(new PropertyValueFactory<>("optIiMarks"));
        acCgpa.setCellValueFactory(new PropertyValueFactory<>("acCgpa"));

        academicProfileTable.setItems(list);
        return list;
    }
}