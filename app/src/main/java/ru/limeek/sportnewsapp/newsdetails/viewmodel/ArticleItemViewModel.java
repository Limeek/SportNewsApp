package ru.limeek.sportnewsapp.newsdetails.viewmodel;

import ru.limeek.sportnewsapp.model.Article;

public class ArticleItemViewModel {
    private Article article;

    public ArticleItemViewModel(Article article){
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
