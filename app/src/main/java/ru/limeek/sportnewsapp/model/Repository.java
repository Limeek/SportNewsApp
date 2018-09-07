package ru.limeek.sportnewsapp.model;

import ru.limeek.sportnewsapp.api.Api;

public class Repository{
    private Api api;

    public Repository(Api api){
        this.api = api;
    }

    public Api getApi() {
        return api;
    }
}
