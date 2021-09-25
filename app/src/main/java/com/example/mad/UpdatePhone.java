package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class UpdatePhone extends AppCompatActivity {

    TextView customerIDd, customerNamed;
    TextInputEditText phoneentry;
    ImageButton save_button, back_button, stock, cus, order, sup;

    String customerID, customerName, customerEmail, customerPhone, customerJoinedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_phone);

        customerIDd = findViewById(R.id.customerIDdup);
        customerNamed = findViewById(R.id.customerNamedup);
        phoneentry = findViewById(R.id.upphoneentry);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        save_button = findViewById(R.id.save_button);
        back_button = findViewById(R.id.back_button);

        getAndSetIntentData();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdatePhone.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdatePhone.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdatePhone.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdatePhone.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdatePhone.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                CustomerDatabaseHelper myDB = new CustomerDatabaseHelper(UpdatePhone.this);
                myDB.updateData(customerID,customerName,customerEmail,
                        phoneentry.getText().toString().trim(),
                        customerJoinedDate.toString().trim());
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
            customerNamed.setText(customerName);
            phoneentry.setText(customerPhone);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}