package com.example.studentdashboard.academicprofile;

import com.example.studentdashboard.cgpadataplot.MonthCount;
import com.example.studentdashboard.database.DatabaseConnection;
import com.example.studentdashboard.querymachine.QueryMachine;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcademicProfileChart {

    String[] realMonth = {"First Exam", "Second Exam", "Third Exam", "Fourth Exam", "Fifth Exam", "Sixth Exam", "Kartik", "Mangsir", "Push", "Magh", "Fagun", "Chait"};
    String query="";

    public void displayAcademicSubjectChart(ComboBox<String> selectSubject,TextField academicProfileRn, LineChart<String, Double> eachSubjectChart) throws SQLException {

//         Counting months
        MonthCount count = new MonthCount();
        int totalMonth = count.availableMonth();

        String [] subject = {"english", "nepali", "math", "science", "social", "opt_i", "opt_ii"};
        String [] month = {"bm." , "jm.", "am.", "sm.", "bm1.", "am1.", "km.", "mm1.", "pm.", "mm.", "fm.", "cm."};
//        This makes dynamic query for cgpa
        QueryMachine query1 = new QueryMachine();
        query = query1.academicProfileQueryMachine();
        // Create a series for the chart
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        int rnValue = Integer.parseInt(academicProfileRn.getText());
        int k =-1;
        if(selectSubject.getValue().equals("English")){
            k=0;
            series.setName("English");
        } else if (selectSubject.getValue().equals("Nepali")) {
            k=1;
            series.setName("Nepali");
        } else if (selectSubject.getValue().equals("Math")){
            k=2;
            series.setName("Math");
        } else if(selectSubject.getValue().equals("Science")){
            k=3;
            series.setName("Science");
        } else if(selectSubject.getValue().equals("Social")){
            k=4;
            series.setName("Social");
        } else if(selectSubject.getValue().equals("Opt I")){
            k=5;
            series.setName("Optional I");
        } else if(selectSubject.getValue().equals("Opt II")){
            k=6;
            series.setName("Optional II");
        }
        if(k!=-1){

        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();

        PreparedStatement pst = null;
        ResultSet rst = null;


        try {
            pst = connectDB.prepareStatement(query);
            pst.setInt(1,rnValue);
            rst = pst.executeQuery();

            System.out.println(month[totalMonth]);
            while(rst.next()) {
                eachSubjectChart.getData().clear();
                int i =0;
                while(i<totalMonth){
//                    System.out.println(rst.getDouble(month[i]));
                    series.getData().add(new XYChart.Data<>(realMonth[i], rst.getDouble(month[i]+subject[k])));
                    i++;
                }
                    eachSubjectChart.getData().add(series);
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
