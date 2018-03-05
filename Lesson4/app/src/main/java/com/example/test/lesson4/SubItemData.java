package com.example.test.lesson4;

/**
 * Created by fengjen on 2018/2/8.
 */

public class SubItemData {
    private int resource;
    private String fullRecipes;

    public SubItemData(int resource, String fullRecipes){

        this.resource = resource;
        this.fullRecipes = fullRecipes;

    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getFullRecipes() {
        return fullRecipes;
    }

    public void setFullRecipes(String fullRecipes) {
        this.fullRecipes = fullRecipes;
    }

}