package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class edit_orders extends AppCompatActivity {

    EditText editItemName, editBrand, editCustomer, editDescription, editReqDate;
    ImageButton editOrder, back_button;

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

        editOrder = findViewById(R.id.buttonEditOrder);
        back_button = findViewById(R.id.imageBackButtonEditOrder);

        getAndSetIntentData();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                finish();
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