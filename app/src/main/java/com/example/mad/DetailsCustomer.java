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

public class DetailsCustomer extends AppCompatActivity {

    TextView customerIDd, customerNamed, customerEmaild, customerPhoned, customerJoinedDated;
    ImageButton update_button, updatecustomer_button, delete_button, back_button, stock, cus, order, sup;

    String customerID, customerName, customerEmail, customerPhone, customerJoinedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_customer);

        customerIDd = findViewById(R.id.customerIDd);
        customerNamed = findViewById(R.id.customerNamed);
        customerEmaild = findViewById(R.id.customerEmaild);
        customerPhoned = findViewById(R.id.customerPhoned);
        customerJoinedDated = findViewById(R.id.customerJoinedDated);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        back_button = findViewById(R.id.back_button);
        updatecustomer_button = findViewById(R.id.updatecustomer_button);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsCustomer.this, UpdateCustomer.class);
                intent.putExtra("id", String.valueOf(customerID));
                intent.putExtra("name", String.valueOf(customerName));
                intent.putExtra("email", String.valueOf(customerEmail));
                intent.putExtra("phone", String.valueOf(customerPhone));
                intent.putExtra("joineddate", String.valueOf(customerJoinedDate));
                startActivity(intent);
            }
        });

        updatecustomer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsCustomer.this, UpdatePhone.class);
                intent.putExtra("id", String.valueOf(customerID));
                intent.putExtra("name", String.valueOf(customerName));
                intent.putExtra("email", String.valueOf(customerEmail));
                intent.putExtra("phone", String.valueOf(customerPhone));
                intent.putExtra("joineddate", String.valueOf(customerJoinedDate));
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
                Intent intent1 = new Intent(DetailsCustomer.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsCustomer.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsCustomer.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsCustomer.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(DetailsCustomer.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });

    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("email") && getIntent().hasExtra("phone") && getIntent().hasExtra("joineddate")){
            //Getting Data from Intent
            customerID = getIntent().getStringExtra("id");
            customerName = getIntent().getStringExtra("name");
            customerEmail = getIntent().getStringExtra("email");
            customerPhone = getIntent().getStringExtra("phone");
            customerJoinedDate = getIntent().getStringExtra("joineddate");

            //Setting Intent Data
            customerIDd.setText(customerID);
            customerNamed.setText(customerName);
            customerEmaild.setText(customerEmail);
            customerPhoned.setText(customerPhone);
            customerJoinedDated.setText(customerJoinedDate);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + customerName + " ?");
        builder.setMessage("Are you sure you want to delete " + customerName + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CustomerDatabaseHelper myDB = new CustomerDatabaseHelper(DetailsCustomer.this);
                myDB.deleteOneRow(customerID);
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