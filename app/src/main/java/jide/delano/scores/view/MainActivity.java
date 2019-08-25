package jide.delano.scores.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import jide.delano.scores.R;
import jide.delano.scores.model.MatchResult;
import jide.delano.scores.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements ViewContract {

    private RecyclerView recyclerView;
    private Presenter presenter;
    private LinearLayoutManager linearLayoutManager;
    private CustomAdapter customAdapter;
    private List<MatchResult> dataSet = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        presenter = new Presenter();

        initUI();
        onBindPresenter();
        initNetworkCall();

    }

    @Override
    public void onBindPresenter() {
        presenter = new Presenter();
        presenter.onBindView(this);
    }

    @Override
    public void initNetworkCall() {
        presenter.initRetrofit();
    }

    @Override
    public void getMatchData(List<MatchResult> dataSet) {
        customAdapter.setDataSet(dataSet);
    }

    @Override
    public void initUI() {
        recyclerView = findViewById(R.id.video_recyclerview);
        customAdapter = new CustomAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public void getFailureMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT);

    }

}
