//package com.example.studentlist;
//
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.CheckBox;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.studentlist.models.Demo;
//import com.example.studentlist.models.Student;
//
//public class StudentView extends RecyclerView.ViewHolder {
//    TextView nameView;
//    TextView idView;
//    CheckBox cbView;
//
//    public interface OnItemClickListener{
//        void onItemClick(int pos);
//    }
//
//    public StudentView(@NonNull View itemView, OnItemClickListener listener) {
//        super(itemView);
//        nameView = itemView.findViewById(R.id.studentNameText);
//        idView = itemView.findViewById(R.id.studentIdText);
//        cbView = itemView.findViewById(R.id.checkBox);
//        cbView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = (int)cbView.getTag();
//                Student student = Demo.instance().getStudents().get(position);
//                student.checkButton = cbView.isChecked();
//            }
//        });
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = getAdapterPosition();
//                listener.onItemClick(position);
//            }
//        });
//    }
//    public void bind(Student student, int position) {
//        nameView.setText(student.name);
//        idView.setText(student.id);
//        cbView.setChecked(student.checkButton);
//        cbView.setTag(position);
//    }
//}
