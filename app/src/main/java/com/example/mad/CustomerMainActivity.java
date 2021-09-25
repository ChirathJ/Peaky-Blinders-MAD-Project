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

public class CustomerMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton add_button, stock, cus, order, sup;
    TextView countd;
    CustomerDatabaseHelper myDB;
    ArrayList<String> customerID, customerName, customerEmail, customerPhone, customerJoinedDate;
    CustomerAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_customer);
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
                Intent intent = new Intent(CustomerMainActivity.this, AddCustomer.class);
                startActivity(intent);
            }
        });

        myDB = new CustomerDatabaseHelper(CustomerMainActivity.this);
        customerID = new ArrayList<>();
        customerName = new ArrayList<>();
        customerEmail = new ArrayList<>();
        customerPhone = new ArrayList<>();
        customerJoinedDate = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomerAdapter(CustomerMainActivity.this,this, customerID, customerName, customerEmail, customerPhone, customerJoinedDate);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CustomerMainActivity.this));

        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(CustomerMainActivity.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(CustomerMainActivity.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(CustomerMainActivity.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(CustomerMainActivity.this, SupplierMainActivity.class);
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
                customerID.add(cursor.getString(0));
                customerName.add(cursor.getString(1));
                customerEmail.add(cursor.getString(2));
                customerPhone.add(cursor.getString(3));
                customerJoinedDate.add(cursor.getString(4));
            }
        }
    }
}