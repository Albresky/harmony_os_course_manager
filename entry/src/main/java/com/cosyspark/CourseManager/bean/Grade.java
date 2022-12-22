package com.cosyspark.CourseManager.bean;

public class Grade {
    private String stuName;

    private String stuId;

    private String stuGrade;

    public Grade(String stuName, String stuId, String stuGrade) {
        this.stuName = stuName;
        this.stuId = stuId;
        this.stuGrade = stuGrade;
        this.stuGrade = stuGrade;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    public String getStuGrade() {
        return stuGrade;
    }
}
