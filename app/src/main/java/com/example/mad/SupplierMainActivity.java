package com.example.mad;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SupplierMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton add_button, stock, cus, order, sup;
    TextView countd;
    SupplierDatabaseHelper myDB;
    ArrayList<String> supplierID, supplierName, supplierAddress, supplierEmail, supplierPhone;
    SupplierAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        recyclerView = findViewById(R.id.list_item);
        countd = findViewById(R.id.count);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupplierMainActivity.this, AddSupplier.class);
                startActivity(intent);
            }
        });

        myDB = new SupplierDatabaseHelper(SupplierMainActivity.this);
        supplierID = new ArrayList<>();
        supplierName = new ArrayList<>();
        supplierAddress = new ArrayList<>();
        supplierEmail = new ArrayList<>();
        supplierPhone = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new SupplierAdapter(SupplierMainActivity.this,this, supplierID, supplierName, supplierAddress, supplierEmail, supplierPhone);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SupplierMainActivity.this));
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(SupplierMainActivity.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(SupplierMainActivity.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(SupplierMainActivity.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(SupplierMainActivity.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });

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
            countd.setText(String.valueOf(count));
            while (cursor.moveToNext()){
                supplierID.add(cursor.getString(0));
                supplierName.add(cursor.getString(1));
                supplierAddress.add(cursor.getString(2));
                supplierEmail.add(cursor.getString(3));
                supplierPhone.add(cursor.getString(4));
            }
        }
    }

}