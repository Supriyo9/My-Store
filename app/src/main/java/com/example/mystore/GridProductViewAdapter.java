package com.example.mystore;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridProductViewAdapter extends BaseAdapter {

    List<HorizontalProductModel> horizontalProductModelList;

    public GridProductViewAdapter(List<HorizontalProductModel> horizontalProductModelList) {
        this.horizontalProductModelList = horizontalProductModelList;
    }

    @Override
    public int getCount() {
        return horizontalProductModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        final View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scrolllayout_recycle_item, null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(view.getContext(), ProductsDetailsActivity.class);

                    parent.getContext().startActivity(intent);
                }
            });


            ImageView productiamge = view.findViewById(R.id.HS_product_image);
            TextView productDescription = view.findViewById(R.id.HS_product_decription);
            TextView productprice = view.findViewById(R.id.HS_product_price);
            TextView productTitle = view.findViewById(R.id.HS_product_title);


          /////  productiamge.setImageResource(horizontalProductModelList.get(position).getProductimage());
            productprice.setText(horizontalProductModelList.get(position).getProductprice());
            productTitle.setText(horizontalProductModelList.get(position).getProducttitle());
            productDescription.setText(horizontalProductModelList.get(position).getProductDescription());

        } else {

            view = convertView;

        }
        return view;

    }
}
