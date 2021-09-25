package com.example.mad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList customerID, customerName, customerEmail, customerPhone, customerJoinedDate;

    CustomerAdapter(Activity activity, Context context, ArrayList customerID, ArrayList customerName, ArrayList customerEmail, ArrayList customerPhone,
                    ArrayList customerJoinedDate) {
        this.activity = activity;
        this.context = context;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerJoinedDate = customerJoinedDate;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new CustomerViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final CustomerViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.customer_id_txt.setText(String.valueOf(customerID.get(position)));
        holder.customer_name_txt.setText(String.valueOf(customerName.get(position)));
        holder.customer_email_txt.setText(String.valueOf(customerEmail.get(position)));
        holder.customer_phone_txt.setText(String.valueOf(customerPhone.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsCustomer.class);
                intent.putExtra("id", String.valueOf(customerID.get(position)));
                intent.putExtra("name", String.valueOf(customerName.get(position)));
                intent.putExtra("email", String.valueOf(customerEmail.get(position)));
                intent.putExtra("phone", String.valueOf(customerPhone.get(position)));
                intent.putExtra("joineddate",String.valueOf(customerJoinedDate.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customerID.size();
    }

    class CustomerViewHolder extends RecyclerView.ViewHolder {

        TextView customer_id_txt, customer_name_txt, customer_email_txt, customer_phone_txt;
        LinearLayout mainLayout;

        CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            customer_id_txt = itemView.findViewById(R.id.customer_id_txt);
            customer_name_txt = itemView.findViewById(R.id.customer_name_txt);
            customer_email_txt = itemView.findViewById(R.id.customer_email_txt);
            customer_phone_txt = itemView.findViewById(R.id.customer_phone_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }
}
