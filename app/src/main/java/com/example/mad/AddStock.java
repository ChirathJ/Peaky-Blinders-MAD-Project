package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AddStock extends AppCompatActivity {

    TextInputEditText stockName, stockQuantity, stockUnitPrice;
    ImageButton save_button, back_button, stock, cus, order, sup;
    AutoCompleteTextView stockCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);

        stockName = findViewById(R.id.stockName1);
        stockQuantity = findViewById(R.id.stockQuantity1);
        stockCategory = findViewById(R.id.stockCategory1);
        stockUnitPrice = findViewById(R.id.stockUnitPrice1);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        save_button = findViewById(R.id.save_button);
        back_button = findViewById(R.id.back_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddStock.this);
                if(stockName.getText().toString().trim().equals("") || stockCategory.getText().toString().trim().equals("") || stockUnitPrice.getText().toString().trim().equals("") || stockQuantity.getText().toString().trim().equals("")){
                    toast();
                }
                else {
                    myDB.addStock(stockName.getText().toString().trim(),
                            stockCategory.getText().toString().trim(),
                            Integer.parseInt(stockUnitPrice.getText().toString().trim()),
                            Integer.parseInt(stockQuantity.getText().toString().trim()));
                }
            }
        });

        String[] type = new String[] {"Food", "Chemicals", "Cleaning Equipment", "Pharmaceuticals"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        R.layout.dropdown,
                        type);

        AutoCompleteTextView editTextFilledExposedDropdown =
                findViewById(R.id.stockCategory1);
        editTextFilledExposedDropdown.setAdapter(adapter);

        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddStock.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddStock.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddStock.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(AddStock.this, SupplierMainActivity.class);
                startActivity(intent1);
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
    void toast(){
            Toast.makeText(this,"Enter Data",Toast.LENGTH_LONG).show();
    }
}