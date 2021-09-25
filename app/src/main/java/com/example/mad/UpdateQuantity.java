package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class UpdateQuantity extends AppCompatActivity {

    TextView stockIDd, stockNamed;
    TextInputEditText quantityentry;
    ImageButton save_button, back_button, stock, cus, order, sup;

    String stockID, stockName, stockCategory, stockQuantity, stockUnitPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quantity);

        stockIDd = findViewById(R.id.stockIDdup);
        stockNamed = findViewById(R.id.stockNamedup);
        quantityentry = findViewById(R.id.upquantityentry);
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
                Intent intent1 = new Intent(UpdateQuantity.this, Home.class);
                startActivity(intent1);
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateQuantity.this);
                myDB.updateData(stockID,stockName,stockCategory,
                        Integer.parseInt(quantityentry.getText().toString().trim()),
                        Integer.parseInt(stockUnitPrice.trim()));
            }
        });

        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateQuantity.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateQuantity.this, Home.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateQuantity.this, Home.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(UpdateQuantity.this, Home.class);
                startActivity(intent1);
            }
        });

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
            stockNamed.setText(stockName);
            quantityentry.setText(stockQuantity);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}