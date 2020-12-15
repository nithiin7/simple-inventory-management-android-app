package com.nithin.mrp.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nithin.mrp.BuyDetailsActivity;
import com.nithin.mrp.R;
import com.nithin.mrp.entities.Model;

import java.util.ArrayList;

public class CustomAdapterBuy extends RecyclerView.Adapter<CustomAdapterBuy.myViewHolder> {

    ArrayList<Model> dataholder;
    private Context context;


    public CustomAdapterBuy(ArrayList<Model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public CustomAdapterBuy.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.buy_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {

        holder.pname.setText(dataholder.get(position).getPname());
        holder.pmodel.setText(dataholder.get(position).getPmodel());
        holder.price.setText(dataholder.get(position).getPrice());
        holder.manufacturer.setText(dataholder.get(position).getManufacturer());
        holder.warranty.setText(dataholder.get(position).getWarranty());


        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BuyDetailsActivity.class);
                intent.putExtra("Pname", dataholder.get(position).getPname());
                intent.putExtra("Pmodel", dataholder.get(position).getPmodel());
                intent.putExtra("Pprice", dataholder.get(position).getPrice());
                intent.putExtra("Pmanu", dataholder.get(position).getManufacturer());
                intent.putExtra("Pwar", dataholder.get(position).getWarranty());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView pname, pmodel, price, manufacturer, warranty;
        LinearLayout mainLayout;
        Button button;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            pname = (TextView) itemView.findViewById(R.id.p_name);
            pmodel = (TextView) itemView.findViewById(R.id.p_model);
            price = (TextView) itemView.findViewById(R.id.p_price);
            manufacturer = (TextView) itemView.findViewById(R.id.p_manu);
            warranty = (TextView) itemView.findViewById(R.id.p_war);
            button = (Button) itemView.findViewById(R.id.btnBuy);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}