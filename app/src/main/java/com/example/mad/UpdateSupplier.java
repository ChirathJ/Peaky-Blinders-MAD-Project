package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class UpdateSupplier extends AppCompatActivity {

    TextView supplierIDd;
    TextInputEditText upName1, upAddress1, upEmail1, upPhone1;
    ImageButton update_button, back_button, stock, cus, order, sup;

    String supplierID, supplierName, supplierAddress, supplierEmail, supplierPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_supplier);

        supplierIDd = findViewById(R.id.supplierID);
        upName1 = findViewById(R.id.upName1);
        upAddress1 = findViewById(R.id.upAddress1);
        upEmail1 = findViewById(R.id.upEmail1);
        upPhone1 = findViewById(R.id.upPhone1);
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
                Intent intent1 = new Intent(UpdateSupplier.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateSupplier.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateSupplier.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateSupplier.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateSupplier.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                SupplierDatabaseHelper myDB = new SupplierDatabaseHelper(UpdateSupplier.this);
                myDB.updateData(supplierID,upName1.getText().toString().trim(),
                        upAddress1.getText().toString().trim(),
                        upEmail1.getText().toString().trim(),
                        Integer.parseInt(upPhone1.getText().toString().trim()));
            }
        });

    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("address") && getIntent().hasExtra("email") && getIntent().hasExtra("phone")){
            //Getting Data from Intent
            supplierID = getIntent().getStringExtra("id");
            supplierName = getIntent().getStringExtra("name");
            supplierAddress = getIntent().getStringExtra("address");
            supplierEmail = getIntent().getStringExtra("email");
            supplierPhone = getIntent().getStringExtra("phone");

            //Setting Intent Data
            supplierIDd.setText(supplierID);
            upName1.setText(supplierName);
            upAddress1.setText(supplierAddress);
            upEmail1.setText(supplierEmail);
            upPhone1.setText(supplierPhone);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}