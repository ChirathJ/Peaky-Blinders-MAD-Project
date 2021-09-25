package com.example.mad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton add_button;
    TextView stockIDd;
    MyDatabaseHelper myDB;
    ArrayList<String> stockID, stockName, stockCategory, stockQuantity, stockUnitPrice;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list1);
        recyclerView = findViewById(R.id.list_item);
        stockIDd = findViewById(R.id.count);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AddStock.class);
                startActivity(intent);
            }
        });


        myDB = new MyDatabaseHelper(Home.this);
        stockID = new ArrayList<>();
        stockName = new ArrayList<>();
        stockCategory = new ArrayList<>();
        stockQuantity = new ArrayList<>();
        stockUnitPrice = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(Home.this,this, stockID, stockName, stockCategory, stockQuantity, stockUnitPrice);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Home.this));
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
            int count = cursor.getCount();
            Toast.makeText(this,String.valueOf(count),Toast.LENGTH_SHORT).show();
            stockIDd.setText(String.valueOf(count));
            while (cursor.moveToNext()){
                stockID.add(cursor.getString(0));
                stockName.add(cursor.getString(1));
                stockCategory.add(cursor.getString(2));
                stockQuantity.add(cursor.getString(3));
                stockUnitPrice.add(cursor.getString(4));
            }
        }
    }

}