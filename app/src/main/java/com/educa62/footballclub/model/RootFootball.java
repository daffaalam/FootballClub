package com.educa62.footballclub.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RootFootball {

    @SerializedName("teams")
    private List<TeamsItem> teams;

    @SerializedName("count")
    private int count;

    @SerializedName("filters")
    private Filters filters;

    public void setTeams(List<TeamsItem> teams) {
        this.teams = teams;
    }

    public List<TeamsItem> getTeams() {
        return teams;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public Filters getFilters() {
        return filters;
    }
}