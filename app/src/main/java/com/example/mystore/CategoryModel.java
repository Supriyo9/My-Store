package com.example.mystore;

public class CategoryModel {

    private  String linkicon;
    private  String categoryName;

    public CategoryModel(String linkicon, String categoryName) {
        this.linkicon = linkicon;
        this.categoryName = categoryName;
    }

    public String getLinkicon() {
        return linkicon;
    }

    public void setLinkicon(String linkicon) {
        this.linkicon = linkicon;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
