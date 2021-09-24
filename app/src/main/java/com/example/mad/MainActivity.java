package com.example.mad;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> customerID, customerName, customerEmail, customerPhone, customerJoinedDate;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_item);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCustomer.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        customerID = new ArrayList<>();
        customerName = new ArrayList<>();
        customerEmail = new ArrayList<>();
        customerPhone = new ArrayList<>();
        customerJoinedDate = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this,this, customerID, customerName, customerEmail, customerPhone, customerJoinedDate);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data.",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                customerID.add(cursor.getString(0));
                customerName.add(cursor.getString(1));
                customerEmail.add(cursor.getString(2));
                customerPhone.add(cursor.getString(3));
                customerJoinedDate.add(cursor.getString(4));
            }
        }
    }

}