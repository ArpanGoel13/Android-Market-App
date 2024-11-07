package com.example.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {
    List<Item> itemList;
    OnItemClickListener myListener;

    public MyCustomAdapter(List<Item> itemList, OnItemClickListener myListener) {
        this.itemList = itemList;
        this.myListener = myListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item items = itemList.get(position);
        holder.itemImageView.setImageResource(items.getItemImage());
        holder.itemTitleTextView.setText(items.getItemTitle());
        holder.itemDesTextView.setText(items.getItemDescription());
        holder.bind(myListener, position);

    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImageView;
        TextView itemTitleTextView;
        TextView itemDesTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.itemImageView);
            itemTitleTextView = itemView.findViewById(R.id.itemTitle);
            itemDesTextView = itemView.findViewById(R.id.itemDescription);
        }
        public void bind(OnItemClickListener listener, int position){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, position);
                }
            });
        }
    }
}
