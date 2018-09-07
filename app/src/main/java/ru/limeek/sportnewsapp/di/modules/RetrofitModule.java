package ru.limeek.sportnewsapp.di.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.limeek.sportnewsapp.api.Api;
import ru.limeek.sportnewsapp.di.scope.AppScope;

@Module
public class RetrofitModule {
    @Provides
    @AppScope
    public Api provideApi(){
        return new Retrofit.Builder()
                .baseUrl(" http://mikonatoruri.win/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
    }
}
