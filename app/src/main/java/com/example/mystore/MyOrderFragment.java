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


public class MyOrderFragment extends Fragment {


    public MyOrderFragment() {
        // Required empty public constructor
    }

   private RecyclerView myorderrecycleveiw;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_order, container, false);

        myorderrecycleveiw=view.findViewById(R.id.my_order_recyclerview);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myorderrecycleveiw.setLayoutManager(linearLayoutManager);

        List<MyOrderItemModel> myOrderItemModelList=new ArrayList<>();

        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.ic_menu_camera,2,"Nikon","Delivered on Monday" +
                "15th Jan 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.ic_menu_camera,2,"Nikon","Delivered on Monday" +
                "15th Jan 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.ic_menu_camera,2,"Nikon","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.ic_menu_camera,2,"Nikon","Delivered on Monday" +
                "15th Jan 2020"));

        MyOrderAdapter myOrderAdapter=new MyOrderAdapter(myOrderItemModelList);
        myorderrecycleveiw.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();


        return view;
    }
}