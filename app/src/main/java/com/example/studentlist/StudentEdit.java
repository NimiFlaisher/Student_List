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

public class StudentEdit extends AppCompatActivity {
    List<Student> data;
    EditText name;
    EditText id;
    EditText phone;
    EditText address;
    CheckBox cb;
    Integer pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentedit);

        data = Demo.instance().getStudents();
        name=findViewById(R.id.editName);
        id=findViewById(R.id.editId);
        phone=findViewById(R.id.editPhone);
        address=findViewById(R.id.editAddress);
        cb=findViewById(R.id.editCheckButton);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        id.setText(intent.getStringExtra("id"));
        phone.setText(intent.getStringExtra("phone"));
        address.setText(intent.getStringExtra("address"));
        cb.setChecked(intent.getBooleanExtra("cb",false));
        pos=(intent.getIntExtra("pos",0));


    }

    public void saveBtn(View view){
        Student st = data.get(pos);
        st.name=name.getText().toString();
        st.id=id.getText().toString();
        st.phone=phone.getText().toString();
        st.address=address.getText().toString();
        st.checkButton=cb.isChecked();
        Intent intent = new Intent(getApplicationContext(), StudentRecyclerList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void cancelBtn(View view){
        finish();
    }

    public void deleteBtn(View view){
        data.remove(data.get(pos));
        Intent intent = new Intent(this,StudentRecyclerList.class);
        finish();
        startActivity(intent);
    }


}