package com.example.studentdashboard;

import com.example.studentdashboard.academicprofile.AcademicProfileChart;
import com.example.studentdashboard.academicprofile.AcademicProfileTableData;
import com.example.studentdashboard.academicprofile.AcademicProfileTable;
import com.example.studentdashboard.attendance.AttendanceInfo;
import com.example.studentdashboard.attendance.AttendanceTableInsertion;
import com.example.studentdashboard.attendance.AttendanceTable;
import com.example.studentdashboard.cgpadataplot.DisplayCgpaChart;
import com.example.studentdashboard.database.DatabaseConnection;
import com.example.studentdashboard.insertintodb.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import java.sql.*;

@SuppressWarnings("CallToPrintStackTrace")
public class HelloController implements Initializable {
    @FXML
    private TableColumn<AttendanceInfo, String> tableStuName;

    @FXML
    private TableColumn<AttendanceInfo, Integer> presentDays;

    @FXML
    private TableColumn<AttendanceInfo, Integer> absentDays;

    @FXML
    private TableColumn<AttendanceInfo, Integer> totalDays;

    @FXML
    private TableView<AttendanceInfo> attendanceTable;

    @FXML
    private Label addressData;

    @FXML
    private Label bgData;

    @FXML
    private Label birthCertificateData;

    @FXML
    private Label castData;

    @FXML
    private LineChart<String, Double> chart;

    @FXML
    private Label cojData;

    @FXML
    private Label contactNumberData;

    @FXML
    private Label dobData;

    @FXML
    private Label dojData;

    @FXML
    private LineChart<String, Double> eachSubjectChart;

    @FXML
    private Label emisData;

    @FXML
    private Label fatherNameData;

    @FXML
    private Label genderData;

    @FXML
    private Label houseData;

    @FXML
    private Label motherNameData;

    @FXML
    private Label prevSclData;

    @FXML
    private Label problemData;

    @FXML
    private Label religionData;

    @FXML
    private Label sectionData;

    @FXML
    private ImageView stuImage;

    @FXML
    private Label stuName;

    @FXML
    private Label acProfileStuName;

    @FXML
    private Label rank;

    @FXML
    private Label totalAtt;

    @FXML
    private TextField rollData;

    @FXML
    private ComboBox<String> selectMonth;

    @FXML
    public FileInputStream fileInputStream;

    @FXML
    private ImageView choosedImage;

    @FXML
    private Button chooseImage;

    @FXML
    private TextField stuNameInput;

    @FXML
    private ComboBox<String> selectGender;

    @FXML
    private TextField stuSectionInput;

    @FXML
    private TextField bcnInput;

    @FXML
    private TextField emisInput;

    @FXML
    private DatePicker dobInput;

    @FXML
    private TextField fatherNameInput;

    @FXML
    private TextField motherNameInput;

    @FXML
    private TextField contactInput;

    @FXML
    private TextField addressInput;

    @FXML
    private TextField problemInput;

    @FXML
    private ComboBox<String> bgInput;

    @FXML
    private TextField stuRnInput;

    @FXML
    private ComboBox<String> religionInput;

    @FXML
    private DatePicker dojInput;

    @FXML
    private TextField cojInput;

    @FXML
    private TextField castInput;

    @FXML
    private TextField prevSclInput;

    @FXML
    private TextField houseInput;

    @FXML
    private Label message;

    @FXML
    private ComboBox<String> selectSubject;

    @FXML
    private ComboBox<String> selectMonthAtt;

    @FXML
    private TextField academicProfileRn;

    @FXML
    private TableView<AcademicProfileTableData> academicProfileTable;

    @FXML
    private TableColumn<AcademicProfileTableData, String> examName;

    @FXML
    private TableColumn<AcademicProfileTableData, Double> englishMarks;

    @FXML
    private TableColumn<AcademicProfileTableData, Double> nepaliMarks;

    @FXML
    private TableColumn<AcademicProfileTableData, Double> mathMarks;

    @FXML
    private TableColumn<AcademicProfileTableData, Double> scienceMarks;

    @FXML
    private TableColumn<AcademicProfileTableData, Double> socialMarks;

