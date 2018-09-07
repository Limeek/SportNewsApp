package ru.limeek.sportnewsapp.api;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.limeek.sportnewsapp.model.News;
import ru.limeek.sportnewsapp.model.NewsDetails;

public interface Api {
    @GET("list.php")
    Flowable<News> getNews(@Query("category") String category);
    @GET("post.php")
    Flowable<NewsDetails> getNewsDetails(@Query("article") String article);
}
