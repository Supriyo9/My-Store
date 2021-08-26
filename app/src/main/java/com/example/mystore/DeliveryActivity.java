package com.example.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView deliveryItemRecycleview;

    private Button changroradd;

    public  static final int SELECT_ADDRESS=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Delivery");



        ///////////////////////////
        deliveryItemRecycleview =findViewById(R.id.deliverrecyclerview);

        changroradd=findViewById(R.id.change_or_add_address);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryItemRecycleview.setLayoutManager(linearLayoutManager);

        List<CartItemModel> cartItemModelsList=new ArrayList<>();
        cartItemModelsList.add(new CartItemModel(0,R.drawable.ic_menu_camera,"Nikon",2,"Rs.4999/-","Rs.4999/-",1,0,0));
        cartItemModelsList.add(new CartItemModel(0,R.drawable.ic_menu_camera,"Nikon",0,"Rs.4999/-","Rs.4999/-",1,1,0));
        cartItemModelsList.add(new CartItemModel(0,R.drawable.ic_menu_camera,"Nikon",2,"Rs.4999/-","Rs.4999/-",1,2,0));

        cartItemModelsList.add(new CartItemModel(1,"Price(3)","Rs.170000/-","Free","Rs.170000/-","Rs.170000/-"));

        CartAdapter cartAdapter=new CartAdapter(cartItemModelsList);
        deliveryItemRecycleview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changroradd.setVisibility(View.VISIBLE);

        changroradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DeliveryActivity.this,MyAddressesActivity.class);
                intent.putExtra("MODE", SELECT_ADDRESS);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (android.R.id.home == id) {////

            finish();
            return true;


        }


        return super.onOptionsItemSelected(item);


    }
}