    @FXML
    private TableColumn<AcademicProfileTableData, Double> optIMarks;

    @FXML
    private TableColumn<AcademicProfileTableData, Double> optIiMarks;

    @FXML
    private TableColumn<AcademicProfileTableData, Double> acCgpa;

    @FXML
    private ComboBox<String> attMonth;

    @FXML
    private TableView<AttendanceInfo> attendanceDataInsertionTable;

    @FXML
    private TableColumn<AttendanceInfo, Integer> fetchRn;

    @FXML
    private TableColumn<AttendanceInfo, String> fetchStuName;

    @FXML
    private ComboBox<String> attEntryMonth;

    @FXML
    private TextField totalDaysInMonth;

    @FXML
    private TableColumn<MarkInfo, Integer> fetchRn1;

    @FXML
    private TableColumn<MarkInfo, String> fetchStuName1;

    @FXML
    private TableColumn<MarkInfo, Double> englishMark;

    @FXML
    private TableColumn<MarkInfo, Double> nepaliMark;

    @FXML
    private TableColumn<MarkInfo, Double> mathMark;

    @FXML
    private TableColumn<MarkInfo, Double> scienceMark;

    @FXML
    private TableColumn<MarkInfo, Double> socialMark;

    @FXML
    private TableColumn<MarkInfo, Double> optIMark;

    @FXML
    private TableColumn<MarkInfo, Double> optIiMark;

    @FXML
    private TableColumn<MarkInfo, Double> cGpaMark;

    @FXML
    private TableView<MarkInfo> marksEntryTable;




    @FXML
    private TableColumn<AttendanceInfo, Integer> insertPresentDay;

    @FXML
    private TableColumn<AttendanceInfo, Integer> calculateAbsentDays;

    @FXML
    private TableColumn<AttendanceInfo, Integer> insertTotalDays;


    @FXML
    ComboBox<String> marksEntryMonth;

    @FXML
    TextField fullMarks;

