package com.example.xjc.visualalgorithm.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.xjc.visualalgorithm.R;
import com.example.xjc.visualalgorithm.presenter.SortListPresenter;
import com.example.xjc.visualalgorithm.view.activity.adapt.ListRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SortListActivity extends AppCompatActivity implements ISortListActivity {
    private RecyclerView mListRv;
    private ListRecyclerViewAdapter listRecyclerViewAdapter;
    private List<String> sortList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_list);
        initPresenter();
        initView();
    }

    private void initPresenter() {
        SortListPresenter sortListPresenter = new SortListPresenter(this);
        sortListPresenter.setView(this);
        sortListPresenter.loadInfo();
    }

    private void initView() {
        mListRv = findViewById(R.id.rv_list);
        mListRv.setItemAnimator(new DefaultItemAnimator());
        listRecyclerViewAdapter = new ListRecyclerViewAdapter(this, sortList);
        mListRv.setLayoutManager(new LinearLayoutManager(this));
        mListRv.setAdapter(listRecyclerViewAdapter);
        listRecyclerViewAdapter.setOnItemClickListener(new ListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                SortItemActivity.launch(SortListActivity.this, position);
            }
        });
    }

    @Override
    public void onLoadSortList(ArrayList<String> arrayList) {
        sortList = arrayList;
        initView();
    }
}
