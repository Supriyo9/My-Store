package com.example.mystore;

public class CartItemModel {

    public static final int CART_ITEM = 0;

    public static final int TOTAL_AMOUNT = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //////////////////cart item
 private int productImage;
    private String prodctTitle;
    private int FreeCopan;
    private String productPrice;
    private String cutPrice;
    private int productQuantity;
    private int offerApplied;
    private int coupanApplied;






    public CartItemModel(int type, int productImage, String prodctTitle, int freeCopan, String productPrice, String cutPrice, int productQuantity, int offerApplied, int coupanApplied) {
        this.type = type;
        this.productImage = productImage;
        this.prodctTitle = prodctTitle;
        FreeCopan = freeCopan;
        this.productPrice = productPrice;
        this.cutPrice = cutPrice;
        this.productQuantity = productQuantity;
        this.offerApplied = offerApplied;
        this.coupanApplied = coupanApplied;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProdctTitle() {
        return prodctTitle;
    }

    public void setProdctTitle(String prodctTitle) {
        this.prodctTitle = prodctTitle;
    }

    public int getFreeCopan() {
        return FreeCopan;
    }

    public void setFreeCopan(int freeCopan) {
        FreeCopan = freeCopan;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCutPrice() {
        return cutPrice;
    }

    public void setCutPrice(String cutPrice) {
        this.cutPrice = cutPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getOfferApplied() {
        return offerApplied;
    }

    public void setOfferApplied(int offerApplied) {
        this.offerApplied = offerApplied;
    }

    public int getCoupanApplied() {
        return coupanApplied;
    }

    public void setCoupanApplied(int coupanApplied) {
        this.coupanApplied = coupanApplied;
    }


//////////////////cart item

    ///////////////////////////cart total
    private  String toatalItem;
    private  String  totalItemPrice;
    private  String deliveryPrice;

    private String totalAmount;
    private String savedAmount;

    public CartItemModel(int type, String toatalItem, String totalItemPrice, String deliveryPrice, String totalAmount, String savedAmount) {
        this.type = type;
        this.toatalItem = toatalItem;
        this.totalItemPrice = totalItemPrice;
        this.deliveryPrice = deliveryPrice;
        this.savedAmount = savedAmount;
        this.totalAmount = totalAmount;
    }

    public String getToatalItem() {
        return toatalItem;
    }

    public void setToatalItem(String toatalItem) {
        this.toatalItem = toatalItem;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public String getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(String savedAmount) {
        this.savedAmount = savedAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    ///////////////////////////cart total

}