    File file;
    Image image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeComboBox();
        searchName(new ActionEvent());
    }

    @FXML
    public void attendanceData() {
        AttendanceTable attTable = new AttendanceTable();
        attTable.attendanceData(tableStuName, presentDays, absentDays, totalDays, attendanceTable, selectMonthAtt);
    }

    //    method to show data from database in student_dashboard
    public void getDetail(int rnValue) {
//        Creating new DatabaseConnection object
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
//            set the sql command into string query variable
            String query = "SELECT * FROM student_detail WHERE rn = ?";

//            Preparing the statement
            preparedStatement = connectDB.prepareStatement(query);
            preparedStatement.setInt(1, rnValue);
            resultSet = preparedStatement.executeQuery();


//            Getting the personal information
            InputStream inputStream;
            while (resultSet.next()) {
                stuName.setText(resultSet.getString("student_name"));
                Blob imgBlob = resultSet.getBlob("student_img");
                inputStream = imgBlob.getBinaryStream();
                Image image = new Image(inputStream);
                stuImage.setImage(image);
                fatherNameData.setText(resultSet.getString("father_name"));
                motherNameData.setText(resultSet.getString("mother_name"));
                sectionData.setText(resultSet.getString("section"));
                genderData.setText(resultSet.getString("gender"));
                birthCertificateData.setText(resultSet.getString("b_c_n"));
                emisData.setText(resultSet.getString("emis_code"));
                contactNumberData.setText(resultSet.getString("contact"));
                dobData.setText(resultSet.getString("d_o_b"));
                addressData.setText(resultSet.getString("address"));
                problemData.setText(resultSet.getString("problem"));
                bgData.setText(resultSet.getString("b_group"));
                dojData.setText(resultSet.getString("d_o_j"));
                religionData.setText(resultSet.getString("religion"));
                castData.setText(resultSet.getString("cast"));
                prevSclData.setText(resultSet.getString("prev_scl"));
                cojData.setText(resultSet.getString("c_o_j"));
                houseData.setText(resultSet.getString("house"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in a finally-block to ensure they are always closed
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connectDB != null) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //  method to set the action in after entering roll Number
    @FXML
    void searchName(ActionEvent event) {
        try {
            int value = Integer.parseInt(rollData.getText());

            // Fetch CGPA data
            int rn = Integer.parseInt(rollData.getText());
            getDetail(rn);
            // Display data on chart
            DisplayCgpaChart show = new DisplayCgpaChart();
            show.displayCgpaChart(chart, rn);

            findSubjectActive();


        } catch (NumberFormatException e) {
            System.err.println("Invalid input: Not a number");
            // Handle the exception (e.g., show an error message to the user)
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void findSubjectActive() throws SQLException {
        AcademicProfileTable t = new AcademicProfileTable();
        t.academicProfileData(acProfileStuName,
                academicProfileRn,
                examName,
                englishMarks,
                nepaliMarks,
                mathMarks,
                scienceMarks,
                socialMarks,
                optIMarks,
                optIiMarks,
                acCgpa,
                academicProfileTable);
    }

    @FXML
    String getName() {
        System.out.println(stuNameInput.getText());
        return stuNameInput.getText();
    }

    //    initializing all the comboBoxes
    void initializeComboBox() {
//        selectMonth.getItems().addAll("Baisakh", "Jestha", "Asar", "Sawan", "Bhadra", "Ashoj",
//                "Kartik", "Mangsir", "Push", "Magh", "Fagun", "Chait");

        selectGender.getItems().addAll("Male", "Female", "Other");
        bgInput.getItems().addAll("A+ve", "B+ve", "AB+ve", "O+ve", "A-ve", "B-ve", "AB-ve", "O-ve");
        religionInput.getItems().addAll("Hindu", "Muslim", "Christian", "Other");
        selectSubject.getItems().addAll("English", "Nepali", "Math", "Science", "Social", "Opt I", "Opt II");
        selectMonthAtt.getItems().addAll("Baisakh", "Jestha", "Asar", "Sawan", "Bhadra", "Ashoj",
                "Kartik", "Mangsir", "Push", "Magh", "Fagun", "Chait");
        marksEntryMonth.getItems().addAll("Baisakh", "Jestha", "Asar", "Sawan", "Bhadra", "Ashoj",
                "Kartik", "Mangsir", "Push", "Magh", "Fagun", "Chait");
        attMonth.getItems().addAll("Baisakh", "Jestha", "Asar", "Sawan", "Bhadra", "Ashoj",
                "Kartik", "Mangsir", "Push", "Magh", "Fagun", "Chait");
    }

    @FXML
    void academicProfileTableAdd() throws SQLException {
        AcademicProfileTable t = new AcademicProfileTable();
        t.academicProfileData(acProfileStuName, academicProfileRn, examName, englishMarks, nepaliMarks, mathMarks, scienceMarks, socialMarks, optIMarks, optIiMarks, acCgpa, academicProfileTable);
    }

    //    method to insert image and other data into database

    @FXML
    void showChart() throws SQLException {
        AcademicProfileChart subChart = new AcademicProfileChart();
        subChart.displayAcademicSubjectChart(selectSubject, academicProfileRn, eachSubjectChart);
    }

    /**
     * This is multiLine Comments
     * Now i do want to do this and that an nobody can say me nothing
     *
     */
    @FXML
    void loadstuData() {
        AttendanceTableInsertion insertTable = new AttendanceTableInsertion();
        insertTable.attendanceData(fetchRn,
                fetchStuName,
                insertPresentDay,
                attendanceDataInsertionTable,
                totalDaysInMonth );
    }

    @FXML
    void loadStudentForMarkEntry(){
        MarksInsertationTable insertTable = new MarksInsertationTable();
        insertTable.marksData(fetchRn1,
                fetchStuName1,
                englishMark,
                nepaliMark,
                mathMark,
                scienceMark,
                socialMark,
                optIMark,
                optIiMark,
                marksEntryTable,
                fullMarks);
    }


//    adding the new students into database
    @FXML
    void insertNewStudentIntoDb() throws RuntimeException {
        AddNewStudentIntoDataBase add = new AddNewStudentIntoDataBase();
        add.insertIntoDb(stuRnInput, stuNameInput, stuSectionInput, selectGender, bcnInput, emisInput, dobInput, fatherNameInput, motherNameInput, contactInput, addressInput, problemInput, bgInput, dojInput, religionInput, castInput, prevSclInput, cojInput, houseInput, message, choosedImage, chooseImage, file);
    }

    //    Making insertAttendanceTable Editable and keeping the new value on table
    @FXML
    void presentDaysEdit(CellEditEvent<AttendanceInfo, Integer> e) {
        int currentRow = attendanceDataInsertionTable.getSelectionModel().getSelectedIndex();
        AttendanceInfo selectedRow = attendanceDataInsertionTable.getSelectionModel().getSelectedItem();
        selectedRow.setPresentDays((Integer) e.getNewValue());
        if (currentRow < attendanceDataInsertionTable.getItems().size() - 1) {
            attendanceDataInsertionTable.getSelectionModel().select(currentRow + 1);
            attendanceDataInsertionTable.getFocusModel().focus(currentRow + 1, attendanceDataInsertionTable.getColumns().getFirst());
        }
    }

    @FXML
    void englishMarksEdit(CellEditEvent<MarkInfo, Double>e){
        MarkInfo selectedRow = marksEntryTable.getSelectionModel().getSelectedItem();
        selectedRow.setEnglishMark((Double) e.getNewValue());
    }

    @FXML
    void nepaliMarksEdit(CellEditEvent<MarkInfo, Double>e){
        int currentRow = marksEntryTable.getSelectionModel().getSelectedIndex();
        MarkInfo selectedRow = marksEntryTable.getSelectionModel().getSelectedItem();
        selectedRow.setNepaliMark((Double) e.getNewValue());
    }

    @FXML
    void mathMarksEdit(CellEditEvent<MarkInfo, Double>e){
        int currentRow = marksEntryTable.getSelectionModel().getSelectedIndex();
        MarkInfo selectedRow = marksEntryTable.getSelectionModel().getSelectedItem();
        selectedRow.setMathMark((Double) e.getNewValue());
    }

    @FXML
    void scienceMarksEdit(CellEditEvent<MarkInfo, Double>e){
        int currentRow = marksEntryTable.getSelectionModel().getSelectedIndex();
        MarkInfo selectedRow = marksEntryTable.getSelectionModel().getSelectedItem();
        selectedRow.setScienceMark((Double) e.getNewValue());
    }

    @FXML
    void socialMarksEdit(CellEditEvent<MarkInfo, Double>e){
        int currentRow = marksEntryTable.getSelectionModel().getSelectedIndex();
        MarkInfo selectedRow = marksEntryTable.getSelectionModel().getSelectedItem();
        selectedRow.setSocialMark((Double) e.getNewValue());
    }

    @FXML
    void optIMarksEdit(CellEditEvent<MarkInfo, Double>e){
        int currentRow = marksEntryTable.getSelectionModel().getSelectedIndex();
        MarkInfo selectedRow = marksEntryTable.getSelectionModel().getSelectedItem();
        selectedRow.setOptIMark((Double) e.getNewValue());
    }

    @FXML
    void optIiMarksEdit(CellEditEvent<MarkInfo, Double>e){
        int currentRow = marksEntryTable.getSelectionModel().getSelectedIndex();
        MarkInfo selectedRow = marksEntryTable.getSelectionModel().getSelectedItem();
        selectedRow.setOptIiMark((Double) e.getNewValue());
    }

//

    @FXML
    void uploadMarksIntoDb(){
        GetMarksAndInsertIntoDataBase getMarksAndInsertIntoDataBase = new GetMarksAndInsertIntoDataBase();
        getMarksAndInsertIntoDataBase.uploadMarksTable(marksEntryTable,marksEntryMonth,message);
    }

    //    When clicked insert button, this code holds the data of tables in the list and uploads it to the database
    @FXML
    void uploadAttendaceIntoDb() {
        GetDataAndInsertIntoDataBase get = new GetDataAndInsertIntoDataBase();
        get.uploadAttendanceData(attendanceDataInsertionTable, attMonth, message);
    }

    @FXML
    public void chooseFile() {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(chooseImage.getScene().getWindow());
        //this is the method to convert inputStream into binary code
        image = new Image(file.toURI().toString(), 100, 150, true, true);
        choosedImage.setImage(image);
    }

}



