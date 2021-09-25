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

public class DetailsSupplier extends AppCompatActivity {

    TextView supplierIDd, supplierNamed, supplierAddressd, supplierEmaild, supplierPhoned;
    ImageButton update_button, updatesupplier_button, delete_button, back_button, stock, cus, order, sup;

    String supplierID, supplierName, supplierAddress, supplierEmail, supplierPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_supplier);

        supplierIDd = findViewById(R.id.supplierIDd);
        supplierNamed = findViewById(R.id.supplierNamed);
        supplierAddressd = findViewById(R.id.supplierAddressd);
        supplierEmaild = findViewById(R.id.supplierEmaild);
        supplierPhoned = findViewById(R.id.supplierPhoned);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        back_button = findViewById(R.id.back_button);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsSupplier.this, UpdateSupplier.class);
                intent.putExtra("id", String.valueOf(supplierID));
                intent.putExtra("name", String.valueOf(supplierName));
                intent.putExtra("address", String.valueOf(supplierAddress));
                intent.putExtra("email", String.valueOf(supplierEmail));
                intent.putExtra("phone", String.valueOf(supplierPhone));
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
                Intent intent1 = new Intent(DetailsSupplier.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsSupplier.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsSupplier.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsSupplier.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsSupplier.this, SupplierMainActivity.class);
                startActivity(intent1);
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
            supplierNamed.setText(supplierName);
            supplierAddressd.setText(supplierAddress);
            supplierEmaild.setText(supplierEmail);
            supplierPhoned.setText(supplierPhone);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + supplierName + " ?");
        builder.setMessage("Are you sure you want to delete " + supplierName + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SupplierDatabaseHelper myDB = new SupplierDatabaseHelper(DetailsSupplier.this);
                myDB.deleteOneRow(supplierID);
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
}