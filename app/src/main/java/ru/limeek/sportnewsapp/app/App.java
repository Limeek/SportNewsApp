package ru.limeek.sportnewsapp.app;

import android.app.Application;

import ru.limeek.sportnewsapp.di.components.AppComponent;
import ru.limeek.sportnewsapp.di.components.DaggerAppComponent;
import ru.limeek.sportnewsapp.di.modules.AppModule;
import ru.limeek.sportnewsapp.di.modules.RetrofitModule;

public class App extends Application {
    private static App app;

    private AppComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        setupComponent();
    }

    private void setupComponent(){
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule())
                .build();
        component.inject(this);
        app = getComponent().getApp();
    }

    public AppComponent getComponent() {
        return component;
    }

    public static App getInstance() {
        return app;
    }
}
