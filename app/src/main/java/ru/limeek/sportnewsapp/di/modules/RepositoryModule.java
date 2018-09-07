package ru.limeek.sportnewsapp.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.limeek.sportnewsapp.api.Api;
import ru.limeek.sportnewsapp.di.scope.ViewModelScope;
import ru.limeek.sportnewsapp.model.Repository;

@Module
public class RepositoryModule {
    @Provides
    @ViewModelScope
    public Repository providesRepository(Api api){
        return new Repository(api);
    }
}
