package com.example.studentlist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilePage extends AppCompatActivity {
    String studentName;
    String studentId;
    String studentPhoneNumber;
    String studentAddress;
    Boolean checkButton;
    Integer studentPosition;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        TextView sName=findViewById(R.id.profileNameText);
        TextView sId=findViewById(R.id.profileIDText);
        TextView sPhoneNumber=findViewById(R.id.profilePhoneText);
        TextView sAddress=findViewById(R.id.profileAddressText);
        CheckBox sCheckButton=findViewById(R.id.profileCheckBox);


        studentName=intent.getStringExtra("sName");
        studentId=intent.getStringExtra("sId");
        studentPhoneNumber=intent.getStringExtra("sPhoneNumber");
        studentAddress=intent.getStringExtra("sAddress");
        checkButton=intent.getBooleanExtra("sCheckButton",false);
        studentPosition=intent.getIntExtra("sPosition",0);

        sName.setText("Name: "+studentName);
        sId.setText("ID: "+studentId);
        sPhoneNumber.setText("Phone: "+studentPhoneNumber);
        sAddress.setText("Address: "+studentAddress);
        sCheckButton.setChecked(checkButton);

    }

    public void editButton(View view){
        Intent intent = new Intent(this,StudentEdit.class);
        intent.putExtra("name",studentName);
        intent.putExtra("id",studentId);
        intent.putExtra("phone",studentPhoneNumber);
        intent.putExtra("address",studentAddress);
        intent.putExtra("cb",checkButton);
        intent.putExtra("pos",studentPosition);
        startActivity(intent);
        finish();
    }

    public void onCheck(View view){
        checkButton = !checkButton;
    }

    public void backButton(View view){
        Intent intent = new Intent();
        intent.putExtra("cb",checkButton);
        intent.putExtra("pos",studentPosition);
        setResult(RESULT_OK,intent);
        finish();
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
    }


}
