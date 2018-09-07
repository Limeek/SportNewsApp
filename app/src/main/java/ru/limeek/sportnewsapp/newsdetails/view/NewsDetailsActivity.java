package ru.limeek.sportnewsapp.newsdetails.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import ru.limeek.sportnewsapp.R;
import ru.limeek.sportnewsapp.app.App;
import ru.limeek.sportnewsapp.databinding.NewsDetailsActivityBinding;
import ru.limeek.sportnewsapp.di.components.ViewComponent;
import ru.limeek.sportnewsapp.di.modules.ViewModelModule;
import ru.limeek.sportnewsapp.newsdetails.viewmodel.NewsDetailsResponse;
import ru.limeek.sportnewsapp.newsdetails.viewmodel.NewsDetailsViewModel;

public class NewsDetailsActivity extends AppCompatActivity {
    @Inject
    protected NewsDetailsViewModel viewModel;

    private NewsDetailsActivityBinding binding;

    private ViewComponent component;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {finish(); return true;}
            default : return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initComponent();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bind();
        initRecyclerView();
        setArticleKeyForVM();
    }

    private void bind(){
        binding = DataBindingUtil.setContentView(this, R.layout.news_details_activity);
        binding.setNewsDetailsViewModel(viewModel);
        binding.getNewsDetailsViewModel().getResponse().observe(this, newsDetailsResponse -> processNewsDetailsResponse(newsDetailsResponse));
    }

    private void initRecyclerView(){
        RecyclerView recView = binding.recViewArticles;
        recView.setAdapter(viewModel.getAdapter());
        recView.addItemDecoration(new DividerItemDecoration(recView.getContext(),DividerItemDecoration.VERTICAL));
        recView.setLayoutManager(new LinearLayoutManager(recView.getContext()));
    }

    private void setArticleKeyForVM(){
        if(getIntent().hasExtra("article_key")){
            viewModel.setArticleKey(getIntent().getStringExtra("article_key"));
        }
    }

    private void initComponent(){
        component = App.getInstance().getComponent().newViewComponent(new ViewModelModule(this));
        component.inject(this);
    }

    private void processNewsDetailsResponse(NewsDetailsResponse response){
        if(response.getThrowable() != null)
            Toast.makeText(this, R.string.network_error, Toast.LENGTH_SHORT).show();
        else
            processSuccessfulResponse(response);


    }

    private void processSuccessfulResponse(NewsDetailsResponse response){
        if(response.getNewsDetails().getTournament() == null || response.getNewsDetails().getTournament().equals("") || response.getNewsDetails().getTournament().contains("Экспресс")){
            binding.tvTournament.setVisibility(View.GONE);
            binding.tvFacts.setVisibility(View.GONE);
            binding.tvTeam1.setVisibility(View.GONE);
            binding.tvTeam2.setVisibility(View.GONE);
            binding.tvTime.setVisibility(View.GONE);
            binding.recViewArticles.setVisibility(View.GONE);
            binding.tvPredictionLabel.setVisibility(View.VISIBLE);
        }
        else if (response.getNewsDetails().getPrediction() == null || response.getNewsDetails().getPrediction().equals("")){
            binding.tvFacts.setVisibility(View.VISIBLE);
            binding.tvDash.setVisibility(View.VISIBLE);
            binding.tvPredictionLabel.setVisibility(View.VISIBLE);
            binding.tvPredictionLabel.setVisibility(View.GONE);
            binding.tvPrediction.setVisibility(View.GONE);
        }
        else if(response.getNewsDetails().getArticle() == null || response.getNewsDetails().getArticle().isEmpty() ||
                (response.getNewsDetails().getArticle().size() == 1 && response.getNewsDetails().getArticle().get(0).isEmpty())){
            binding.tvFacts.setVisibility(View.VISIBLE);
            binding.tvDash.setVisibility(View.VISIBLE);
            binding.tvPredictionLabel.setVisibility(View.VISIBLE);
            binding.recViewArticles.setVisibility(View.GONE);
            binding.tvFacts.setVisibility(View.GONE);
        }
        else if(response.getNewsDetails().getTime() == null || response.getNewsDetails().getTime().equals("")){
            binding.tvFacts.setVisibility(View.VISIBLE);
            binding.tvDash.setVisibility(View.VISIBLE);
            binding.tvPredictionLabel.setVisibility(View.VISIBLE);
            binding.recViewArticles.setVisibility(View.GONE);
        }
        else if(response.getNewsDetails().getPlace() == null || response.getNewsDetails().getPlace().equals("")){
            binding.tvFacts.setVisibility(View.VISIBLE);
            binding.tvDash.setVisibility(View.VISIBLE);
            binding.tvPredictionLabel.setVisibility(View.VISIBLE);
            binding.tvPlace.setVisibility(View.GONE);
        }
    }
}
