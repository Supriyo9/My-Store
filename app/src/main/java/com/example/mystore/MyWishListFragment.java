package com.example.mystore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MyWishListFragment extends Fragment {



    public MyWishListFragment() {
        // Required empty public constructor
    }

   private RecyclerView wishListrecycleview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_wish_list, container, false);

        wishListrecycleview=view.findViewById(R.id.mywishlistrecycleview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishListrecycleview.setLayoutManager(linearLayoutManager);

        List<WishListModel> wishListModelList=new ArrayList<>();

        wishListModelList.add(new WishListModel(R.drawable.ic_menu_camera,"Nikon",1,"3",124,"Rs.49999/-","Rs.4999/-","Cash On Delivery"));
        wishListModelList.add(new WishListModel(R.drawable.ic_menu_camera,"Nikon",0,"3",124,"Rs.49999/-","Rs.4999/-","Cash On Delivery"));
        wishListModelList.add(new WishListModel(R.drawable.ic_menu_camera,"Nikon",1,"3",124,"Rs.49999/-","Rs.4999/-","Cash On Delivery"));
        wishListModelList.add(new WishListModel(R.drawable.ic_menu_camera,"Nikon",5,"3",124,"Rs.49999/-","Rs.4999/-","Cash On Delivery"));
        wishListModelList.add(new WishListModel(R.drawable.ic_menu_camera,"Nikon",0,"3",124,"Rs.49999/-","Rs.4999/-","Cash On Delivery"));
        wishListModelList.add(new WishListModel(R.drawable.ic_menu_camera,"Nikon",3,"3",124,"Rs.49999/-","Rs.4999/-","Cash On Delivery"));


        WishListAdapater wishListAdapater=new WishListAdapater(wishListModelList,true);
        wishListrecycleview.setAdapter(wishListAdapater);
        wishListAdapater.notifyDataSetChanged();
        return view;
    }
}