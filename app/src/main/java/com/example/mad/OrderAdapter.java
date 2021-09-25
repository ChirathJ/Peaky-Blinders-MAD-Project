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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList orderID, ItemName, Brand, Customer, Description, ReqDate;

    public OrderAdapter(Context context, Activity activity, ArrayList orderID, ArrayList itemName, ArrayList brand, ArrayList customer, ArrayList description, ArrayList reqDate) {
        this.context = context;
        this.activity = activity;
        this.orderID = orderID;
        this.ItemName = itemName;
        this.Brand = brand;
        this.Customer = customer;
        this.Description = description;
        this.ReqDate = reqDate;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_order, parent, false);
        return new OrderViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final OrderViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.order_id_txt.setText(String.valueOf(orderID .get(position)));
        holder.order_CustomerName_txt.setText(String.valueOf(Customer.get(position)));
        holder.order_itemName_text.setText(String.valueOf(ItemName.get(position)));
        holder.reqDate_txt.setText(String.valueOf(ReqDate.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, details_order.class);
                intent.putExtra("id", String.valueOf(orderID.get(position)));
                intent.putExtra("itemName", String.valueOf(ItemName.get(position)));
                intent.putExtra("brand", String.valueOf(Brand.get(position)));
                intent.putExtra("customer", String.valueOf(Customer.get(position)));
                intent.putExtra("description", String.valueOf(Description.get(position)));
                intent.putExtra("reqDate", String.valueOf(ReqDate.get(position)));


                activity.startActivityForResult(intent, 1);
            }
        });


    }


    @Override
    public int getItemCount() {
        return orderID.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView order_id_txt, order_CustomerName_txt, order_itemName_text, reqDate_txt;
        LinearLayout mainLayout;

        OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            order_id_txt= itemView.findViewById(R.id.order_id_txt);
            order_CustomerName_txt= itemView.findViewById(R.id.customer_name_txt);
            order_itemName_text= itemView.findViewById(R.id.order_itemName_txt);
            reqDate_txt = itemView.findViewById(R.id.order_reqDate_txt);


            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }
}