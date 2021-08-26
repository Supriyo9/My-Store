package com.example.mystore;

public class AddressesModel {
    private  String fullname;
    private  String address;
    private  String pincode;
    private boolean selectedd;

    public AddressesModel(String fullname, String address, String pincode,boolean selectedd) {
        this.fullname = fullname;
        this.address = address;
        this.pincode = pincode;
        this.selectedd = selectedd;
    }


    public boolean getSelectedd() {
        return selectedd;
    }

    public void setSelectedd(boolean selectedd) {
        this.selectedd = selectedd;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
