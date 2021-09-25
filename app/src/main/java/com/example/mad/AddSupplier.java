package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AddSupplier extends AppCompatActivity {

    TextInputEditText  supplierName, supplierAddress, supplierEmail, supplierPhone;
    ImageButton save_button, back_button, stock, cus, order, sup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplier);


        supplierName = findViewById(R.id.supplierName1);
        supplierAddress = findViewById(R.id.supplierAddress1);
        supplierEmail = findViewById(R.id.supplierEmail1);
        supplierPhone = findViewById(R.id.supplierPhone1);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        save_button = findViewById(R.id.save_button);
        back_button = findViewById(R.id.back_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SupplierDatabaseHelper myDB = new SupplierDatabaseHelper(AddSupplier.this);
                myDB.addSupplier(supplierName.getText().toString().trim(),
                        supplierAddress.getText().toString().trim(),
                        supplierEmail.getText().toString().trim(),
                        supplierPhone.getText().toString().trim());
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddSupplier.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddSupplier.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddSupplier.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddSupplier.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddSupplier.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });
    }
}