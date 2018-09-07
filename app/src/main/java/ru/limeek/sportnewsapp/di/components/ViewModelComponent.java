package ru.limeek.sportnewsapp.di.components;

import dagger.Subcomponent;
import ru.limeek.sportnewsapp.di.modules.RepositoryModule;
import ru.limeek.sportnewsapp.di.scope.ViewModelScope;
import ru.limeek.sportnewsapp.news.viewmodel.NewsViewModel;
import ru.limeek.sportnewsapp.newsdetails.viewmodel.NewsDetailsViewModel;

@ViewModelScope
@Subcomponent(modules = {RepositoryModule.class})
public interface ViewModelComponent {
    void inject(NewsViewModel viewModel);
    void inject(NewsDetailsViewModel viewModel);
}
