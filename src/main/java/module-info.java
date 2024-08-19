module com.example.studentdashboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.j;
//    requires mysql.connector.j;

    opens com.example.studentdashboard to javafx.fxml;
    exports com.example.studentdashboard;
    exports com.example.studentdashboard.database;
    opens com.example.studentdashboard.database to javafx.fxml;
    exports com.example.studentdashboard.attendance;
    opens com.example.studentdashboard.attendance to javafx.fxml;
    exports com.example.studentdashboard.cgpadataplot;
    opens com.example.studentdashboard.cgpadataplot to javafx.fxml;
    exports com.example.studentdashboard.academicprofile;
    opens com.example.studentdashboard.academicprofile to javafx.fxml;

    opens com.example.studentdashboard.insertintodb to javafx.base;
    exports com.example.studentdashboard.insertintodb;
}