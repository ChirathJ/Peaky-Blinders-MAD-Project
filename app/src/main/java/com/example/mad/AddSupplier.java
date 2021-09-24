package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;

public class AddSupplier extends AppCompatActivity {

    TextInputEditText  supplierName, supplierAddress, supplierEmail, supplierPhone;
    ImageButton save_button, back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplier);


        supplierName = findViewById(R.id.supplierName1);
        supplierAddress = findViewById(R.id.supplierAddress1);
        supplierEmail = findViewById(R.id.supplierEmail1);
        supplierPhone = findViewById(R.id.supplierPhone1);
        save_button = findViewById(R.id.save_button);
        back_button = findViewById(R.id.back_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddSupplier.this);
                myDB.addSupplier(supplierName.getText().toString().trim(),
                        supplierAddress.getText().toString().trim(),
                        supplierEmail.getText().toString().trim(),
                      Integer.parseInt (supplierPhone.getText().toString().trim()));

            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddSupplier.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}