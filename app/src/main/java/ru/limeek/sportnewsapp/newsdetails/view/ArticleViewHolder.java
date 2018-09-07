package ru.limeek.sportnewsapp.newsdetails.view;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.limeek.sportnewsapp.databinding.ArticleItemBinding;
import ru.limeek.sportnewsapp.newsdetails.viewmodel.ArticleItemViewModel;


public class ArticleViewHolder extends RecyclerView.ViewHolder{
    private ArticleItemBinding binding;

    ArticleViewHolder(View itemView){
        super(itemView);
        bind();
    }

    public void bind(){
        if(binding == null){
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public void setArticleItemViewModel(ArticleItemViewModel viewModel){
        binding.setArticleItemViewModel(viewModel);
    }

}
