package ru.limeek.sportnewsapp.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.limeek.sportnewsapp.app.App;
import ru.limeek.sportnewsapp.di.scope.AppScope;

@Module
public class AppModule {
    private App app;

    public AppModule(App app){
        this.app = app;
    }

    @Provides
    @AppScope
    App providesApp(){
        return app;
    }
}
