package com.example.studentdashboard.cgpadataplot;

import com.example.studentdashboard.database.DatabaseConnection;
import com.example.studentdashboard.querymachine.QueryMachine;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayCgpaChart {
    private int baisakh, jeth, asar, saun, bhadau, asoj, kartik, mangsir, push, magh, fagun, chait;

    private String query="";
    String [] month = {"bm.cgpa" , "jm.cgpa", "am.cgpa", "sm.cgpa", "bm1.cgpa", "am1.cgpa", "km.cgpa", "mm1.cgpa", "pm.cgpa", "mm.cgpa", "fm.cgpa", "cm.cgpa"};
    String[] realMonth = {"Baisakh", "Jeth", "Asar", "Saun", "Bhadau", "Asoj", "Kartik", "Mangsir", "Push", "Magh", "Fagun", "Chait"};

    public void displayCgpaChart(LineChart<String, Double> chart, int rnValue) throws SQLException {

//         Counting months
        MonthCount count = new MonthCount();
        int totalMonth = count.availableMonth();


//        This makes dynamic query for cgpa
        QueryMachine query1 = new QueryMachine();
        query = query1.queryMachine();

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();

        PreparedStatement pst = null;
        ResultSet rst = null;

        // Create a series for the chart
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        try {
            pst = connectDB.prepareStatement(query);
            pst.setInt(1,rnValue);
            rst = pst.executeQuery();

            series.setName("CGPA Data");

            System.out.println(month[totalMonth]);
            while(rst.next()) {
                chart.getData().clear();
                int i =0;
                while(i<totalMonth){
//                    System.out.println(rst.getDouble(month[i]));
                    series.getData().add(new XYChart.Data<>(realMonth[i], rst.getDouble(month[i])));
                    i++;
                }
                chart.getData().add(series);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in a finally-block to ensure they are always closed
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (connectDB != null) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
