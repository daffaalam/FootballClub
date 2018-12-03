package com.educa62.footballclub.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootFootball {

    @SerializedName("teams")
    private List<TeamsItem> teams;

    public void setTeams(List<TeamsItem> teams) {
        this.teams = teams;
    }

    public List<TeamsItem> getTeams() {
        return teams;
    }
}