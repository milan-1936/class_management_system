package com.example.studentdashboard.attendance;
public class AttendanceInfo {
    private int rn;
    private String tableStuName;
    private int presentDays=0;
    private int totalDays;
    private int absentDays =0;

//    This constructor is used by attendance show table
    public AttendanceInfo(int rn, String tableStuName, int presentDays, int totalDays, int absentDays) {
        this.rn = rn;
        this.tableStuName = tableStuName;
        this.presentDays = presentDays;
        this.totalDays = totalDays;
        this.absentDays = absentDays;
    }

//    This constructor is used by attendance entry method
    public AttendanceInfo(int rn, String tableStuName, int totalDays) {
        this.rn = rn;
        this.tableStuName = tableStuName;
        this.totalDays = totalDays;
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    public String getTableStuName() {
        return tableStuName;
    }

    public void setTableStuName(String tableStuName) {
        this.tableStuName = tableStuName;
    }

    public int getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(int presentDays) {
        this.presentDays = presentDays;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(int absentDays) {
        this.absentDays = absentDays;
    }
}
