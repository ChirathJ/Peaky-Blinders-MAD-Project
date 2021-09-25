package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class UpdateStock extends AppCompatActivity {

    TextView stockIDd;
    TextInputEditText upName1, upUnitPrice1, upQuantity1;
    ImageButton update_button, back_button, stock, cus, order, sup;
    AutoCompleteTextView upCategory1;

    String stockID, stockName, stockCategory, stockQuantity, stockUnitPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_stock);

        stockIDd = findViewById(R.id.stockID);
        upName1 = findViewById(R.id.upName1);
        upUnitPrice1 = findViewById(R.id.upUnitPrice1);
        upCategory1 = findViewById(R.id.upCategory1);
        upQuantity1 = findViewById(R.id.upQuantity1);
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
                Intent intent1 = new Intent(UpdateStock.this, Home.class);
                startActivity(intent1);
            }
        });

        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateStock.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateStock.this, Home.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateStock.this, Home.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateStock.this, Home.class);
                startActivity(intent1);
            }
        });

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateStock.this);
                myDB.updateData(stockID,upName1.getText().toString().trim(),
                        upCategory1.getText().toString().trim(),
                        Integer.parseInt(upQuantity1.getText().toString().trim()),
                        Integer.parseInt(upUnitPrice1.getText().toString().trim()));
            }
        });

        String[] type = new String[] {"Food", "Chemicals", "Cleaning Equipment", "Pharmaceuticals"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        R.layout.dropdown,
                        type);

        AutoCompleteTextView editTextFilledExposedDropdown =
                findViewById(R.id.upCategory1);
        editTextFilledExposedDropdown.setAdapter(adapter);

    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("category") && getIntent().hasExtra("quantity") && getIntent().hasExtra("unitprice")){
            //Getting Data from Intent
            stockID = getIntent().getStringExtra("id");
            stockName = getIntent().getStringExtra("name");
            stockCategory = getIntent().getStringExtra("category");
            stockQuantity = getIntent().getStringExtra("quantity");
            stockUnitPrice = getIntent().getStringExtra("unitprice");

            //Setting Intent Data
            stockIDd.setText(stockID);
            upName1.setText(stockName);
            upCategory1.setText(stockCategory);
            upQuantity1.setText(stockQuantity);
            upUnitPrice1.setText(stockUnitPrice);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}