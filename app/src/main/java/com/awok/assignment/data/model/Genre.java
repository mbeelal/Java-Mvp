package com.awok.assignment.data.model;

import com.google.gson.annotations.SerializedName;

public class Genre {

    @SerializedName("name")
    String name;

    public String getName() {
        return name;
    }
}
