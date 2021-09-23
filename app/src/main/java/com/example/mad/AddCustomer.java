package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AddCustomer extends AppCompatActivity {

    TextInputEditText customerName, customerEmail, customerPhone, customerJoinedDate;
    ImageButton save_button, back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        customerName = findViewById(R.id.customerName1);
        customerEmail = findViewById(R.id.customerEmail1);
        customerPhone = findViewById(R.id.customerPhone1);
        customerJoinedDate = findViewById(R.id.customerJoinedDate1);
        save_button = findViewById(R.id.save_button);
        back_button = findViewById(R.id.back_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddCustomer.this);
                myDB.addStock(customerName.getText().toString().trim(),
                        customerEmail.getText().toString().trim(),
                        customerPhone.getText().toString().trim(),
                        customerJoinedDate.getText().toString().trim());
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddCustomer.this, Home.class);
                startActivity(intent1);
            }
        });
    }
}