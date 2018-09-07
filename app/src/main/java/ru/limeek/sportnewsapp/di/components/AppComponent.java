package ru.limeek.sportnewsapp.di.components;

import dagger.Component;
import ru.limeek.sportnewsapp.app.App;
import ru.limeek.sportnewsapp.di.modules.AppModule;
import ru.limeek.sportnewsapp.di.modules.RepositoryModule;
import ru.limeek.sportnewsapp.di.modules.RetrofitModule;
import ru.limeek.sportnewsapp.di.modules.ViewModelModule;
import ru.limeek.sportnewsapp.di.scope.AppScope;

@AppScope
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface AppComponent {
    ViewComponent newViewComponent(ViewModelModule module);
    ViewModelComponent newViewModelComponent(RepositoryModule module);
    App getApp();

    void inject(App app);
}
