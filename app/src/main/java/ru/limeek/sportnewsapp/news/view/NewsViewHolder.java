package ru.limeek.sportnewsapp.news.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.limeek.sportnewsapp.databinding.NewsItemBinding;
import ru.limeek.sportnewsapp.news.viewmodel.NewsItemViewModel;
import ru.limeek.sportnewsapp.newsdetails.view.NewsDetailsActivity;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    private NewsItemBinding binding;
    private NewsItemViewModel viewModel;

    NewsViewHolder(View itemView){
        super(itemView);
        bind();
        itemView.setOnClickListener((view) -> {
            Intent intent = new Intent(this.itemView.getContext(), NewsDetailsActivity.class);
            intent.putExtra("article_key", viewModel.onClick());
            this.itemView.getContext().startActivity(intent);
        });
    }

    public void bind(){
        if(binding == null){
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public void setNewsItemViewModel(NewsItemViewModel newsItemViewModel) {
        binding.setNewsItemViewModel(newsItemViewModel);
        this.viewModel = newsItemViewModel;
    }
}
