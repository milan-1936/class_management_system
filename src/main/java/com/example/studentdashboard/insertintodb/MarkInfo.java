package com.example.studentdashboard.insertintodb;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.*;

public class MarkInfo {
    private IntegerProperty rn;
    private StringProperty studentName;
    private DoubleProperty englishMark;
    private DoubleProperty nepaliMark;
    private DoubleProperty mathMark;
    private DoubleProperty scienceMark;
    private DoubleProperty socialMark;
    private DoubleProperty optIMark;
    private DoubleProperty optIiMark;
    private DoubleProperty cGpa;
    private IntegerProperty fullMarks;
    private DoubleProperty passMarks;

    public MarkInfo(int rn, String studentName, int fullMark) {
        this.rn = new SimpleIntegerProperty(rn);
        this.studentName = new SimpleStringProperty(studentName);
        this.fullMarks = new SimpleIntegerProperty(fullMark);
        this.englishMark = new SimpleDoubleProperty();
        this.nepaliMark = new SimpleDoubleProperty();
        this.mathMark = new SimpleDoubleProperty();
        this.scienceMark = new SimpleDoubleProperty();
        this.socialMark = new SimpleDoubleProperty();
        this.optIMark = new SimpleDoubleProperty();
        this.optIiMark = new SimpleDoubleProperty();
        this.cGpa = new SimpleDoubleProperty();

        // Bind CGPA calculation to the marks properties
        this.cGpa.bind(createCgpaBinding());
    }
    

    private DoubleBinding createCgpaBinding() {
        return Bindings.createDoubleBinding(() ->
                        calculateCgpa(),
                englishMark, nepaliMark, mathMark, scienceMark, socialMark, optIMark, optIiMark);
    }



    public double calculateGradePoint(double mark) {
        double percentage = (mark / fullMarks.get()) * 100;

        if (percentage >= 90) {
            return 4.0;
        } else if (percentage >= 80) {
            return 3.6;
        } else if (percentage >= 70) {
            return 3.2;
        } else if (percentage >= 60) {
            return 2.8;
        } else if (percentage >= 50) {
            return 2.4;
        } else if(percentage >=40){
            return 2.2;
        } else if(percentage >= 35){
            return 2.0;
        } else {
            return 0.0;
        }
    }


    public double calculateCgpa() {
        double englishGradePoint = calculateGradePoint(englishMark.get());
        double nepaliGradePoint = calculateGradePoint(nepaliMark.get());
        double mathGradePoint = calculateGradePoint(mathMark.get());
        double scienceGradePoint = calculateGradePoint(scienceMark.get());
        double socialGradePoint = calculateGradePoint(socialMark.get());
        double optIGradePoint = calculateGradePoint(optIMark.get());
        double optIiGradePoint = calculateGradePoint(optIiMark.get());

        double cgpa = (englishGradePoint + nepaliGradePoint + mathGradePoint +
                scienceGradePoint + socialGradePoint + optIGradePoint +
                optIiGradePoint) / 7;

        return cgpa;// Set the calculated CGPA
    }


    // Getters
    public int getRn() {
        return rn.get();
    }

    public IntegerProperty rnProperty() {
        return rn;
    }

    public String getStudentName() {
        return studentName.get();
    }

    public StringProperty studentNameProperty() {
        return studentName;
    }

    public double getEnglishMark() {
        return englishMark.get();
    }

    public DoubleProperty englishMarkProperty() {
        return englishMark;
    }

    public double getNepaliMark() {
        return nepaliMark.get();
    }

    public DoubleProperty nepaliMarkProperty() {
        return nepaliMark;
    }

    public double getMathMark() {
        return mathMark.get();
    }

    public DoubleProperty mathMarkProperty() {
        return mathMark;
    }

    public double getScienceMark() {
        return scienceMark.get();
    }

    public DoubleProperty scienceMarkProperty() {
        return scienceMark;
    }

    public double getSocialMark() {
        return socialMark.get();
    }

    public DoubleProperty socialMarkProperty() {
        return socialMark;
    }

    public double getOptIMark() {
        return optIMark.get();
    }

    public DoubleProperty optIMarkProperty() {
        return optIMark;
    }

    public double getOptIiMark() {
        return optIiMark.get();
    }

    public DoubleProperty optIiMarkProperty() {
        return optIiMark;
    }

    public double getcGpa() {
        return cGpa.get();
    }

    public DoubleProperty cGpaProperty() {
        return cGpa;
    }

    public void setcGpa(double cGpa) {
        this.cGpa.set(cGpa);
    }

    public void setEnglishMark(double englishMark) {
        this.englishMark.set(englishMark);
    }

    public void setNepaliMark(double nepaliMark) {
        this.nepaliMark.set(nepaliMark);
    }

    public void setMathMark(double mathMark) {
        this.mathMark.set(mathMark);
    }

    public void setScienceMark(double scienceMark) {
        this.scienceMark.set(scienceMark);
    }

    public void setSocialMark(double socialMark) {
        this.socialMark.set(socialMark);
    }

    public void setOptIMark(double optIMark) {
        this.optIMark.set(optIMark);
    }

    public void setOptIiMark(double optIiMark) {
        this.optIiMark.set(optIiMark);
    }

    public double getFullMarks() {
        return fullMarks.get();
    }

    public IntegerProperty fullMarksProperty() {
        return fullMarks;
    }

    public void setFullMarks(double fullMarks) {
        this.fullMarks.set((int) fullMarks);
    }

    public double getPassMarks() {
        return passMarks.get();
    }

    public DoubleProperty passMarksProperty() {
        return passMarks;
    }

    public void setPassMarks(double passMarks) {
        this.passMarks.set(passMarks);
    }

}

