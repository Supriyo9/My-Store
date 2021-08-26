package com.example.mystore;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishListAdapater extends RecyclerView.Adapter<WishListAdapater.ViewHolder> {

    List<WishListModel> wishListModelList;
    private Boolean wishlist;

    public WishListAdapater(List<WishListModel> wishListModelList,Boolean wishlist) {
        this.wishListModelList = wishListModelList;
        this.wishlist=wishlist;
    }

    @NonNull
    @Override
    public WishListAdapater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishListAdapater.ViewHolder holder, int position) {


        int resource=wishListModelList.get(position).getProductImage();
        String title=wishListModelList.get(position).getProductTile();
        int freecoupan=wishListModelList.get(position).getFreeCoupan();
        String rating=wishListModelList.get(position).getRating();
        int totalrating=wishListModelList.get(position).getTotalRatings();
        String prodcutPrice=wishListModelList.get(position).getProductPrice();
        String cutPrice=wishListModelList.get(position).getProductCutPrice();
        String paymentmethod=wishListModelList.get(position).getPaymentMethod();

        holder.setData(resource,title,freecoupan,rating,totalrating,prodcutPrice,cutPrice,paymentmethod);

    }

    @Override
    public int getItemCount() {
        return wishListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView prductImage;
        private TextView productTitle;
        private  TextView productPrice;
        private ImageView freeCopanIcon;
        private TextView freeCoupans;
        private  TextView ratings;
        private TextView totalRatings;
        private  View priceCutter;
        private  TextView cutprice;
        private TextView paymentMethod;
        private ImageView delete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            prductImage=itemView.findViewById(R.id.product_image_wishlist);
            productTitle=itemView.findViewById(R.id.product_title_wishlist);
            productPrice=itemView.findViewById(R.id.product_price_wishlist);
            freeCopanIcon=itemView.findViewById(R.id.coupan_icon_wishlist);
            freeCoupans=itemView.findViewById(R.id.free_coupan_wishlist);
            totalRatings=itemView.findViewById(R.id.total_ratings_wishlist);
            cutprice=itemView.findViewById(R.id.cut_price_wishlist);
            priceCutter=itemView.findViewById(R.id.cut_divider_wishlist);
            paymentMethod=itemView.findViewById(R.id.payment_method_wishlist);
            delete=itemView.findViewById(R.id.delete_button_wishlist);
            ratings=itemView.findViewById(R.id.tv_product_rating_miniview);

        }


        private  void setData(int resource, String title, int freeCoupansNo, String averageRate, int totalRating, String price, String cutpricetext, String paymentMethodtext)
        {
            prductImage.setImageResource(resource);
            productTitle.setText(title);

            if(freeCoupansNo!=0)
            {

                freeCopanIcon.setVisibility(View.VISIBLE);

                if(freeCoupansNo==1){
                    freeCoupans.setText("free "+freeCoupansNo+" coupan");

                }
                else {
                    freeCoupans.setText("free "+freeCoupansNo+" coupans");
                }

            }
            else {
                freeCopanIcon.setVisibility(View.INVISIBLE);
                freeCoupans.setVisibility(View.INVISIBLE);

            }

            ratings.setText(averageRate);
            totalRatings.setText(totalRating+" ratings");
            productPrice.setText(price);
            cutprice.setText(cutpricetext);

            paymentMethod.setText(paymentMethodtext);

            if(wishlist)
            {
                delete.setVisibility(View.VISIBLE);
            }
            else
            {
                delete.setVisibility(View.INVISIBLE);
            }
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"Deleted Succesfully",Toast.LENGTH_SHORT).show();
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(),ProductsDetailsActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }
}
