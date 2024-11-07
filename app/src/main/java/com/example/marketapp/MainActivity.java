package com.example.marketapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    RecyclerView recyclerView;
    List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        itemList = new ArrayList<>();
        Item item1 = new Item(R.drawable.fruit, "Fruits", "Fresh Fruits from the Garden");
        Item item2 = new Item(R.drawable.vegetables, "Vegetables", "Delicious Vegetables ");
        Item item3 = new Item(R.drawable.dairy, "Dairy", "Milk, Shakes and Yogurt");
        Item item4 = new Item(R.drawable.beverages, "Beverages", "Juice, Tea, Coffee and Soda");
        Item item5 = new Item(R.drawable.popcorn, "Snacks", "Pop Corn, Donut and Drinks");
        Item item6 = new Item(R.drawable.bread, "Bakery", "Bread, Wheat and Beans");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyCustomAdapter adapter = new MyCustomAdapter(itemList, (OnItemClickListener) this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Hey "+ itemList.get(position).getItemTitle(), Toast.LENGTH_LONG).show();
    }
}