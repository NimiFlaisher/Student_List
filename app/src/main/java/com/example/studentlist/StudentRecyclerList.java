package com.example.studentlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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

        adapter.setOnItemClickListener((position)->{
                Student st = studentList.get(position);
                Intent intent = new Intent(this,ProfilePage.class);
                intent.putExtra("position",position);
                intent.putExtra("name",st.name);
                intent.putExtra("id",st.id);
                intent.putExtra("phone",st.phone);
                intent.putExtra("address",st.address);
                intent.putExtra("checkButton",st.checkButton.booleanValue());
                startActivity(intent);
            }
        );
    }

    public void addStudentButton(View view) {
        Intent intent = new Intent(this, StudentBuilder.class);
        startActivity(intent);
    }

    public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentView>{
        StudentView.OnItemClickListener listener;
        void setOnItemClickListener(StudentView.OnItemClickListener listener){
            this.listener = listener;
        }
        @NonNull
        @Override
        public StudentView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.activity_listrow,parent,false);
            return new StudentView(view,listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentView holder, int position) {
            Student student = studentList.get(position);
            holder.bind(student, position);
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }
    }


}
