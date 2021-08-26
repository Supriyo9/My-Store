package com.example.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView Categoryrecycleview;

    LinearLayoutManager testinglinearLayoutManager;

    HomePageAdapter homePageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String title=getIntent().getStringExtra("CategoryName");

        Toolbar toolbar = findViewById(R.id.category_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);


        Categoryrecycleview=findViewById(R.id.category_recyclerview);





        ///////List<SliderModel>sliderModelList=new ArrayList<SliderModel>();



       /* sliderModelList.add(new SliderModel(R.drawable.ic_baseline_shopping_cart_24,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_favorite_24,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.chatt,"#077AE4"));



        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_local_mall_24,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_add_circle_outline_24,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_notifications_24,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_shopping_cart_24,"#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_favorite_24,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.chatt,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_local_mall_24,"#077AE4"));








        List<HorizontalProductModel> horizontalProductModelList=new ArrayList<>();
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera,"Nikon","108MP","Rs.600000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera,"Nikon","108MP","Rs.600000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera,"Nikon","108MP","Rs.600000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera,"Nikon","108MP","Rs.600000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.ic_menu_camera,"Nikon","108MP","Rs.600000/-"));



        */
         testinglinearLayoutManager=new LinearLayoutManager(this);
        testinglinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        Categoryrecycleview.setLayoutManager(testinglinearLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();
       /* homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.ic_baseline_account_circle_24,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the day",horizontalProductModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the day",horizontalProductModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the day",horizontalProductModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.ic_baseline_account_circle_24,"#000000"));
        homePageModelList.add(new HomePageModel(3,"Deals of the day",horizontalProductModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.ic_baseline_account_circle_24,"#000000"));

        */

        homePageAdapter=new HomePageAdapter(homePageModelList);
        Categoryrecycleview.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (R.id.search == id)
        {////

            return true;

        }
        else if (android.R.id.home==id)
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}