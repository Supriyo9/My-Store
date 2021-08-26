package com.example.mystore;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    List<MyOrderItemModel> myOrderItemModelList;

    public MyOrderAdapter(List<MyOrderItemModel> myOrderItemModelList) {
        this.myOrderItemModelList = myOrderItemModelList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_item_order_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {

        int resoource=myOrderItemModelList.get(position).getProductImage();
        int rating=myOrderItemModelList.get(position).getRating();
        String title=myOrderItemModelList.get(position).getProductTitle();
        String deliverystatus=myOrderItemModelList.get(position).getDeliveryStatus();

        holder.setData(resoource,title,deliverystatus,rating);

    }

    @Override
    public int getItemCount() {
        return myOrderItemModelList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView productImage;
        private ImageView deliveryIndicator;
        private TextView productTitle;
        private  TextView DeliverStatus;
        private LinearLayout rateNowContainer;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            productImage=itemView.findViewById(R.id.product_image_order);
            deliveryIndicator=itemView.findViewById(R.id.order_status_indicator);
            productTitle=itemView.findViewById(R.id.product_title_order);
            DeliverStatus=itemView.findViewById(R.id.order_delivered_date);
            rateNowContainer=itemView.findViewById(R.id.rate_now_container);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(),MyOrderDetailActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }

        private void setData(int resource,String title,String deliveryDate,int rating)
        {
            productImage.setImageResource(resource);
            productTitle.setText(title);

            if(deliveryDate.equals("Cancelled")) {

                deliveryIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorRed)));

            }
            else
            {
                deliveryIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.successGreen)));
            }
            DeliverStatus.setText(deliveryDate);


            //////////////////////////////rating layout

            setRating(rating);


            for(int x=0;x<rateNowContainer.getChildCount();x++)
            {
                final int starposition=x;
                rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setRating(starposition);
                    }
                });




            }
            //////////////////////////////rating layout
        }
        private void setRating(int starposition) {

            for(int x=0;x<rateNowContainer.getChildCount();x++)
            {
                ImageView starratingview=(ImageView) rateNowContainer.getChildAt(x);
                starratingview.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));

                if(x<=starposition)
                {
                    starratingview.setImageTintList(ColorStateList.valueOf(Color.parseColor("#EFC90A")));
                }

            }
        }
    }
}
