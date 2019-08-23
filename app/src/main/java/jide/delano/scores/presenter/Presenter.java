package jide.delano.scores.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import jide.delano.scores.model.ApiInterface;
import jide.delano.scores.model.MatchResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterContract {

    private static final String TAG = Presenter.class.getName();


    private List<MatchResult> matchVideolist;

    @Override
    public void initRetrofit() {
        //Create instance of retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.scorebat.com/")//base url
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Create instance of API interface
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        //Execute call request using the call object
        Call<List<MatchResult>> call = apiInterface.getMatchResultsData();
        //use enqueue instead of execute so that it runs asynchronously
        call.enqueue(new Callback<List<MatchResult>>() {
            @Override
            public void onResponse(Call<List<MatchResult>> call, Response<List<MatchResult>> response) {
                if (!response.isSuccessful()){
                    response.code();
                    return;
                }
                List<MatchResult> dataSet = response.body();
            }

            @Override
            public void onFailure(Call<List<MatchResult>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
