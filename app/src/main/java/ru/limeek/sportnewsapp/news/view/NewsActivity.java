package ru.limeek.sportnewsapp.news.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import javax.inject.Inject;

import ru.limeek.sportnewsapp.R;
import ru.limeek.sportnewsapp.app.App;
import ru.limeek.sportnewsapp.databinding.NewsActivityBinding;
import ru.limeek.sportnewsapp.di.components.ViewComponent;
import ru.limeek.sportnewsapp.di.modules.ViewModelModule;
import ru.limeek.sportnewsapp.model.Category;
import ru.limeek.sportnewsapp.news.viewmodel.NewsResponse;
import ru.limeek.sportnewsapp.news.viewmodel.NewsViewModel;

public class NewsActivity extends AppCompatActivity {
    @Inject
    protected NewsViewModel newsViewModel;

    private NewsActivityBinding binding;

    private ViewComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
        bind();
        initRecyclerView();
        initSpinner();
    }


    private void bind(){
        binding = DataBindingUtil.setContentView(this, R.layout.news_activity);
        binding.setNewsViewModel(newsViewModel);
        newsViewModel.getResponse().observe(this, newsResponse -> processResponse(newsResponse));
    }

    private void initRecyclerView(){
        RecyclerView recView = binding.recViewNews;
        recView.setAdapter(newsViewModel.getRecyclerAdapter());
        recView.addItemDecoration(new DividerItemDecoration(recView.getContext(),DividerItemDecoration.VERTICAL));
        recView.setLayoutManager(new LinearLayoutManager(recView.getContext()));
    }

    private void initSpinner(){
        Spinner spinner = binding.spinnerCategory;
        spinner.setAdapter(new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Category.values()));
        spinner.setOnItemSelectedListener(newsViewModel.spinnerItemSelected());
    }

    private void processResponse(NewsResponse response){
        if(response.getError() != null){
            response.getError().printStackTrace();
            Toast.makeText(this, R.string.network_error, Toast.LENGTH_LONG).show();
        }
    }

    private void initComponent(){
        component = App.getInstance().getComponent().newViewComponent(new ViewModelModule(this));
        component.inject(this);
    }
}
