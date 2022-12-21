package com.example.studentlist;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentView>{
    StudentView.OnItemClickListener listener;
    void setOnItemClickListener(StudentView.OnItemClickListener listener){
        this.listener = listener;
    }
    @NonNull
    @Override
    public StudentView onCreateView(@NonNull ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.student_list_row,parent,false);
        return new StudentViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentView holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
