package com.example.studentdashboard.attendance;

import com.example.studentdashboard.database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceTableInsertion {
    public ObservableList<AttendanceInfo> attendanceData(TableColumn <AttendanceInfo, Integer> fetchRn,
                                                         TableColumn<AttendanceInfo, String> tableStuName,
                                                         TableColumn<AttendanceInfo, Integer> insertPresentDay,
                                                         TableView<AttendanceInfo> attendanceTable,
                                                         TextField totalDaysInMonth
                                                         ) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection conn = connectNow.getDBConnect();

        ObservableList<AttendanceInfo> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT rn, student_name from dev_scl_test2.student_detail");
            int totalDays = Integer.parseInt(totalDaysInMonth.getText());
            int presentDays = 0;

            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
//                Storing the data into lists
                list.add(new AttendanceInfo(rst.getInt("rn"),
                        rst.getString("student_name"),
                        totalDays
                        ));

//                Pulling the data in list and placing into our table
                fetchRn.setCellValueFactory(new PropertyValueFactory<AttendanceInfo, Integer>("rn"));
                tableStuName.setCellValueFactory(new PropertyValueFactory<AttendanceInfo, String>("tableStuName"));
                insertPresentDay.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter())); //making editable cells
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        attendanceTable.setItems(list);
        return list;
    }
}
