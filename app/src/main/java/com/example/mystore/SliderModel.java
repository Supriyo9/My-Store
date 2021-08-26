package com.example.mystore;

public class SliderModel {

    private String banner;
    private  String bgcolor;

    public SliderModel(String banner, String bgcolor) {
        this.banner = banner;
        this.bgcolor = bgcolor;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }
}
