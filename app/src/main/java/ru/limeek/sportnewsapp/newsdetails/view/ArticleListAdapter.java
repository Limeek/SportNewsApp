package ru.limeek.sportnewsapp.newsdetails.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.limeek.sportnewsapp.R;
import ru.limeek.sportnewsapp.model.Article;
import ru.limeek.sportnewsapp.newsdetails.viewmodel.ArticleItemViewModel;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private List<Article> articles = new ArrayList<>();

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.setArticleItemViewModel(new ArticleItemViewModel(articles.get(position)));
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void updateArticles(List<Article> articles) {
        if(articles == null || articles.isEmpty()){
            this.articles.clear();
        }
        else{
            this.articles.clear();
            this.articles.addAll(articles);
        }
        notifyDataSetChanged();
    }
}
