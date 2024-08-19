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

public class GetMarksAndInsertIntoDataBase {
    MonthCount monthCount = new MonthCount();
    Message mymessage = new Message();
    public void uploadMarksTable(TableView<MarkInfo> marksEntryTable,
                                 ComboBox<String> marksEntryMonth,
                                 Label message){
        DatabaseConnection connectNow = new DatabaseConnection();

        String [] months = {"baisakh_marks", "jeth_marks", "asar_marks", "saun_marks", "bhadau_marks", "asoj_marks", "kartik_marks", "mangsir_marks",
        "push_marks", "magh_marks", "fagun_marks", "chait_marks"};
        try (Connection connectDB = connectNow.getDBConnect()) {

            ObservableList<MarkInfo> data = marksEntryTable.getItems();
            String month = marksEntryMonth.getValue();
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
            String query = "INSERT INTO dev_scl_test2."+ months[month_id-1]+" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = connectDB.prepareStatement(query)) {
                for (MarkInfo info : data) {
                    pst.setInt(1, info.getRn());
                    pst.setInt(2, month_id);
                    pst.setDouble(3, info.getEnglishMark());
                    pst.setDouble(4, info.getNepaliMark());
                    pst.setDouble(5, info.getMathMark());
                    pst.setDouble(6, info.getScienceMark());
                    pst.setDouble(7, info.getSocialMark());
                    pst.setDouble(8, info.getOptIMark());
                    pst.setDouble(9, info.getOptIiMark());
                    pst.setDouble(10,info.getcGpa());
                    System.out.println("CGPA is : "+ info.getcGpa());
                    pst.addBatch();
                }


                pst.executeBatch();
                data.setAll((MarkInfo) null);
                    mymessage.showMessageAndFadeAway("Data has been uploaded Successfully", message);
            }
            catch (SQLException e) {
                mymessage.showMessageAndFadeAway("Error executing batch insert: " + e.getMessage(), message);
            }
        } catch (SQLException e) {
            mymessage.showMessageAndFadeAway("Error connecting to database: " + e.getMessage(), message);
        }
    }
}
