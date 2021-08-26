package com.example.mystore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import static com.example.mystore.DeliveryActivity.SELECT_ADDRESS;
import static com.example.mystore.MyAccountFragment.MANAGE_ADDRESS;
import static com.example.mystore.MyAddressesActivity.refreshitem;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    private List<AddressesModel> addressesModelList;

    private int MODE;

    private int preselectedposition = -1;

    public AddressesAdapter(List<AddressesModel> addressesModelList, int MODE) {
        this.addressesModelList = addressesModelList;
        this.MODE = MODE;
    }

    @NonNull
    @Override
    public AddressesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addresss_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressesAdapter.ViewHolder holder, int position) {
        String name = addressesModelList.get(position).getFullname();
        String address = addressesModelList.get(position).getAddress();
        String pincode = addressesModelList.get(position).getPincode();
        boolean selectedd = addressesModelList.get(position).getSelectedd();

        holder.setData(name, address, pincode, selectedd, position);


    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView fullname;
        private TextView addresss;
        private TextView pincode;
        private ImageView iconChecked;
        private LinearLayout optioncontainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fullname = itemView.findViewById(R.id.name_additemlayout);
            addresss = itemView.findViewById(R.id.address_additemlayout);
            pincode = itemView.findViewById(R.id.pincode_additemlayout);
            iconChecked = itemView.findViewById(R.id.icon_view);
            optioncontainer = itemView.findViewById(R.id.option_container);
        }


        private void setData(String username, String useraddress, String userpincode, final boolean selectedd, final int position) {
            fullname.setText(username);
            addresss.setText(useraddress);
            pincode.setText(userpincode);

            if (MODE == SELECT_ADDRESS) {
                iconChecked.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);
                if (selectedd) {
                    iconChecked.setVisibility(View.VISIBLE);
                    preselectedposition = position;
                } else {
                    iconChecked.setVisibility(View.GONE);
                }


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (preselectedposition != position) {

                            addressesModelList.get(position).setSelectedd(true);
                            addressesModelList.get(preselectedposition).setSelectedd(false);
                            refreshitem(preselectedposition, position);
                            preselectedposition = position;
                        }

                    }
                });
            } else if (MODE == MANAGE_ADDRESS) {
                optioncontainer.setVisibility(View.GONE);
                iconChecked.setImageResource(R.drawable.ic_baseline_more_vert_24);
                iconChecked.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        optioncontainer.setVisibility(View.VISIBLE);
                        refreshitem(preselectedposition, preselectedposition);
                        preselectedposition = position;

                    }
                });

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshitem(preselectedposition, preselectedposition);
                        preselectedposition = -1;

                    }
                });

            }
        }
    }
}
