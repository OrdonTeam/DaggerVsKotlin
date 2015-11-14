package com.ordonteam.daggervskotlin;

public class SearchResult {

    public final String login;
    public final String avatar_url;
    public final double score;

    public SearchResult(String login, String avatar_url, double score) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.score = score;
    }
}
