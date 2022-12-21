package com.example.studentlist.models;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    List<Student> studentList = new LinkedList<>();
    private static final Demo _instance = new Demo();

    public static Demo instance(){
        return _instance;
    }

    public List<Student> getStudents(){
        return studentList;
    }

    private Demo(){
        studentList.add(new Student("Nimi Flaisher", "206335408", "050-6865840", "Tel Aviv", false));
        studentList.add(new Student("Ori Kanner", "694201337", "050-4206996", "Tel Aviv", false));
        studentList.add(new Student("Previous Leon", "202087875", "054-4396540", "Float City", false));
        studentList.add(new Student("Ms. Direction", "948276911", "052-4038677", "Citadel of Ricks", false));
        studentList.add(new Student("Ms. Fortune", "373795952", "054-2468295", "Summoner's Rift", false));
    }
}
