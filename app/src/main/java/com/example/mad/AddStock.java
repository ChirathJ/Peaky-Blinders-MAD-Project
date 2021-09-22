package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;

public class AddStock extends AppCompatActivity {

    TextInputEditText stockName, stockCategory, stockQuantity, stockUnitPrice;
    ImageButton save_button, back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);

        stockName = findViewById(R.id.stockName1);
        stockCategory = findViewById(R.id.stockCategory1);
        stockQuantity = findViewById(R.id.stockQuantity1);
        stockUnitPrice = findViewById(R.id.stockUnitPrice1);
        save_button = findViewById(R.id.save_button);
        back_button = findViewById(R.id.back_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddStock.this);
                myDB.addStock(stockName.getText().toString().trim(),
                        stockCategory.getText().toString().trim(),
                        Integer.parseInt(stockUnitPrice.getText().toString().trim()),
                        Integer.parseInt(stockQuantity.getText().toString().trim()));
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddStock.this, Home.class);
                startActivity(intent1);
            }
        });
    }
}