package com.example.studentdashboard.attendance;

import com.example.studentdashboard.database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceTable {
    public ObservableList<AttendanceInfo> attendanceData(TableColumn<AttendanceInfo, String> tableStuName,
                                                                   TableColumn<AttendanceInfo, Integer> presentDays,
                                                                   TableColumn<AttendanceInfo, Integer> absentDays,
                                                                   TableColumn<AttendanceInfo, Integer> totalDays,
                                                                   TableView<AttendanceInfo> attendanceTable,
                                                                   ComboBox<String> selectMonthAtt) {
        String month = selectMonthAtt.getValue();
        int month_id = switch (month) {
            case "Baisakh" -> 1;
            case "Jestha" -> 2;
            case "Asar" -> 3;
            case "Sawan" -> 4;
            case "Bhadra" -> 5;
            case "Ashoj" -> 6;
            case "Kartik" -> 7;
            case "Mangsir" -> 8;
            case "Push" -> 9;
            case "Magh" -> 10;
            case "Fagun" -> 11;
            default -> 12;
        };

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection conn = connectNow.getDBConnect();

        ObservableList<AttendanceInfo> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT sd.rn, sd.student_name, sa.present_days, sa.absent_days, sa.total_days " +
                    "FROM dev_scl_test2.stu_attendance sa " +
                    "INNER JOIN dev_scl_test2.student_detail sd ON ( sd.rn = sa.rn  ) " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = sa.month_id  )" +
                    "WHERE sa.month_id = ?;");
            pst.setInt(1, month_id);

            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                list.add(new AttendanceInfo(rst.getInt("sd.rn"),
                                            rst.getString("sd.student_name"),
                                            rst.getInt("sa.present_days"),
                                            rst.getInt("sa.absent_days"),
                                            rst.getInt("sa.total_days")));
                tableStuName.setCellValueFactory(new PropertyValueFactory<AttendanceInfo, String>("tableStuName"));
                presentDays.setCellValueFactory(new PropertyValueFactory<AttendanceInfo, Integer>("presentDays"));
                absentDays.setCellValueFactory(new PropertyValueFactory<AttendanceInfo, Integer>("absentDays"));
                totalDays.setCellValueFactory(new PropertyValueFactory<AttendanceInfo, Integer>("totalDays"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        attendanceTable.setItems(list);
        return list;


    }
}
