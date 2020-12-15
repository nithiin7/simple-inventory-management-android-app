package com.nithin.mrp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nithin.mrp.DeleteConfirmActivity;
import com.nithin.mrp.R;
import com.nithin.mrp.database.OrderHistoryDBHelper;
import com.nithin.mrp.entities.OrderDetails;

import java.util.ArrayList;

public class CustomAdapterDetails extends RecyclerView.Adapter<CustomAdapterDetails.myViewHolder> {

    ArrayList<OrderDetails> dataholder;
    private Context context;

    public CustomAdapterDetails(ArrayList<OrderDetails> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public CustomAdapterDetails.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.order_history_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterDetails.myViewHolder holder, final int position) {
        holder.pname.setText(dataholder.get(position).getPname());
        holder.pmodel.setText(dataholder.get(position).getPmodel());
        holder.price.setText(dataholder.get(position).getPrice());
        holder.manufacturer.setText(dataholder.get(position).getManufacturer());
        holder.warranty.setText(dataholder.get(position).getWarranty());

        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DeleteConfirmActivity.class);
                intent.putExtra("Pmodel", dataholder.get(position).getPmodel());
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
        Button cancel;
        OrderHistoryDBHelper DB;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            pname = (TextView) itemView.findViewById(R.id.p_name);
            pmodel = (TextView) itemView.findViewById(R.id.p_model);
            price = (TextView) itemView.findViewById(R.id.p_price);
            manufacturer = (TextView) itemView.findViewById(R.id.p_manu);
            warranty = (TextView) itemView.findViewById(R.id.p_war);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            cancel = (Button) itemView.findViewById(R.id.btnCancel);
        }
    }
}
