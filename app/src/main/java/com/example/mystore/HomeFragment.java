package com.example.mystore;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryrecyclerView, mainrecycle;
    private CategoryAdapter categoryAdapter;
    private List<CategoryModel> categoryModels;
    private FirebaseFirestore firebaseFirestore;
    private HomePageAdapter homePageAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryrecyclerView = view.findViewById(R.id.category_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        categoryrecyclerView.setLayoutManager(linearLayoutManager);


        categoryModels = new ArrayList<CategoryModel>();

        categoryAdapter = new CategoryAdapter(categoryModels);
        categoryrecyclerView.setAdapter(categoryAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("Index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshots : task.getResult()) {
                                categoryModels.add(new CategoryModel(documentSnapshots.get("Icon").toString(), documentSnapshots.get("categoryName").toString()));
                            }

                            categoryAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        /*categoryModels.add(new CategoryModel("link", "home"));
        categoryModels.add(new CategoryModel("link", "ele"));
        categoryModels.add(new CategoryModel("link", "fur"));
        categoryModels.add(new CategoryModel("link", "fas"));
        categoryModels.add(new CategoryModel("link", "home"));
        categoryModels.add(new CategoryModel("link", "ele"));
        categoryModels.add(new CategoryModel("link", "fur"));
        categoryModels.add(new CategoryModel("link", "fas"));

         */


        ////////////////////////////banner


        ////////  List<SliderModel> sliderModelList = new ArrayList<SliderModel>();


        /*sliderModelList.add(new SliderModel(R.drawable.ic_baseline_shopping_cart_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_favorite_24, "#077AE4"));

         */

      /*  sliderModelList.add(new SliderModel(R.drawable.ic_baseline_favorite_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_local_mall_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_add_circle_outline_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_notifications_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_shopping_cart_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_add_circle_outline_24, "#077AE4"));



       */
     /*   sliderModelList.add(new SliderModel(R.drawable.chatt, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_local_mall_24, "#077AE4"));

      */


        //////////////// bannerrrrrrrrr adddddd


        //////////////////////////////////////////horizontalproduct


       /* List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
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

        //////////////////////////////////////////horizontalproduct


        ////////////////////////////////////////////////////

        mainrecycle = view.findViewById(R.id.mainherorecyle);
        LinearLayoutManager testinglinearLayoutManager = new LinearLayoutManager(getContext());
        testinglinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mainrecycle.setLayoutManager(testinglinearLayoutManager);
        final List<HomePageModel> homePageModelList = new ArrayList<>();
       /* homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.ic_baseline_account_circle_24, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Deals of the day", horizontalProductModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of the day", horizontalProductModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of the day", horizontalProductModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.ic_baseline_account_circle_24, "#000000"));
        homePageModelList.add(new HomePageModel(3, "Deals of the day", horizontalProductModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.ic_baseline_account_circle_24, "#000000"));


        */
        homePageAdapter = new HomePageAdapter(homePageModelList);
        mainrecycle.setAdapter(homePageAdapter);


        firebaseFirestore.collection("CATEGORIES").document("HOME")
                .collection("TOP_DEALS").orderBy("Index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshots : task.getResult()) {

                                if ((long) documentSnapshots.get("view_type") == 0) {
                                    List<SliderModel> sliderModelList = new ArrayList<>();
                                    long no_of_banners = (long) documentSnapshots.get("no_of_banners");
                                    for (long x = 1; x < no_of_banners + 1; x++) {
                                        sliderModelList.add(new SliderModel(documentSnapshots.get("banner_" + x).toString()
                                                , documentSnapshots.get("banner_" + x + "_background").toString()));
                                    }
                                    homePageModelList.add(new HomePageModel(0, sliderModelList));


                                } else if ((long) documentSnapshots.get("view_type") == 1) {
                                    homePageModelList.add(new HomePageModel(1, documentSnapshots
                                            .get("strip_ad_banner").toString(), documentSnapshots
                                            .get("background").toString()));
                                } else if ((long) documentSnapshots.get("view_type") == 2) {
                                    List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
                                    long no_of_products = (long) documentSnapshots.get("no_of_products");
                                    for (long x = 1; x < no_of_products + 1; x++) {
                                        horizontalProductModelList.add(new HorizontalProductModel(documentSnapshots.get("product_ID_" + x).toString()
                                                , documentSnapshots.get("product_image_" + x).toString(),
                                                documentSnapshots.get("product_title_" + x).toString(),
                                                documentSnapshots.get("product_subtitle_" + x).toString(),
                                                documentSnapshots.get("product_price_" + x).toString()));
                                    }
                                    homePageModelList.add(new HomePageModel(2, documentSnapshots.get("layout_title").toString(), documentSnapshots.get("layout_background").toString(),horizontalProductModelList));


                                } else if ((long) documentSnapshots.get("view_type") == 3) {

                                }

                            }

                            homePageAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });


        ////////////////////////////////////////////////////
        return view;
    }


}