package com.example.mystore;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {

    //////////////     29

    public MyCartFragment() {
        // Required empty public constructor l
    }

private RecyclerView cartItemRecycleview;

    private Button continueButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_my_cart, container, false);
        cartItemRecycleview=view.findViewById(R.id.cart_items_recycleviewer);
        continueButton=view.findViewById(R.id.cart_continue_btn);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemRecycleview.setLayoutManager(linearLayoutManager);

        List<CartItemModel> cartItemModelsList=new ArrayList<>();
        cartItemModelsList.add(new CartItemModel(0,R.drawable.ic_menu_camera,"Nikon",2,"Rs.4999/-","Rs.4999/-",1,0,0));
        cartItemModelsList.add(new CartItemModel(0,R.drawable.ic_menu_camera,"Nikon",0,"Rs.4999/-","Rs.4999/-",1,1,0));
        cartItemModelsList.add(new CartItemModel(0,R.drawable.ic_menu_camera,"Nikon",2,"Rs.4999/-","Rs.4999/-",1,2,0));

        cartItemModelsList.add(new CartItemModel(1,"Price(3)","Rs.170000/-","Free","Rs.170000/-","Rs.170000/-"));

        CartAdapter cartAdapter=new CartAdapter(cartItemModelsList);
        cartItemRecycleview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();


        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),AddressActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}