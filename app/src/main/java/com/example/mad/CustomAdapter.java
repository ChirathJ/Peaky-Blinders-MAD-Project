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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList stockID, stockName, stockCategory, stockQuantity, stockUnitPrice;

    CustomAdapter(Activity activity, Context context, ArrayList stockID, ArrayList stockName, ArrayList stockCategory, ArrayList stockQuantity,
                  ArrayList stockUnitPrice) {
        this.activity = activity;
        this.context = context;
        this.stockID = stockID;
        this.stockName = stockName;
        this.stockCategory = stockCategory;
        this.stockQuantity = stockQuantity;
        this.stockUnitPrice = stockUnitPrice;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.stock_id_txt.setText(String.valueOf(stockID.get(position)));
        holder.stock_name_txt.setText(String.valueOf(stockName.get(position)));
        holder.stock_category_txt.setText(String.valueOf(stockCategory.get(position)));
        holder.stock_quantity_txt.setText(String.valueOf(stockQuantity.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsStock.class);
                intent.putExtra("id", String.valueOf(stockID.get(position)));
                intent.putExtra("name", String.valueOf(stockName.get(position)));
                intent.putExtra("category", String.valueOf(stockCategory.get(position)));
                intent.putExtra("quantity", String.valueOf(stockQuantity.get(position)));
                intent.putExtra("unitprice", String.valueOf(stockUnitPrice.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stockID.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView stock_id_txt, stock_name_txt, stock_category_txt, stock_quantity_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            stock_id_txt = itemView.findViewById(R.id.stock_id_txt);
            stock_name_txt = itemView.findViewById(R.id.stock_name_txt);
            stock_category_txt = itemView.findViewById(R.id.stock_category_txt);
            stock_quantity_txt = itemView.findViewById(R.id.stock_quantity_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }
}
