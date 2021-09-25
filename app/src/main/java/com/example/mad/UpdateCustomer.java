package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class UpdateCustomer extends AppCompatActivity {

    TextView customerIDd;
    TextInputEditText upName1, upEmail1, upPhone1, upJoinedDate1;
    ImageButton update_button, back_button, stock, cus, order, sup;

    String customerID, customerName, customerEmail, customerPhone, customerJoinedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_customer);

        customerIDd = findViewById(R.id.customerID);
        upName1 = findViewById(R.id.upName1);
        upEmail1 = findViewById(R.id.upEmail1);
        upPhone1 = findViewById(R.id.upPhone1);
        upJoinedDate1 = findViewById(R.id.upJoinedDate1);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        update_button = findViewById(R.id.update_button);
        back_button = findViewById(R.id.back_button);

        getAndSetIntentData();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateCustomer.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateCustomer.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateCustomer.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateCustomer.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateCustomer.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });



        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CustomerDatabaseHelper myDB = new CustomerDatabaseHelper(UpdateCustomer.this);
                myDB.updateData(customerID,upName1.getText().toString().trim(),
                        upEmail1.getText().toString().trim(),
                        upPhone1.getText().toString().trim(),
                        upJoinedDate1.getText().toString().trim());
            }
        });

    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("email") && getIntent().hasExtra("phone") && getIntent().hasExtra("joineddate")){
            //Getting Data from Intent
            customerID = getIntent().getStringExtra("id");
            customerName = getIntent().getStringExtra("name");
            customerEmail = getIntent().getStringExtra("email");
            customerPhone = getIntent().getStringExtra("phone");
            customerJoinedDate = getIntent().getStringExtra("joineddate");

            //Setting Intent Data
            customerIDd.setText(customerID);
            upName1.setText(customerName);
            upEmail1.setText(customerEmail);
            upPhone1.setText(customerPhone);
            upJoinedDate1.setText(customerJoinedDate);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}