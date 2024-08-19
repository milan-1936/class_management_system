package com.example.studentdashboard.cgpadataplot;

import com.example.studentdashboard.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonthCount {

    boolean bmrow;
    boolean jmrow;
    boolean amrow;
    boolean smrow;
    boolean vmrow;
    boolean asmrow;
    boolean kmrow;
    boolean mmrow;
    boolean pmrow;
    boolean mamrow;
    boolean fmrow;
    boolean cmrow;
    private int bmcounter;

    public int bmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstbm = null;
        ResultSet rstbm = null;
        int rowCount = 0;
        pstbm = connectDB.prepareStatement("select count(*) as row_count from baisakh_marks");
        rstbm = pstbm.executeQuery();
        if (rstbm.next()) rowCount = rstbm.getInt("row_count");
        return rowCount;
    }

    public int jmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstjm = null;
        ResultSet rstjm = null;
        int rowCount = 0;
        pstjm = connectDB.prepareStatement("select count(*) as row_count from jeth_marks");
        rstjm = pstjm.executeQuery();
        if (rstjm.next()) {
            rowCount = rstjm.getInt("row_count");
        }
        return rowCount;
    }

    public int amRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstam = null;
        ResultSet rstam = null;
        int rowCount = 0;
        pstam = connectDB.prepareStatement("select count(*) as row_count from asar_marks");
        rstam = pstam.executeQuery();
        if (rstam.next()) {
            rowCount = rstam.getInt("row_count");
        }
        return rowCount;
    }

    public int smRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstsm = null;
        ResultSet rstsm = null;
        int rowCount = 0;
        pstsm = connectDB.prepareStatement("select count(*) as row_count from saun_marks");
        rstsm = pstsm.executeQuery();
        if (rstsm.next()) {
            rowCount = rstsm.getInt("row_count");
        }
        return rowCount;
    }

    public int vmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstvm = null;
        ResultSet rstvm = null;
        int rowCount = 0;
        pstvm = connectDB.prepareStatement("select count(*) as row_count from bhadau_marks");
        rstvm = pstvm.executeQuery();
        if (rstvm.next()) {
            rowCount = rstvm.getInt("row_count");
        }
        return rowCount;
    }

    public int asmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstasm = null;
        ResultSet rstasm = null;
        int rowCount = 0;
        pstasm = connectDB.prepareStatement("select count(*) as row_count from asoj_marks");
        rstasm = pstasm.executeQuery();
        if (rstasm.next()) {
            rowCount = rstasm.getInt("row_count");
        }
        return rowCount;
    }

    public int kmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstkm = null;
        ResultSet rstkm = null;
        int rowCount = 0;
        pstkm = connectDB.prepareStatement("select count(*) as row_count from kartik_marks");
        rstkm = pstkm.executeQuery();
        if (rstkm.next()) {
            rowCount = rstkm.getInt("row_count");
        }
        return rowCount;
    }

    public int mmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstmm = null;
        ResultSet rstmm = null;
        int rowCount = 0;
        pstmm = connectDB.prepareStatement("select count(*) as row_count from mangsir_marks");
        rstmm = pstmm.executeQuery();
        if (rstmm.next()) {
            rowCount = rstmm.getInt("row_count");
        }
        return rowCount;
    }

    public int pmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstpm = null;
        ResultSet rstpm = null;
        int rowCount = 0;
        pstpm = connectDB.prepareStatement("select count(*) as row_count from push_marks");
        rstpm = pstpm.executeQuery();
        if (rstpm.next()) {
            rowCount = rstpm.getInt("row_count");
        }
        return rowCount;
    }

    public int mamRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstmam = null;
        ResultSet rstmam = null;
        int rowCount = 0;
        pstmam = connectDB.prepareStatement("select count(*) as row_count from magh_marks");
        rstmam = pstmam.executeQuery();
        if (rstmam.next()) {
            rowCount = rstmam.getInt("row_count");
        }
        return rowCount;
    }

    public int fmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstfm = null;
        ResultSet rstfm = null;
        int rowCount = 0;
        pstfm = connectDB.prepareStatement("select count(*) as row_count from fagun_marks");
        rstfm = pstfm.executeQuery();
        if (rstfm.next()) {
            rowCount = rstfm.getInt("row_count");
        }
        return rowCount;
    }

    public int cmRowCount() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnect();
        PreparedStatement pstcm = null;
        ResultSet rstcm = null;
        int rowCount = 0;
        pstcm = connectDB.prepareStatement("select count(*) as row_count from chait_marks");
        rstcm = pstcm.executeQuery();
        if (rstcm.next()) {
            rowCount = rstcm.getInt("row_count");
        }
        return rowCount;
    }

    public int countBaisakh() throws SQLException {
        if(bmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countJeth() throws SQLException {
        if(jmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countAsar() throws SQLException {
        if(amRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countSaun() throws SQLException {
        if(smRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countVadau() throws SQLException {
        if(vmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countAsoj() throws SQLException {
        if(asmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countKartik() throws SQLException {
        if(kmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countMangsir() throws SQLException {
        if(mmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countPush() throws SQLException {
        if(pmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countMagh() throws SQLException {
        if(mamRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countFagun() throws SQLException {
        if(fmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public int countChait() throws SQLException {
        if(cmRowCount()>0){
            return 1;
        }
        return 0;
    }

    public boolean isBmrow() throws SQLException {
        if(bmRowCount()>0) bmrow = true;
        return bmrow;
    }

    public boolean isJmrow() throws SQLException {
        if(jmRowCount()>0) jmrow = true;
        return jmrow;
    }

    public boolean isAmrow() throws SQLException {
        if(amRowCount()>0) amrow = true;
        return amrow;
    }

    public boolean isSmrow() throws SQLException {
        if(smRowCount()>0) smrow = true;
        return smrow;
    }

    public boolean isVmrow() throws SQLException {
        if(vmRowCount()>0) vmrow = true;
        return vmrow;
    }

    public boolean isAsmrow() throws SQLException {
        if(asmRowCount()>0) asmrow = true;
        return asmrow;
    }

    public boolean isKmrow() throws SQLException {
        if(kmRowCount()>0) kmrow = true;
        return kmrow;
    }

    public boolean isMmrow() throws SQLException {
        if(mmRowCount()>0) mmrow = true;
        return mmrow;
    }

    public boolean isPmrow() throws SQLException {
        if(pmRowCount()>0) pmrow = true;
        return pmrow;
    }

    public boolean isMamrow() throws SQLException {
        if(mamRowCount()>0) mamrow = true;
        return mamrow;
    }

    public boolean isFmrow() throws SQLException {
        if(fmRowCount()>0) fmrow = true;
        return fmrow;
    }

    public boolean isCmrow() throws SQLException {
        if(cmRowCount()>0) cmrow = true;
        return cmrow;
    }

    public int availableMonth() throws SQLException{
        return countBaisakh() + countJeth() +countAsar() + countSaun() + countVadau() + countAsoj() + countKartik() + countMangsir() + countPush() + countMagh() + countFagun() + countChait();
    }
}
