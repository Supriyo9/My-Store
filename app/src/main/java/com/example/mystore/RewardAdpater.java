package com.example.mystore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RewardAdpater extends RecyclerView.Adapter<RewardAdpater.ViewHolder> {

    private List<RewardModel> rewardModelList;
    private Boolean useminiLayout = false;

    public RewardAdpater(List<RewardModel> rewardModelList, boolean useminiLayout) {
        this.rewardModelList = rewardModelList;
        this.useminiLayout = useminiLayout;
    }

    @NonNull
    @Override
    public RewardAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view;
        if (useminiLayout) {
             view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mini_rewads_item_layout, viewGroup, false);
        } else {
             view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rewadrs_item_layout, viewGroup, false);
        }


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardAdpater.ViewHolder holder, int position) {

        String title = rewardModelList.get(position).getTitle();
        String expirey = rewardModelList.get(position).getExpierydate();
        String copanbody = rewardModelList.get(position).getCuupanbody();

        holder.setData(title, expirey, copanbody);

    }

    @Override
    public int getItemCount() {
        return rewardModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView coupantitle;
        private TextView coupanexpireydate;
        private TextView coupanBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coupantitle = itemView.findViewById(R.id.coupan_title_reward);
            coupanexpireydate = itemView.findViewById(R.id.coupan_validity_rewad);
            coupanBody = itemView.findViewById(R.id.coupan_body_rewad);
        }

        private void setData(final String title, final String coupanexpireydatetext, final String coupanBodytext) {
            coupantitle.setText(title);
            coupanBody.setText(coupanBodytext);
            coupanexpireydate.setText(coupanexpireydatetext);


            if(useminiLayout)
            {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ProductsDetailsActivity.coupantitle.setText(title);
                        ProductsDetailsActivity.coupanbody.setText(coupanBodytext);
                        ProductsDetailsActivity.coupanexpiraydate.setText(coupanexpireydatetext);
                        ProductsDetailsActivity.togglerecyclerview();
                    }
                });
            }
        }
    }
}
