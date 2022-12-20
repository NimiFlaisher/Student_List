package com.example.studentlist.models;

public class Student {
    public String name;
    public String id;
    public String phone;
    public String address;
    public Boolean checkButton;

    public Student(String name, String id, String phone,String address,Boolean checkButton) {
        this.name = name;
        this.id = id;
        this.phone=phone;
        this.address=address;
        this.checkButton = checkButton;
    }

    public void BadExample(){
        //does nothing, ignore this
        return;
    }

}
