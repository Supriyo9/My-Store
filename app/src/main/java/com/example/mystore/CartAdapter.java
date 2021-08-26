package com.example.mystore;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.mystore.RegisterActivity.setsignupfragment;

public class CartAdapter extends RecyclerView.Adapter {

    private List<CartItemModel> cartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()) {
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            case CartItemModel.CART_ITEM:

                View cartitemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout, viewGroup, false);
                return new cartItemViewHolder(cartitemview);

            case CartItemModel.TOTAL_AMOUNT:

                View carttotalview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout, viewGroup, false);
                return new cartTotalAmountViewHolder(carttotalview);

            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (cartItemModelList.get(position).getType()) {
            case CartItemModel.CART_ITEM:

                int resource = cartItemModelList.get(position).getProductImage();
                String title = cartItemModelList.get(position).getProdctTitle();
                int freecoupan = cartItemModelList.get(position).getFreeCopan();
                String prodcutPrice = cartItemModelList.get(position).getProductPrice();
                String cutPrice = cartItemModelList.get(position).getCutPrice();
                int offerapplied = cartItemModelList.get(position).getCoupanApplied();


                ((cartItemViewHolder) holder).setItemDetails(resource, title, freecoupan, prodcutPrice, cutPrice, offerapplied);


                break;
            case CartItemModel.TOTAL_AMOUNT:

                String totalItems = cartItemModelList.get(position).getToatalItem();
                String totalItemprice = cartItemModelList.get(position).getTotalItemPrice();
                String deliveyprice = cartItemModelList.get(position).getDeliveryPrice();
                String totalAmount = cartItemModelList.get(position).getTotalAmount();
                String savedAmount = cartItemModelList.get(position).getSavedAmount();

                ((cartTotalAmountViewHolder) holder).setTotalAmount(totalItems, totalItemprice, deliveyprice, totalAmount, savedAmount);
                break;
            default:
                return;

        }

    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    class cartItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private ImageView freecoupanIcon;
        private TextView produvtTitle;
        private TextView freeCoupans;
        private TextView productPrice;
        private TextView cutPrice;
        private TextView offerApplies;
        private TextView coupansApplied;
        private TextView productQuantity;


        public cartItemViewHolder(@NonNull View itemView) {
            super(itemView);

            freecoupanIcon = itemView.findViewById(R.id.free_coupan_icon_cart);
            productImage = itemView.findViewById(R.id.product_image_cart);
            productPrice = itemView.findViewById(R.id.product_price_cart);
            produvtTitle = itemView.findViewById(R.id.product_title_cart);
            cutPrice = itemView.findViewById(R.id.cut_price_cart);
            productQuantity = itemView.findViewById(R.id.quantity_cart);
            offerApplies = itemView.findViewById(R.id.offers_applied_cart);
            coupansApplied = itemView.findViewById(R.id.coupan_applied_cart);
            freeCoupans = itemView.findViewById(R.id.tv_free_coupan_cart);

        }


        private void setItemDetails(int resource, String title, int freeCoupansNo, String productPriceText, String cutPricetext, int offersAppliedNo) {
            productImage.setImageResource(resource);
            produvtTitle.setText(title);
            if (freeCoupansNo > 0) {

                freecoupanIcon.setVisibility(View.VISIBLE);
                freeCoupans.setVisibility(View.VISIBLE);

                if (freeCoupansNo == 1) {
                    freeCoupans.setText("free " + freeCoupansNo + " coupan");
                } else {
                    freeCoupans.setText("free " + freeCoupansNo + " coupans");
                }


            } else {
                freecoupanIcon.setVisibility(View.INVISIBLE);
                freeCoupans.setVisibility(View.INVISIBLE);

            }

            productPrice.setText(productPriceText);
            cutPrice.setText(cutPricetext);
            if (offersAppliedNo > 0) {
                offerApplies.setVisibility(View.VISIBLE);
                offerApplies.setText(offersAppliedNo + " offers applied");

            } else {
                offerApplies.setVisibility(View.INVISIBLE);
            }

            productQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog quantitydialog=new Dialog(itemView.getContext());
                    quantitydialog.setContentView(R.layout.quantity_dialog);
                    quantitydialog.setCancelable(false);
                    quantitydialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    Button dialogcancelbutton=quantitydialog.findViewById(R.id.cancelbutton);
                    Button dialogokbutton2=quantitydialog.findViewById(R.id.okbutton2);
                    final EditText productQuantityno=quantitydialog.findViewById(R.id.quantity_no);



                    dialogcancelbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            quantitydialog.dismiss();

                        }
                    });

                    dialogokbutton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            productQuantity.setText("Qty: "+productQuantityno.getText());
                            quantitydialog.dismiss();
                        }
                    });

                    quantitydialog.show();
                }
            });


        }
    }

    class cartTotalAmountViewHolder extends RecyclerView.ViewHolder {

        private TextView totalItem;
        private TextView totalItemPrice;
        private TextView deliveryPrice;
        private TextView toatlAmount;
        private TextView savedAmount;


        public cartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);

            totalItem = itemView.findViewById(R.id.total_items_cart);
            totalItemPrice = itemView.findViewById(R.id.total_item_price_cart);
            deliveryPrice = itemView.findViewById(R.id.delivery_charge);
            toatlAmount = itemView.findViewById(R.id.total_price_cart_price);
            savedAmount = itemView.findViewById(R.id.saved_amount_cart);
        }


        private void setTotalAmount(String totalItemtext, String totalItemPriceText, String delivryPriceText, String totalAmountTex, String savedAmontTex) {
            toatlAmount.setText(totalAmountTex);
            totalItemPrice.setText(totalItemPriceText);
            totalItem.setText(totalItemtext);
            deliveryPrice.setText(delivryPriceText);
            savedAmount.setText(savedAmontTex);
        }
    }
}
