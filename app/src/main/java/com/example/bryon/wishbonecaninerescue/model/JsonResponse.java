package com.example.bryon.wishbonecaninerescue.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bryon on 8/9/16.
 */

public class JsonResponse {

    @SerializedName("petfinder")
    public Petfinder petfinder;
    public JsonResponse(){}
}
