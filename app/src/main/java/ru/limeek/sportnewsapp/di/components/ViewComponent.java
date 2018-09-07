package ru.limeek.sportnewsapp.di.components;

import dagger.Subcomponent;
import ru.limeek.sportnewsapp.di.modules.ViewModelModule;
import ru.limeek.sportnewsapp.di.scope.ViewScope;
import ru.limeek.sportnewsapp.news.view.NewsActivity;
import ru.limeek.sportnewsapp.newsdetails.view.NewsDetailsActivity;

@ViewScope
@Subcomponent(modules = {ViewModelModule.class})
public interface ViewComponent {
    void inject(NewsActivity activity);
    void inject(NewsDetailsActivity activity);
}
