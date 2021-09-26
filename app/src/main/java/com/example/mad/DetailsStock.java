package com.example.mad;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsStock extends AppCompatActivity {

    TextView stockIDd, stockNamed, stockCategoryd, stockQuantityd, stockUnitPriced, stockTotalPriced;
    ImageButton update_button, updatestock_button, delete_button, back_button, stock, cus, order, sup;

    String stockID, stockName, stockCategory, stockQuantity, stockUnitPrice;
    int stockTotalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_stock);

        stockIDd = findViewById(R.id.stockIDd);
        stockNamed = findViewById(R.id.stockNamed);
        stockCategoryd = findViewById(R.id.stockCategoryd);
        stockQuantityd = findViewById(R.id.stockQuantityd);
        stockUnitPriced = findViewById(R.id.stockUnitPriced);
        stockTotalPriced = findViewById(R.id.stockTotalPriced);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        back_button = findViewById(R.id.back_button);
        updatestock_button = findViewById(R.id.updatestock_button);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsStock.this, UpdateStock.class);
                intent.putExtra("id", String.valueOf(stockID));
                intent.putExtra("name", String.valueOf(stockName));
                intent.putExtra("category", String.valueOf(stockCategory));
                intent.putExtra("quantity", String.valueOf(stockQuantity));
                intent.putExtra("unitprice", String.valueOf(stockUnitPrice));
                startActivity(intent);
            }
        });

        updatestock_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsStock.this, UpdateQuantity.class);
                intent.putExtra("id", String.valueOf(stockID));
                intent.putExtra("name", String.valueOf(stockName));
                intent.putExtra("category", String.valueOf(stockCategory));
                intent.putExtra("quantity", String.valueOf(stockQuantity));
                intent.putExtra("unitprice", String.valueOf(stockUnitPrice));
                startActivity(intent);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        getAndSetIntentData();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsStock.this, Home.class);
                startActivity(intent1);
            }
        });

        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsStock.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsStock.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsStock.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsStock.this, SupplierMainActivity.class);
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

            //calculation
            stockTotalPrice = calculation(stockQuantity, stockUnitPrice);

            //Setting Intent Data
            stockIDd.setText(stockID);
            stockNamed.setText(stockName);
            stockCategoryd.setText(stockCategory);
            stockQuantityd.setText(stockQuantity);
            stockUnitPriced.setText(stockUnitPrice);
            stockTotalPriced.setText(String.valueOf(stockTotalPrice));
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + stockName + " ?");
        builder.setMessage("Are you sure you want to delete " + stockName + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(DetailsStock.this);
                myDB.deleteOneRow(stockID);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    static int calculation(String quant, String price){
        int TotalPrice;
        TotalPrice = Integer.parseInt(quant)*Integer.parseInt(price);
        return TotalPrice;
    }

}