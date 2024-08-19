package com.example.studentdashboard.academicprofile;


public class AcademicProfileTableData {
    int rn;
    String month;
    String studentName;
    String examName;
    double englishMarks, nepaliMarks, mathMarks, scienceMarks, socialMarks, optIMarks, optIiMarks, acCgpa;
    public AcademicProfileTableData(int rn, String examName,
                                    double englishMarks, double nepaliMarks,
                                    double mathMarks, double scienceMarks,
                                    double socialMarks, double optIMarks,
                                    double optIiMarks, double acCgpa) {
    this.rn = rn;
    this.examName = examName;
    this.englishMarks = englishMarks;
    this.nepaliMarks = nepaliMarks;
    this.mathMarks = mathMarks;
    this.scienceMarks = scienceMarks;
    this.socialMarks = socialMarks;
    this.optIMarks = optIMarks;
    this.optIiMarks = optIiMarks;
    this.acCgpa = acCgpa;

    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public double getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(double englishMarks) {
        this.englishMarks = englishMarks;
    }

    public double getNepaliMarks() {
        return nepaliMarks;
    }

    public void setNepaliMarks(double nepaliMarks) {
        this.nepaliMarks = nepaliMarks;
    }

    public double getMathMarks() {
        return mathMarks;
    }

    public void setMathMarks(double mathMarks) {
        this.mathMarks = mathMarks;
    }

    public double getScienceMarks() {
        return scienceMarks;
    }

    public void setScienceMarks(double scienceMarks) {
        this.scienceMarks = scienceMarks;
    }

    public double getSocialMarks() {
        return socialMarks;
    }

    public void setSocialMarks(double socialMarks) {
        this.socialMarks = socialMarks;
    }

    public double getOptIMarks() {
        return optIMarks;
    }

    public void setOptIMarks(double optIMarks) {
        this.optIMarks = optIMarks;
    }

    public double getOptIiMarks() {
        return optIiMarks;
    }

    public void setOptIiMarks(double optIiMarks) {
        this.optIiMarks = optIiMarks;
    }

    public double getAcCgpa() {
        return acCgpa;
    }

    public void setAcCgpa(double acCgpa) {
        this.acCgpa = acCgpa;
    }
}
