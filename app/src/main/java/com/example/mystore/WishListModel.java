package com.example.mystore;

public class WishListModel {

    private  int productImage;
    private String productTile;
    private  int freeCoupan;
    private  String rating;
    private  int totalRatings;
    private  String productPrice;
    private String productCutPrice;
    private  String  paymentMethod;

    public WishListModel(int productImage, String productTile, int freeCoupan, String rating, int totalRatings, String productPrice, String productCutPrice, String paymentMethod) {
        this.productImage = productImage;
        this.productTile = productTile;
        this.freeCoupan = freeCoupan;
        this.rating = rating;
        this.totalRatings = totalRatings;
        this.productPrice = productPrice;
        this.productCutPrice = productCutPrice;
        this.paymentMethod = paymentMethod;
    }


    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTile() {
        return productTile;
    }

    public void setProductTile(String productTile) {
        this.productTile = productTile;
    }

    public int getFreeCoupan() {
        return freeCoupan;
    }

    public void setFreeCoupan(int freeCoupan) {
        this.freeCoupan = freeCoupan;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCutPrice() {
        return productCutPrice;
    }

    public void setProductCutPrice(String productCutPrice) {
        this.productCutPrice = productCutPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
