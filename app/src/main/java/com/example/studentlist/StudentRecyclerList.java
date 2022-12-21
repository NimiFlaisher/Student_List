package com.example.studentlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentlist.R;
import com.example.studentlist.models.Demo;
import com.example.studentlist.models.Student;

import java.util.List;

public class StudentRecyclerList extends AppCompatActivity {
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        studentList = Demo.instance().getStudents();
        RecyclerView list = findViewById(R.id.recyclerStudentList);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);
    }


}
