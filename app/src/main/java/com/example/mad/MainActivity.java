package com.example.mad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


//import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ImageButton addOrders;
    RecyclerView recyclerView;

    ArrayList<String> orderId, ItemName, brand, customer, description, reqDate;
    private  DBHandler dbHandler;
    CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addOrders = (ImageButton) findViewById(R.id.ImageButtonAddOrder);
        recyclerView = (RecyclerView) findViewById(R.id.orderList);


        dbHandler = new DBHandler(MainActivity.this);
        orderId = new ArrayList<>();
        ItemName = new ArrayList<>();
        brand = new ArrayList<>();
        customer = new ArrayList<>();
        description = new ArrayList<>();
        reqDate = new ArrayList<>();

        storeDataInArrays();


        //OrdersAdapter adapter = new OrdersAdapter(MainActivity.this,this,orders);

        customAdapter = new CustomAdapter(MainActivity.this,this, orderId, ItemName, brand, customer, description, reqDate);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        addOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,add_orders.class);
                MainActivity.this.startActivity(intent);
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
        Cursor cursor = dbHandler.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data.",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                orderId.add(cursor.getString(0));
                ItemName.add(cursor.getString(1));
                brand.add(cursor.getString(2));
                customer.add(cursor.getString(3));
                description.add(cursor.getString(4));
                reqDate.add(cursor.getString(5));

            }
        }
    }


}