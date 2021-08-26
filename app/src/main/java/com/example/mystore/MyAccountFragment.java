package com.example.mystore;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MyAccountFragment extends Fragment {

    public  static final int MANAGE_ADDRESS=1;
    public MyAccountFragment() {
        // Required empty public constructor
    }

    private Button viewAlladd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_account, container, false);
        viewAlladd=view.findViewById(R.id.view_all_address_btn);

        viewAlladd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MyAddressesActivity.class);
                intent.putExtra("MODE",MANAGE_ADDRESS);
                startActivity(intent);
            }
        });
        return view;
    }
}