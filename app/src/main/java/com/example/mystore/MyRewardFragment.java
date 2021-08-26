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


public class MyRewardFragment extends Fragment {

    public MyRewardFragment() {
        // Required empty public constructor
    }

    private RecyclerView rewardrecycleview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_my_reward, container, false);

       rewardrecycleview=view.findViewById(R.id.myrewadrsrecycleview);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardrecycleview.setLayoutManager(linearLayoutManager);

        List<RewardModel> rewardModelList =new ArrayList<>();

        rewardModelList.add(new RewardModel("CashBack","Till 2020","Get 20% Discount By Using This On each Product"));
        rewardModelList.add(new RewardModel("CashBack","Till 2020","Get 20% Discount By Using This On each Product"));
        rewardModelList.add(new RewardModel("Buy one Get One Free","Till 2020","Get 20% Discount By Using This On each Product"));
        rewardModelList.add(new RewardModel("CashBack","Till 2020","Get 20% Discount By Using This On each Product"));

        RewardAdpater rewardAdpater=new RewardAdpater(rewardModelList,false);
        rewardrecycleview.setAdapter(rewardAdpater);
        rewardAdpater.notifyDataSetChanged();

        return view;
    }
}