package com.example.aiboidi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_xem(View view){
        Intent intent= new Intent(MainActivity.this, KetQua.class);
        EditText s = findViewById(R.id.editTextTextPersonName);
        String str =s.getText().toString();// đưa tên được nhập vào từ EditText vào biến kiểu string


        intent.putExtra("name",str); // cặp key value với value là biến str


        startActivity(intent);

    }
}