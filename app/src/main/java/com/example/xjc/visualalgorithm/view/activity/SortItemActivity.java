package com.example.xjc.visualalgorithm.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xjc.visualalgorithm.R;

import java.util.ArrayList;
import java.util.List;

public class SortItemActivity extends AppCompatActivity {
    private TabLayout mTabTl;
    private ViewPager mContentVp;
    private List<Fragment> tabFragments;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_item);
        mTabTl = (TabLayout) findViewById(R.id.tl_tab);
        mContentVp = (ViewPager) findViewById(R.id.vp_content);
    }

    private void initTab(){
        mTabTl.setupWithViewPager(mContentVp);
    }

    private void initContent(){
        tabFragments = new ArrayList<>(2);
        titles.add(this.getString(R.string.tab_sortitem_code));
        titles.add(this.getString(R.string.tab_sortitem_animation));


    }
}
