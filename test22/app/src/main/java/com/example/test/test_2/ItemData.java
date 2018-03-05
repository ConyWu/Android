package com.example.test.test_2;

/**
 * Created by fengjen on 2018/2/8.
 */

public class ItemData {
    private String title;
    private String imageUrl;

    public ItemData(String title,String imageUrl){

        this.title = title;
        this.imageUrl = imageUrl;

    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
