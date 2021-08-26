package com.example.mystore;

public class RewardModel {

    private  String title;
    private String expierydate;
    private String cuupanbody;


    public RewardModel(String title, String expierydate, String cuupanbody) {
        this.title = title;
        this.expierydate = expierydate;
        this.cuupanbody = cuupanbody;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpierydate() {
        return expierydate;
    }

    public void setExpierydate(String expierydate) {
        this.expierydate = expierydate;
    }

    public String getCuupanbody() {
        return cuupanbody;
    }

    public void setCuupanbody(String cuupanbody) {
        this.cuupanbody = cuupanbody;
    }
}
