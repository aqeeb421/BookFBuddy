package com.example.bookfbuddy;

public class ImageUpload
{
    public String name;
    public String url;

    public String getName(){
        return name;
    }

    public String getUrl(){
        return url;
    }

    public ImageUpload(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
