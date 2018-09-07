package ru.limeek.sportnewsapp.di.modules;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import ru.limeek.sportnewsapp.di.scope.ViewScope;
import ru.limeek.sportnewsapp.news.viewmodel.NewsViewModel;
import ru.limeek.sportnewsapp.newsdetails.viewmodel.NewsDetailsViewModel;

@Module
public class ViewModelModule {
    private AppCompatActivity activity;

    public ViewModelModule(AppCompatActivity activity){
        this.activity = activity;
    }

    @Provides
    @ViewScope
    public NewsViewModel providesNewsViewModel(){
        return ViewModelProviders.of(activity).get(NewsViewModel.class);
    }

    @Provides
    @ViewScope
    public NewsDetailsViewModel provideNewsDetailsViewModel(){
        return ViewModelProviders.of(activity).get(NewsDetailsViewModel.class);
    }
}
