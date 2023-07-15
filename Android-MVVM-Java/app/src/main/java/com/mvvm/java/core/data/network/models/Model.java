package com.mvvm.java.core.data.network.models;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("name")
    private String model;

    public String getModel() {
        return model;
    }
}
