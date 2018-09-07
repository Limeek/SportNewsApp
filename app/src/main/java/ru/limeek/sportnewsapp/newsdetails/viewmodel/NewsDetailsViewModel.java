package ru.limeek.sportnewsapp.newsdetails.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.limeek.sportnewsapp.app.App;
import ru.limeek.sportnewsapp.di.components.ViewModelComponent;
import ru.limeek.sportnewsapp.di.modules.RepositoryModule;
import ru.limeek.sportnewsapp.model.NewsDetails;
import ru.limeek.sportnewsapp.model.Repository;
import ru.limeek.sportnewsapp.newsdetails.view.ArticleListAdapter;

public class NewsDetailsViewModel extends ViewModel {
    private NewsDetails newsDetails;
    private ArticleListAdapter adapter;
    private final MutableLiveData<NewsDetailsResponse> response = new MutableLiveData<>();
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    protected Repository repository;
    private ViewModelComponent component;

    NewsDetailsViewModel(){
        adapter = new ArticleListAdapter();
        newsDetails = new NewsDetails();
        component = App.getInstance().getComponent().newViewModelComponent(new RepositoryModule());
        component.inject(this);
    }

    public ArticleListAdapter getAdapter() {
        return adapter;
    }

    public void setArticleKey(String articleKey) {
        getNewsDetailsFromApi(articleKey);
    }

    private void getNewsDetailsFromApi(String articleKey){
        disposable.add(
                repository.getApi()
                .getNewsDetails(articleKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        newsDetails -> {
                            this.newsDetails.updateValues(newsDetails);
                            response.setValue(NewsDetailsResponse.success(newsDetails));
                            adapter.updateArticles(newsDetails.getArticle());
                        },
                        error -> response.setValue(NewsDetailsResponse.error(error))
                )
        );
    }

    public MutableLiveData<NewsDetailsResponse> getResponse() {
        return response;
    }

    public NewsDetails getNewsDetails() {
        return newsDetails;
    }

    @Override
    public void onCleared(){
        disposable.clear();
    }
}
