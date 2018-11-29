package com.educa62.footballclub.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Filters {

    @SerializedName("areas")
    private List<Integer> areas;

    @SerializedName("permission")
    private String permission;

    public void setAreas(List<Integer> areas) {
        this.areas = areas;
    }

    public List<Integer> getAreas() {
        return areas;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}