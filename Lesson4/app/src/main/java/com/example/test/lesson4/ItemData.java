package com.example.test.lesson4;

/**
 * Created by fengjen on 2018/2/8.
 */

public class ItemData {
    private String title;
    private String description;

    public ItemData(String title,String description){

        this.title = title;
        this.description = description;
        //this.imageUrl = imageUrl;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public String getImageUrl() {
        return imageUrl;
    }*/

    /*public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }*/
}
