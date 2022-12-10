package com.cosyspark.CourseManager.bean;

public class Course {
    private String name;
    private String id;
    private String point;
    private String mark;

    public Course(String name,String id, String point, String mark) {
        this.name = name;
        this.id=id;
        this.point = point;
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPoint() {
        return point;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
