package com.example.mystore;

public class HorizontalProductModel {

    private  String productID;
    private String productimage;
    private String producttitle;
    private String productDescription;
    private String productprice;

    public HorizontalProductModel(String productID,String productimage, String producttitle, String productDescription, String productprice) {
        this.productID=productID;
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.productDescription = productDescription;
        this.productprice = productprice;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
