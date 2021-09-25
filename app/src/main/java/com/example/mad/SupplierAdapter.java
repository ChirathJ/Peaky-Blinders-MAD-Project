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

public class SupplierAdapter extends RecyclerView.Adapter<SupplierAdapter.SupplierViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList supplierID, supplierName, supplierAddress, supplierEmail, supplierPhone;

    SupplierAdapter(Activity activity, Context context, ArrayList supplierID, ArrayList supplierName, ArrayList supplierAddress, ArrayList supplierEmail,
                    ArrayList supplierPhone) {
        this.activity = activity;
        this.context = context;
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }

    @NonNull
    @Override
    public SupplierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.supp_row, parent, false);
        return new SupplierViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final SupplierViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.supplier_id_txt.setText(String.valueOf(supplierID.get(position)));
        holder.supplier_name_txt.setText(String.valueOf(supplierName.get(position)));
        holder.supplier_address_txt.setText(String.valueOf(supplierAddress.get(position)));
        holder.supplier_phone_txt.setText(String.valueOf(supplierPhone.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsSupplier.class);
                intent.putExtra("id", String.valueOf(supplierID.get(position)));
                intent.putExtra("name", String.valueOf(supplierName.get(position)));
                intent.putExtra("address", String.valueOf(supplierAddress.get(position)));
                intent.putExtra("email", String.valueOf(supplierEmail.get(position)));
                intent.putExtra("phone", String.valueOf(supplierPhone.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return supplierID.size();
    }

    class SupplierViewHolder extends RecyclerView.ViewHolder {

        TextView supplier_id_txt, supplier_name_txt, supplier_address_txt, supplier_email_txt, supplier_phone_txt;
        LinearLayout mainLayout;

        SupplierViewHolder(@NonNull View itemView) {
            super(itemView);
            supplier_id_txt = itemView.findViewById(R.id.supplier_id_txt);
            supplier_name_txt = itemView.findViewById(R.id.supplier_name_txt);
            supplier_address_txt = itemView.findViewById(R.id.supplier_address_txt);
            supplier_phone_txt = itemView.findViewById(R.id.supplier_phone_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }
}
