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


public class ProductSpecificationFragment extends Fragment {



    public ProductSpecificationFragment() {
        // Required empty public constructor
    }

   private RecyclerView productSpecificationrecyleview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_specification, container, false);
        productSpecificationrecyleview=view.findViewById(R.id.product_specification_recycleview);


        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        productSpecificationrecyleview.setLayoutManager(linearLayoutManager);


        List<ProductSpecificationModel> specificationModelList=new ArrayList<>();
        specificationModelList.add(new ProductSpecificationModel(0,"General"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(0,"Display"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));
        specificationModelList.add(new ProductSpecificationModel(1,"Ram","12GB"));







        ProducSpecificationAdapter producSpecificationAdapter=new ProducSpecificationAdapter(specificationModelList);
        producSpecificationAdapter.notifyDataSetChanged();


        productSpecificationrecyleview.setAdapter(producSpecificationAdapter);


        return  view;
    }
}