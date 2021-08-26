package com.example.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);


        recyclerView = findViewById(R.id.recycleviewerviewall);
        gridView = findViewById(R.id.gridviewviewall);

        int layout_code = getIntent().getIntExtra("layout_code", -1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My deals");


        if (layout_code == 0) {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);


            List<WishListModel> ListModelList = new ArrayList<>();

            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 1, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 0, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 1, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 5, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 0, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 3, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 1, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 0, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 1, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 5, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 0, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));
            ListModelList.add(new WishListModel(R.drawable.ic_menu_camera, "Nikon", 3, "3", 124, "Rs.49999/-", "Rs.4999/-", "Cash On Delivery"));


            WishListAdapater Adapaterr = new WishListAdapater(ListModelList, false);
            recyclerView.setAdapter(Adapaterr);
            Adapaterr.notifyDataSetChanged();

        }


        else if (layout_code == 1) {
            gridView.setVisibility(View.VISIBLE);


           List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
           /*
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera, "Nikon", "108MP", "Rs.600000/-"));

           */


            GridProductViewAdapter gridProductViewAdapter = new GridProductViewAdapter(horizontalProductModelList);
            gridView.setAdapter(gridProductViewAdapter);
        }


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}