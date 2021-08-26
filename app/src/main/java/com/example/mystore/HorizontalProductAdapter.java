package com.example.mystore;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class HorizontalProductAdapter extends RecyclerView.Adapter<HorizontalProductAdapter.ViewHolder> {

    private List<HorizontalProductModel> horizontalProductModelList;

    public HorizontalProductAdapter(List<HorizontalProductModel> horizontalProductModelList) {
        this.horizontalProductModelList = horizontalProductModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scrolllayout_recycle_item, viewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String resource = horizontalProductModelList.get(position).getProductimage();
        String title = horizontalProductModelList.get(position).getProducttitle();
        String description = horizontalProductModelList.get(position).getProductDescription();
        String price = horizontalProductModelList.get(position).getProductprice();
        holder.setProductiamge(resource);
        holder.setProductprice(price);
        holder.setProductTitle(title);
        holder.setProductDescription(description);


    }

    @Override
    public int getItemCount() {
        if (horizontalProductModelList.size() > 8) {
            return 8;
        } else {
            return horizontalProductModelList.size();

        }


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productiamge;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productprice;

        public ViewHolder(@NonNull final View itemView) {

            super(itemView);
            productiamge = itemView.findViewById(R.id.HS_product_image);
            productDescription = itemView.findViewById(R.id.HS_product_decription);
            productprice = itemView.findViewById(R.id.HS_product_price);
            productTitle = itemView.findViewById(R.id.HS_product_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProductsDetailsActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }

        private void setProductiamge(String resouce) {

            Glide.with(itemView.getContext()).load(resouce).apply(new RequestOptions().placeholder(R.drawable.ic_baseline_add_circle_outline_24))
                    .into(productiamge);
        }

        private void setProductTitle(String title) {
            productTitle.setText(title);
        }

        private void setProductDescription(String description) {
            productDescription.setText(description);
        }

        private void setProductprice(String price) {
            productprice.setText("Rs."+price+"/-");
        }
    }
}
