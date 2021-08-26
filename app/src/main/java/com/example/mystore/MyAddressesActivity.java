package com.example.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.mystore.DeliveryActivity.SELECT_ADDRESS;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myaddresssrecycleviewr;

    private Button deliverhere;

    private static AddressesAdapter addressesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        deliverhere=findViewById(R.id.deliverherebtn);
        myaddresssrecycleviewr=findViewById(R.id.adressesrecycleviewr);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myaddresssrecycleviewr.setLayoutManager(linearLayoutManager);

        List<AddressesModel> addressesModelList =new ArrayList<>();

        addressesModelList.add(new AddressesModel("supriyo","homeeeeee","815351",true));
        addressesModelList.add(new AddressesModel("supriyo","homeeeeee","815351",false));

        int mode=getIntent().getIntExtra("MODE",-1);

        if(mode==SELECT_ADDRESS)
        {
            deliverhere.setVisibility(View.VISIBLE);
        }
        else
        {
            deliverhere.setVisibility(View.INVISIBLE);
        }
        addressesAdapter =new AddressesAdapter(addressesModelList,mode);
        myaddresssrecycleviewr.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myaddresssrecycleviewr.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();





    }

    public  static void refreshitem(int select,int deselect)
    {
        addressesAdapter.notifyItemChanged(deselect);
        addressesAdapter.notifyItemChanged(select);

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            finish();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}