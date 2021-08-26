package com.example.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.mystore.MainActivity.showCart;

public class ProductsDetailsActivity extends AppCompatActivity {

    private ViewPager productsiamgesviewpager;
    private TabLayout vierpagerindicator;
    private Button coupanReedemBtn;

    /////////////////////////////////////////////////////////cupandialog

    public static TextView coupantitle;
    public static TextView coupanbody;
    public static TextView coupanexpiraydate;
    private static RecyclerView coupanrecycleview;
    private static LinearLayout selectedcoupan;

    /////////////////////////////////////////////////////////cupandialog

    //////////////////////////////rating layout
    private LinearLayout rateNowContainer;

    //////////////////////////////rating layout

    private Button buynow;


    private FloatingActionButton addtowishlist;
    private static boolean AlreadyAddedToWishList = false;

    private ViewPager productDetailsViewpger;
    private TabLayout productDetailsTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        productsiamgesviewpager = findViewById(R.id.product_images_viewpager);
        vierpagerindicator = findViewById(R.id.viewPagerindicator);
        addtowishlist = findViewById(R.id.add_to_wishlist);
        productDetailsViewpger = findViewById(R.id.product_detail_viewpager);
        productDetailsTablayout = findViewById(R.id.product_details_tablayout);
        buynow = findViewById(R.id.buy_now_btn);
        coupanReedemBtn = findViewById(R.id.coupan_redeem_btn);

        List<Integer> productiamges = new ArrayList<>();
        productiamges.add(R.drawable.chatt);
        productiamges.add(R.drawable.ic_baseline_favorite_24);
        productiamges.add(R.drawable.chatt);
        productiamges.add(R.drawable.chatt);

        ProductImagesAdpater productImagesAdpater = new ProductImagesAdpater(productiamges);
        productsiamgesviewpager.setAdapter(productImagesAdpater);

        //to connect both them

        vierpagerindicator.setupWithViewPager(productsiamgesviewpager, true);

        ////////////////////////

        addtowishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AlreadyAddedToWishList) {
                    AlreadyAddedToWishList = false;
                    addtowishlist.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));

                } else {
                    AlreadyAddedToWishList = true;
                    addtowishlist.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimary));

                }

            }
        });


        productDetailsViewpger.setAdapter(new ProductsDetailsAdapter(getSupportFragmentManager(), productDetailsTablayout.getTabCount()));

        productDetailsViewpger.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));
        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewpger.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //////////////////////////////rating layout
        rateNowContainer = findViewById(R.id.rate_now_container);

        for (int x = 0; x < rateNowContainer.getChildCount(); x++) {
            final int starposition = x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starposition);
                }
            });


        }
        //////////////////////////////rating layout


        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductsDetailsActivity.this, DeliveryActivity.class);
                startActivity(intent);
            }
        });

        //////////////////////////////////coupan dialog

        final Dialog checkcoupanpricedailog = new Dialog(ProductsDetailsActivity.this);
        checkcoupanpricedailog.setContentView(R.layout.coupan_redeem_dialog);
        checkcoupanpricedailog.setCancelable(true);
        checkcoupanpricedailog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView openrecyclerviewccoupan = checkcoupanpricedailog.findViewById(R.id.toggle_recycleview);
        coupanrecycleview = checkcoupanpricedailog.findViewById(R.id.coupan_recyclerView);
        selectedcoupan = checkcoupanpricedailog.findViewById(R.id.selected_coupan);
        coupantitle = checkcoupanpricedailog.findViewById(R.id.coupan_title_reward);
        coupanbody = checkcoupanpricedailog.findViewById(R.id.coupan_body_rewad);
        coupanexpiraydate = checkcoupanpricedailog.findViewById(R.id.coupan_validity_rewad);


        TextView originalprice = checkcoupanpricedailog.findViewById(R.id.original_price);
        TextView discountedprice = checkcoupanpricedailog.findViewById(R.id.discounted_price);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductsDetailsActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        coupanrecycleview.setLayoutManager(linearLayoutManager);


        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("CashBack", "Till 2020", "Get 20% Discount By Using This On each Product"));
        rewardModelList.add(new RewardModel("CashBack", "Till 2020", "Get 20% Discount By Using This On each Product"));
        rewardModelList.add(new RewardModel("Buy one Get One Free", "Till 2020", "Get 20% Discount By Using This On each Product"));
        rewardModelList.add(new RewardModel("CashBack", "Till 2020", "Get 20% Discount By Using This On each Product"));


        RewardAdpater rewardAdpater = new RewardAdpater(rewardModelList, true);
        coupanrecycleview.setAdapter(rewardAdpater);
        rewardAdpater.notifyDataSetChanged();


        openrecyclerviewccoupan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                togglerecyclerview();

            }
        });




        coupanReedemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkcoupanpricedailog.show();
            }
        });


        ///////////////////////////////////////////coupan dialog


    }


    public static void togglerecyclerview() {
        if (coupanrecycleview.getVisibility() == View.GONE) {
            coupanrecycleview.setVisibility(View.VISIBLE);
            selectedcoupan.setVisibility(View.GONE);
        } else {
            coupanrecycleview.setVisibility(View.GONE);
            selectedcoupan.setVisibility(View.VISIBLE);
        }
    }

    private void setRating(int starposition) {

        for (int x = 0; x < rateNowContainer.getChildCount(); x++) {
            ImageView starratingview = (ImageView) rateNowContainer.getChildAt(x);
            starratingview.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));

            if (x <= starposition) {
                starratingview.setImageTintList(ColorStateList.valueOf(Color.parseColor("#EFC90A")));
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (R.id.search == id) {////

            return true;

        } else if (android.R.id.home == id) {////

            finish();
            return true;

        } else if (R.id.menu_cart == id) {////

            Intent intent = new Intent(ProductsDetailsActivity.this, MainActivity.class);
            showCart = true;
            startActivity(intent);

            return true;
        }


        return super.onOptionsItemSelected(item);


    }
}