package com.example.xjc.visualalgorithm.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.xjc.visualalgorithm.R;
import com.example.xjc.visualalgorithm.model.SortCode;
import com.example.xjc.visualalgorithm.presenter.SortItemActivityPresenter;
import com.example.xjc.visualalgorithm.view.activity.adapt.ContentPagerAdapter;
import com.example.xjc.visualalgorithm.view.fragment.AnimationFragment;
import com.example.xjc.visualalgorithm.view.fragment.CodeFragment;

import java.util.ArrayList;
import java.util.List;

public class SortItemActivity extends AppCompatActivity implements ISortItemActivity {
    private TabLayout mTabTl;
    private ViewPager mContentVp;
    private List<Fragment> tabFragments;
    private List<String> titles;
    private ActionBar actionBar;
    private int sortId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_item);
        mTabTl = findViewById(R.id.tl_tab);
        mContentVp = findViewById(R.id.vp_content);
        sortId = getIntent().getIntExtra(SortCode.SORT_ID, SortCode.BUBBLE_SORT);
        SortItemActivityPresenter sortItemActivityPresenter = new SortItemActivityPresenter(this);
        sortItemActivityPresenter.setView(this);
        initActionBar();
        initContent();
        initTab();
        sortItemActivityPresenter.loadInfo(sortId);
    }

    public static void launch(Activity activity, int sortId) {
        Intent intent = new Intent(activity, SortItemActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(SortCode.SORT_ID, sortId);
        activity.startActivity(intent);
    }

    private void initActionBar() {
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void initTab() {
        ContentPagerAdapter contentPagerAdapter = new ContentPagerAdapter(getSupportFragmentManager(), tabFragments, titles);
        mContentVp.setAdapter(contentPagerAdapter);
        mContentVp.setOffscreenPageLimit(2);
        mTabTl.setupWithViewPager(mContentVp);
    }

    private void initContent() {
        tabFragments = new ArrayList<>(2);
        titles = new ArrayList<>(2);
        titles.add(this.getString(R.string.tab_sortitem_code));
        titles.add(this.getString(R.string.tab_sortitem_animation));
        CodeFragment codeFragment = CodeFragment.newInstance(sortId, mContentVp);
        AnimationFragment animationFragment = AnimationFragment.newInstance(sortId);
        tabFragments.add(codeFragment);
        tabFragments.add(animationFragment);
    }

    @Override
    public void onLoadTitle(String title) {
        actionBar.setTitle(title);
    }
}
