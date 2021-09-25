package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class edit_orders extends AppCompatActivity {

    EditText editItemName, editBrand, editCustomer, editDescription, editReqDate;
    ImageButton editOrder, back_button, stock, cus, order, sup;

    String orderId, itemNameEdit, brandEdit, customerEdit, DescriptionEdit, reqDateEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_orders);

        editItemName = findViewById(R.id.editTextItemNameEdit);
        editBrand = findViewById(R.id.editTextBrandEdit);
        editCustomer = findViewById(R.id.editTextCustomer_entry_edit);
        editDescription = findViewById(R.id.editTextItemDescription_entry_edit);
        editReqDate = findViewById(R.id.editTextRequired_Date_entry_edit);
        stock = findViewById(R.id.stock);
        cus = findViewById(R.id.cus);
        order = findViewById(R.id.order);
        sup = findViewById(R.id.sup);
        editOrder = findViewById(R.id.buttonEditOrder);
        back_button = findViewById(R.id.imageBackButtonEditOrder);

        getAndSetIntentData();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(edit_orders.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(edit_orders.this, Home.class);
                startActivity(intent1);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(edit_orders.this, CustomerMainActivity.class);
                startActivity(intent1);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(edit_orders.this, OrderMainActivity.class);
                startActivity(intent1);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(edit_orders.this, SupplierMainActivity.class);
                startActivity(intent1);
            }
        });

        editOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                DBHandler myDB = new DBHandler(edit_orders.this);
                myDB.updateData(orderId,
                        editItemName.getText().toString().trim(),
                        editBrand.getText().toString().trim(),
                        editCustomer.getText().toString().trim(),
                        editDescription.getText().toString().trim(),
                        editReqDate.getText().toString().trim()
                );
            }
        });





    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("itemName") && getIntent().hasExtra("brand") &&
                getIntent().hasExtra("customer") && getIntent().hasExtra("description") && getIntent().hasExtra("reqDate")){
            //Getting Data from Intent
            orderId = getIntent().getStringExtra("id");
            itemNameEdit = getIntent().getStringExtra("itemName");
            brandEdit = getIntent().getStringExtra("brand");
            customerEdit = getIntent().getStringExtra("customer");
            DescriptionEdit = getIntent().getStringExtra("description");
            reqDateEdit = getIntent().getStringExtra("reqDate");


            //Setting Intent Data
            editItemName.setText(itemNameEdit);
            editBrand.setText(brandEdit);
            editCustomer.setText(customerEdit);
            editDescription.setText(DescriptionEdit);
            editReqDate.setText(reqDateEdit);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }




}