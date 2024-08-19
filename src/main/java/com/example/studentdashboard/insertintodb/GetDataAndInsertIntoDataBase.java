package com.example.studentdashboard.insertintodb;

import com.example.studentdashboard.attendance.AttendanceInfo;
import com.example.studentdashboard.cgpadataplot.MonthCount;
import com.example.studentdashboard.database.DatabaseConnection;
import com.example.studentdashboard.messages.Message;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetDataAndInsertIntoDataBase {
    Message mymessage = new Message();
    public void uploadAttendanceData(TableView<AttendanceInfo> attendanceDataInsertionTable,
                                     ComboBox<String> attMonth,
                                     Label message){
        DatabaseConnection connectNow = new DatabaseConnection();
        try (Connection connectDB = connectNow.getDBConnect()) {

            ObservableList<AttendanceInfo> data = attendanceDataInsertionTable.getItems();
            String month = attMonth.getValue();
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


            String query = "INSERT INTO dev_scl_test2.stu_attendance values(?, ?, ?, ?, ?)";

            try (PreparedStatement pst = connectDB.prepareStatement(query)) {
                for (AttendanceInfo info : data) {
                    pst.setInt(1, info.getRn());
                    pst.setInt(2, month_id);
                    pst.setInt(3, info.getPresentDays());
                    pst.setInt(4, info.getTotalDays());
                    pst.setInt(5, info.getTotalDays()-info.getPresentDays());
                    pst.addBatch();
                }
                pst.executeBatch();

                data.setAll((AttendanceInfo) null);

                mymessage.showMessageAndFadeAway("Data has been uploaded Successfully", message);


            } catch (SQLException e) {
                mymessage.showMessageAndFadeAway("Error executing batch insert: " + e.getMessage(), message);
            }
        } catch (SQLException e) {
            mymessage.showMessageAndFadeAway("Error connecting to database: " + e.getMessage(), message);
        }
    }
}
