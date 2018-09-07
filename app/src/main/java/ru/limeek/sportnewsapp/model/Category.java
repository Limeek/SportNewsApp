package ru.limeek.sportnewsapp.model;

import ru.limeek.sportnewsapp.R;
import ru.limeek.sportnewsapp.app.App;

public enum Category {
    FOOTBALL("football", App.getInstance().getString(R.string.football)),
    HOCKEY("hockey", App.getInstance().getString(R.string.hockey)),
    TENNIS("tennis", App.getInstance().getString(R.string.tennis)),
    BASKETBALL("basketball", App.getInstance().getString(R.string.basketball)),
    VOLLEYBALL("volleyball", App.getInstance().getString(R.string.volleyball)),
    CYBERSPORT("cybersport", App.getInstance().getString(R.string.cybersport));

    private final String key;
    private final String name;

    Category(String key, String name){
        this.key = key;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString(){
        return name;
    }
}
