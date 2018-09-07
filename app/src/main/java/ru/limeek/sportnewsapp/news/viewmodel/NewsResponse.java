package ru.limeek.sportnewsapp.news.viewmodel;

import android.support.annotation.Nullable;

import ru.limeek.sportnewsapp.model.News;

public class NewsResponse {
    @Nullable
    private News news;
    @Nullable
    private Throwable error;

    private NewsResponse(@Nullable News news, @Nullable Throwable error){
        this.news = news;
        this.error = error;
    }


    public static NewsResponse success(News news){
        return new NewsResponse(news, null);
    }

    public static NewsResponse error(Throwable error){
        return new NewsResponse(null, error);
    }

    @Nullable
    public News getNews() {
        return news;
    }

    @Nullable
    public Throwable getError() {
        return error;
    }
}
