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

public class details_order extends AppCompatActivity {

    TextView orderIDd, ItemNamed, Brandd, Customerd, Descriptiond, ReqDated;
    ImageButton update_button, delete_button, back_button, stock, cus, order, sup;

    String orderID, itemName, brand, customer, description, reqDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_order);

        orderIDd = findViewById(R.id.txtViewOrderID);
        ItemNamed = findViewById(R.id.txtViewItemName);
        Brandd = findViewById(R.id.txtViewBrand);
        Customerd = findViewById(R.id.txtViewCustomer);
        Descriptiond = findViewById(R.id.txtViewDescription);
        ReqDated = findViewById(R.id.txtViewReqDate);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        update_button = findViewById(R.id.update_orderDetails);
        delete_button = findViewById(R.id.delete_orderDetails);
        back_button = findViewById(R.id.imageButtonBack2);


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(details_order.this, edit_orders.class);
                intent.putExtra("id", String.valueOf(orderID));
                intent.putExtra("itemName", String.valueOf(itemName));
                intent.putExtra("brand", String.valueOf(brand));
                intent.putExtra("customer", String.valueOf(customer));
                intent.putExtra("description", String.valueOf(description));
                intent.putExtra("reqDate", String.valueOf(reqDate));
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
                Intent intent1 = new Intent(details_order.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(details_order.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(details_order.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(details_order.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(details_order.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });

    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("itemName") &&
                getIntent().hasExtra("brand") && getIntent().hasExtra("customer") && getIntent().hasExtra("description")&& getIntent().hasExtra("reqDate")){
            //Getting Data from Intent
            orderID = getIntent().getStringExtra("id");
            itemName = getIntent().getStringExtra("itemName");
            brand = getIntent().getStringExtra("brand");
            customer = getIntent().getStringExtra("customer");
            description = getIntent().getStringExtra("description");
            reqDate = getIntent().getStringExtra("reqDate");

            //Setting Intent Data
            orderIDd.setText(orderID);
            ItemNamed.setText(itemName);
            Brandd.setText(brand);
            Customerd.setText(customer);
            Descriptiond.setText(description);
            ReqDated.setText(reqDate);

        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + customer + " ?");
        builder.setMessage("Are you sure you want to delete " + customer + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBHandler myDB = new DBHandler(details_order.this);
                myDB.deleteOneRow(orderID);
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