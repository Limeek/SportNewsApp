package ru.limeek.sportnewsapp.newsdetails.viewmodel;

import android.support.annotation.Nullable;

import ru.limeek.sportnewsapp.model.NewsDetails;

public class NewsDetailsResponse {
    @Nullable
    private NewsDetails newsDetails;
    @Nullable
    private Throwable throwable;

    private NewsDetailsResponse(@Nullable NewsDetails newsDetails, @Nullable Throwable throwable){
        this.newsDetails = newsDetails;
        this.throwable = throwable;
    }

    public static NewsDetailsResponse success(NewsDetails newsDetails){
        return new NewsDetailsResponse(newsDetails, null);
    }

    public static NewsDetailsResponse error(Throwable e){
        return new NewsDetailsResponse(null, e);
    }

    @Nullable
    public NewsDetails getNewsDetails(){return newsDetails;}


    @Nullable
    public Throwable getThrowable() {
        return throwable;
    }
}
