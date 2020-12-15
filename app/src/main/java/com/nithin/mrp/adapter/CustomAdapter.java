package com.nithin.mrp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nithin.mrp.R;
import com.nithin.mrp.entities.Model;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myViewHolder> {

    ArrayList<Model> dataholder;

    public CustomAdapter(ArrayList<Model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.pname.setText(dataholder.get(position).getPname());
        holder.pmodel.setText(dataholder.get(position).getPmodel());
        holder.price.setText(dataholder.get(position).getPrice());
        holder.qty.setText(dataholder.get(position).getQty());
        holder.manufacturer.setText(dataholder.get(position).getManufacturer());
        holder.warranty.setText(dataholder.get(position).getWarranty());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView pname, pmodel, price, qty, manufacturer, warranty;
        LinearLayout mainLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            pname = (TextView) itemView.findViewById(R.id.p_name);
            pmodel = (TextView) itemView.findViewById(R.id.p_model);
            price = (TextView) itemView.findViewById(R.id.p_price);
            qty = (TextView) itemView.findViewById(R.id.p_qty);
            manufacturer = (TextView) itemView.findViewById(R.id.p_manu);
            warranty = (TextView) itemView.findViewById(R.id.p_war);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
