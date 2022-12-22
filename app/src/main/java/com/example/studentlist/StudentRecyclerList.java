package com.example.studentlist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

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
                intent.putExtra("sName",st.name);
                intent.putExtra("sId",st.id);
                intent.putExtra("sPhoneNumber",st.phone);
                intent.putExtra("sAddress",st.address);
                intent.putExtra("sCheckButton",st.checkButton.booleanValue());
                intent.putExtra("sPosition",position);
                startActivity(intent);
            }
        );
    }

    public void addStudentButton(View view) {
        Intent intent = new Intent(this, StudentBuilder.class);
        startActivity(intent);
    }

    class StudentView extends RecyclerView.ViewHolder {
        TextView nameView;
        TextView idView;
        CheckBox cbView;

        public StudentView(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameView = itemView.findViewById(R.id.studentNameText);
            idView = itemView.findViewById(R.id.studentIdText);
            cbView = itemView.findViewById(R.id.checkBox);
            cbView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int)cbView.getTag();
                    Student student = studentList.get(position);
                    student.checkButton = cbView.isChecked();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });
        }
        public void bind(Student student, int position) {
            nameView.setText(student.name);
            idView.setText(student.id);
            cbView.setChecked(student.checkButton);
            cbView.setTag(position);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentView>{
        OnItemClickListener listener;
        void setOnItemClickListener(OnItemClickListener listener){
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
