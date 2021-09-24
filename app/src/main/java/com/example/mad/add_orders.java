package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class add_orders extends AppCompatActivity {

    private EditText ItemName, Brand, Customer, Description, reqDate;
    private ImageButton addOrder,backButton;
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
                Intent intent1 = new Intent(add_orders.this, MainActivity.class);
                startActivity(intent1);
            }
        });




    }
}