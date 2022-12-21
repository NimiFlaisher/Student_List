package com.example.studentlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentlist.models.Demo;
import com.example.studentlist.models.Student;

import java.util.List;

public class StudentBuilder extends AppCompatActivity {
    List<Student> studentList;
    EditText studentName;
    EditText studentId;
    EditText studentPhone;
    EditText studentAddress;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentbuilder);
        studentList = Demo.instance().getStudents();
        studentName = findViewById(R.id.editName);
        studentId = findViewById(R.id.editId);
        studentPhone = findViewById(R.id.editPhone);
        studentAddress = findViewById(R.id.editAddress);
        checkBox = findViewById(R.id.editCheckButton);
    }

    public void save(View view){
        String buildName = studentName.getText().toString();
        String buildId = studentId.getText().toString();
        String buildPhone = studentPhone.getText().toString();
        String buildAddress = studentAddress.getText().toString();
        Boolean isChecked = checkBox.isChecked();
        studentList.add(new Student(buildName, buildId, buildPhone, buildAddress, isChecked));
        Intent intent = new Intent(this, StudentRecyclerList.class);
        startActivity(intent);
    }

    public void cancel(View view){
        finish();
    }
}
