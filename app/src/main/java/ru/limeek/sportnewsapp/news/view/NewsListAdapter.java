package ru.limeek.sportnewsapp.news.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.limeek.sportnewsapp.R;
import ru.limeek.sportnewsapp.model.Event;
import ru.limeek.sportnewsapp.news.viewmodel.NewsItemViewModel;

public class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private List<Event> events = new ArrayList<>();

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.setNewsItemViewModel(new NewsItemViewModel(events.get(position)));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void updateEvents(List<Event> events){
        if(events == null || events.isEmpty()){
            this.events.clear();
        }
        else{
            this.events.clear();
            this.events.addAll(events);
        }
        notifyDataSetChanged();
    }
}
