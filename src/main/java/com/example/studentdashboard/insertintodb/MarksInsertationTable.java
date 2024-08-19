package com.example.studentdashboard.insertintodb;

import com.example.studentdashboard.database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksInsertationTable {
    public ObservableList<MarkInfo> marksData(TableColumn<MarkInfo, Integer> fetchRn1,
                                                         TableColumn<MarkInfo, String> fetchStuName1,
                                                         TableColumn<MarkInfo, Double> englishMark,
                                                         TableColumn<MarkInfo, Double> nepaliMark,
                                                         TableColumn<MarkInfo, Double> mathMark,
                                                         TableColumn<MarkInfo, Double> scienceMark,
                                                         TableColumn<MarkInfo, Double> socialMark,
                                                         TableColumn<MarkInfo, Double> optIMark,
                                                         TableColumn<MarkInfo, Double> optIiMark,
                                                         TableView<MarkInfo> marksEntryTable,
                                                         TextField fullMarks) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection conn = connectNow.getDBConnect();

        ObservableList<MarkInfo> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT rn, student_name from dev_scl_test2.student_detail");

            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                list.add(new MarkInfo( rst.getInt("rn"),
                        rst.getString("student_name"),
                        Integer.parseInt(fullMarks.getText())));
                fetchRn1.setCellValueFactory(new PropertyValueFactory<MarkInfo, Integer>("rn"));
                fetchStuName1.setCellValueFactory(new PropertyValueFactory<MarkInfo, String>("studentName"));
                englishMark.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                nepaliMark.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                mathMark.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                scienceMark.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                socialMark.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                optIMark.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                optIiMark.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        marksEntryTable.setItems(list);
        return list;
    }
}
