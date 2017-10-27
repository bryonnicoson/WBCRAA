package com.example.bryon.wishbonecaninerescue.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by bryon on 8/9/16.
 */
public class Breeds {

    @SerializedName("breed")
    public List<String> breed = new ArrayList<String>();

    public Breeds(){}

    @Override
    public String toString() {
        String s = "";
        for (String b : breed)
            s += b + " ";
        return s;
    }
}
