package ru.limeek.sportnewsapp.news.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;
import android.widget.AdapterView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.limeek.sportnewsapp.app.App;
import ru.limeek.sportnewsapp.di.components.ViewModelComponent;
import ru.limeek.sportnewsapp.di.modules.RepositoryModule;
import ru.limeek.sportnewsapp.model.Category;
import ru.limeek.sportnewsapp.model.Repository;
import ru.limeek.sportnewsapp.news.view.NewsListAdapter;

public class NewsViewModel extends ViewModel {

    private NewsListAdapter recyclerAdapter;
    private final MutableLiveData<NewsResponse> response = new MutableLiveData<>();
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    protected Repository repository;

    private ViewModelComponent component;

    NewsViewModel(){
        recyclerAdapter = new NewsListAdapter();
        component = App.getInstance().getComponent().newViewModelComponent(new RepositoryModule());
        component.inject(this);
    }

    private void getNewsFromApi(Category category){
        disposable.add(
                repository.getApi().getNews(category.getKey())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        news -> {response.setValue(NewsResponse.success(news));
                            recyclerAdapter.updateEvents(news.getEvents());},
                        throwable -> response.setValue(NewsResponse.error(throwable))
                )
        );
    }

    public AdapterView.OnItemSelectedListener spinnerItemSelected(){
        return new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getNewsFromApi((Category) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        };
    }

    @Override
    public void onCleared(){
        disposable.clear();
    }

    public NewsListAdapter getRecyclerAdapter() {
        return recyclerAdapter;
    }

    public MutableLiveData<NewsResponse> getResponse() {
        return response;
    }
}
