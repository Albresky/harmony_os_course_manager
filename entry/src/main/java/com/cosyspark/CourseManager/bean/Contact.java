package com.cosyspark.CourseManager.bean;

public class Contact {
    private String userName;

    private String telPhone;

    public Contact(String name, String phoneNumber) {
        this.userName = name;
        this.telPhone = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }
}
