package com.example.bryon.wishbonecaninerescue.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bryon on 8/9/16.
 */
public class Photo {
    public String id;
    public String size;
    @SerializedName("__content__")
    public String content;

    public Photo(){}
}
