package com.example.mystore;

import java.util.List;

public class HomePageModel {

    public static final int BANNER_SLIDER = 0;

    public static final int STRIP_BANNER = 1;

    public static final int HORIZONTAL_PRODUCT_VIEW = 2;

    public static final int GRID_PRODUCT_VIEW = 3;


    private int type;

    private String backgroundcolor;

    ///////////////////////////banerrrrr sliderrrr
    private List<SliderModel> sliderModelList;

    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }

    ///////////////////////////banerrrrr sliderrrr


    ////////////////////////////strip add


    private String resource;


    public HomePageModel(int type, String resource, String backgroundcolor) {
        this.type = type;
        this.resource = resource;
        this.backgroundcolor = backgroundcolor;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    ////////////////////////////strip add

    ////////////////////////////HORIZONTAL PRODUCT && grid product
    private String title;
    private List<HorizontalProductModel> horizontalProductModelList;


    public HomePageModel(int type, String title,String backgroundcolor, List<HorizontalProductModel> horizontalProductModelList) {
        this.type = type;
        this.title = title;
        this.backgroundcolor=backgroundcolor;
        this.horizontalProductModelList = horizontalProductModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalProductModel> getHorizontalProductModelList() {
        return horizontalProductModelList;
    }

    public void setHorizontalProductModelList(List<HorizontalProductModel> horizontalProductModelList) {
        this.horizontalProductModelList = horizontalProductModelList;
    }


    ////////////////////////////HORIZONTAL PRODUCT && grid product

    ////////////////////////////grid product


    ////////////////////////////grid product


}
