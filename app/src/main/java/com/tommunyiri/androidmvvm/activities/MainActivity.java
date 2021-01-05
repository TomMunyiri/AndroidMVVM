package com.tommunyiri.androidmvvm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.tommunyiri.androidmvvm.R;
import com.tommunyiri.androidmvvm.viewmodels.MostPopularTVShowsViewModel;

public class MainActivity extends AppCompatActivity {
    private MostPopularTVShowsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel=new ViewModelProvider(this).get(MostPopularTVShowsViewModel.class);
        getMostPopularTVShows();
    }

    private void getMostPopularTVShows(){
        viewModel.getMostPopularTVShows(0).observe(this,mostPopularTVShowsResponse->
                        Toast.makeText(getApplicationContext(),"Total pages: "+mostPopularTVShowsResponse.getTotalPages(),Toast.LENGTH_SHORT).show()
                );
    }
}