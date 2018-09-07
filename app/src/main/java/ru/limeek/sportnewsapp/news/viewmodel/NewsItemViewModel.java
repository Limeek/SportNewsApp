package ru.limeek.sportnewsapp.news.viewmodel;

import android.arch.lifecycle.ViewModel;

import ru.limeek.sportnewsapp.model.Event;

public class NewsItemViewModel extends ViewModel {
    private Event event;

    public NewsItemViewModel(Event event){
        this.event = event;
    }

    public String onClick(){
        return event.getArticle();
    }

    public Event getEvent() {
        return event;
    }
}
