package com.example.mystore;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.mystore.RegisterActivity.setsignupfragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    DrawerLayout drawer;

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    private FrameLayout frameLayout;
    private AppBarConfiguration mAppBarConfiguration;

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final int ORDER_FRAGMENT = 2;
    private static final int WISH_FRAGMENT = 3;
    private static final int REWARD_FRAGMENT = 4;
    private static final int ACCOUNT_FRAGMENT = 5;
    public static Boolean showCart = false;

    private Window window;

    private Toolbar toolbar;


    private  int currentFargmrnt = -1;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        drawer = findViewById(R.id.drawer_layout);


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);


        frameLayout = findViewById(R.id.container_fragment);

        if (showCart) {
            drawer.setDrawerLockMode(1);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            gotoFragment("My Cart", new MyCartFragment(), -2);
        } else {

            actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
            drawer.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
            actionBarDrawerToggle.syncState();

            setFragment(new HomeFragment(), HOME_FRAGMENT);
        }


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


       /* mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        */
    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (currentFargmrnt == HOME_FRAGMENT) {
                currentFargmrnt = -1;
                super.onBackPressed();

            } else {
                if (showCart) {
                    showCart = false;
                    finish();
                } else {
                    invalidateOptionsMenu();
                    setFragment(new HomeFragment(), HOME_FRAGMENT);
                }
            }

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        if (currentFargmrnt == HOME_FRAGMENT) {

            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getMenuInflater().inflate(R.menu.main, menu);

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (R.id.search == id) {////

            return true;

        } else if (R.id.notification == id) {////

            return true;

        } else if (R.id.menu_cart == id) {


            final Dialog signupdialog=new Dialog(MainActivity.this);
            signupdialog.setContentView(R.layout.signin_dialog);
            signupdialog.setCancelable(true);
            signupdialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            Button dialogsigninbtn=signupdialog.findViewById(R.id.signinbutton3);
            Button dialogsigUPbtn=signupdialog.findViewById(R.id.signupbutton4);

            final Intent registrintent=new Intent(MainActivity.this,RegisterActivity.class);


            dialogsigninbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signupdialog.dismiss();
                    setsignupfragment=false;
                    startActivity(registrintent);

                }
            });

            dialogsigUPbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signupdialog.dismiss();
                    setsignupfragment=true;
                    startActivity(registrintent);
                }
            });

            signupdialog.show();

        /////////////    gotoFragment("My Cart", new MyCartFragment(), CART_FRAGMENT);

            return true;
        } else if (android.R.id.home == id) {

            if(showCart)
            {
                showCart=false;
                finish();
                return true;
            }

        }


        return super.onOptionsItemSelected(item);


    }

    private void gotoFragment(String title, Fragment fragment, int FargmrntNo) {

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);

        invalidateOptionsMenu();//to remove tools of toolbar
        setFragment(fragment, FargmrntNo);
//////////////////////////////////////        navigationView.getMenu().getItem(3).setChecked(true);

    }

  /*  @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

   */


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        drawer.closeDrawer(GravityCompat.START);//to close drawer automatically

        if (menuItem.getItemId() == R.id.MyMall) {


            invalidateOptionsMenu();
            setFragment(new HomeFragment(), HOME_FRAGMENT);


        } else if (menuItem.getItemId() == R.id.Myorder) {


            gotoFragment("My Orders", new MyOrderFragment(), ORDER_FRAGMENT);

        }


        if (menuItem.getItemId() == R.id.giftcard) {
            gotoFragment("My Rewards", new MyRewardFragment(), REWARD_FRAGMENT);

        }
        if (menuItem.getItemId() == R.id.MyCart) {


            gotoFragment("My Cart", new MyCartFragment(), CART_FRAGMENT);

        }

        if (menuItem.getItemId() == R.id.MyWishlist) {
            gotoFragment("My WishList", new MyWishListFragment(), WISH_FRAGMENT);

        }
        if (menuItem.getItemId() == R.id.logout) {
            /*

            loadingDialog=new Dialog(MainActivity.this);
            loadingDialog.setContentView(R.layout.loading_progressbar);
            loadingDialog.setCancelable(false);
            loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            loadingDialog.show();


            FirebaseAuth.getInstance().signOut();

            loadingDialog.dismiss();
            Toast.makeText(MainActivity.this,"Logged Out succesfully",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();

             */
        }
        if (menuItem.getItemId() == R.id.MyAccount) {

            gotoFragment("My Account", new MyAccountFragment(), ACCOUNT_FRAGMENT);
        }


        return true;

    }

    private void setFragment(Fragment fragment, int fragementNo) {

        if (fragementNo != currentFargmrnt) {


            if (fragementNo == REWARD_FRAGMENT) {
                window.setStatusBarColor(Color.parseColor("#E4045F"));
                toolbar.setBackgroundColor(Color.parseColor("#E4045F"));
            } else {
                window.setStatusBarColor(Color.parseColor("#3700B3"));
                toolbar.setBackgroundColor(Color.parseColor("#3700B3"));
            }
            currentFargmrnt = fragementNo;

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);//R.id.container_fragment
            fragmentTransaction.commit();
        }
    }


}