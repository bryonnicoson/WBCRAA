package com.example.bryon.wishbonecaninerescue.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bryon on 8/9/16.
 */
public class Petfinder {

    @SerializedName("xmlns:xsi")
    private String xmlnsXsi;

    @SerializedName("xsi:noNamespaceSchemaLocation")
    private String xsiNoNamespaceSchemaLocation;

    private Header header;

    private String lastOffset;

    public Pets pets;

    public Petfinder() {}
}
