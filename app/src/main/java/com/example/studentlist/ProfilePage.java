package com.example.studentlist;

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

        sName.setText("name: "+studentName);
        sId.setText("id: "+studentId);
        sPhoneNumber.setText("phone: "+studentPhoneNumber);
        sAddress.setText("address: "+studentAddress);
        sCheckButton.setChecked(checkButton);

    }

//    public void editButton(View view){
//        Intent intent = new Intent(this,EditStudent.class);
//        intent.putExtra("name",name_user);
//        intent.putExtra("id",id_user);
//        intent.putExtra("phone",phone_user);
//        intent.putExtra("address",address_user);
//        intent.putExtra("cb",cb_user);
//        intent.putExtra("pos",pos_user);
//
//        startActivity(intent);
//        finish();
//    }


}
