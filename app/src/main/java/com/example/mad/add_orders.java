package com.example.mad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class add_orders extends AppCompatActivity {

    private EditText ItemName, Brand, Customer, Description, reqDate;
    private ImageButton addOrder,backButton, stock, cus, order, sup;
    private DBHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_orders);

        ItemName = findViewById(R.id.editTextItemName);
        Brand = findViewById(R.id.editTextBrand);
        Customer = findViewById(R.id.editTextCustomerName);
        Description = findViewById(R.id.editTextItemDescription);
        reqDate = findViewById(R.id.editTextRequiredDate);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        backButton = findViewById(R.id.imageButtonBack1);

        addOrder = (ImageButton) findViewById(R.id.buttonAddAOrder);
        backButton = findViewById(R.id.imageButtonBack1);

        context = this;

        dbHandler = new DBHandler(add_orders.this);



        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {

                String orderItemName = ItemName.getText().toString();
                String orderBrand = Brand.getText().toString();
                String orderCustomer = Customer.getText().toString();
                String orderDescription = Description.getText().toString();
                String orderReqDate = reqDate.getText().toString();

                OrdersModelClass order = new OrdersModelClass(orderItemName,orderBrand,orderCustomer,orderDescription,orderReqDate);
                dbHandler.addOrders(order);

            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intent1 = new Intent(add_orders.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(add_orders.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(add_orders.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(add_orders.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(add_orders.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });


    }
}