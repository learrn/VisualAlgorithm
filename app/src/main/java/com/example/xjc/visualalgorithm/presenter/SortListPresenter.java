package com.example.xjc.visualalgorithm.presenter;

import android.content.Context;

import com.example.xjc.visualalgorithm.R;
import com.example.xjc.visualalgorithm.model.SortCode;
import com.example.xjc.visualalgorithm.view.activity.ISortItemActivity;
import com.example.xjc.visualalgorithm.view.activity.ISortListActivity;

import java.util.ArrayList;

public class SortListPresenter {
    private ISortListActivity sortListActivity;
    private Context mContext;
    public SortListPresenter(Context context) {
        this.mContext = context;
    }

    public void setView(ISortListActivity iSortListActivity) {
        this.sortListActivity = iSortListActivity;
    }

    public void loadInfo() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(SortCode.BUBBLE_SORT,mContext.getString(R.string.title_sort_bubble));
        arrayList.add(SortCode.SELECT_SORT,mContext.getString(R.string.title_sort_select));
        arrayList.add(SortCode.INSERT_SORT,mContext.getString(R.string.title_sort_insert));
        arrayList.add(SortCode.SHELL_SORT,mContext.getString(R.string.title_sort_shell));
        arrayList.add(SortCode.HEAP_SORT,mContext.getString(R.string.title_sort_heap));
        arrayList.add(SortCode.QUICK_SORT,mContext.getString(R.string.title_sort_quick));
//        arrayList.add(SortCode.MERGE_SORT,mContext.getString(R.string.title_sort_merge));
        sortListActivity.onLoadSortList(arrayList);
    }
}
