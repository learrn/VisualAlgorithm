package com.example.xjc.visualalgorithm.presenter;

import android.content.Context;

import com.example.xjc.visualalgorithm.R;
import com.example.xjc.visualalgorithm.model.SortCode;
import com.example.xjc.visualalgorithm.view.activity.ISortItemActivity;

public class SortItemActivityPresenter {
    private ISortItemActivity sortItemActivity;
    private Context mContext;

    public SortItemActivityPresenter(Context context) {
        this.mContext = context;
    }

    public void setView(ISortItemActivity iSortItemActivity) {
        this.sortItemActivity = iSortItemActivity;
    }

    public void loadInfo(int sortId) {
        switch (sortId) {
            case SortCode.BUBBLE_SORT:
                sortItemActivity.onLoadTitle(mContext.getString(R.string.title_sort_bubble));
                break;
            case SortCode.SELECT_SORT:
                sortItemActivity.onLoadTitle(mContext.getString(R.string.title_sort_select));
                break;
            case SortCode.INSERT_SORT:
                sortItemActivity.onLoadTitle(mContext.getString(R.string.title_sort_insert));
                break;
            case SortCode.SHELL_SORT:
                sortItemActivity.onLoadTitle(mContext.getString(R.string.title_sort_shell));
                break;
            case SortCode.HEAP_SORT:
                sortItemActivity.onLoadTitle(mContext.getString(R.string.title_sort_heap));
                break;
            case SortCode.QUICK_SORT:
                sortItemActivity.onLoadTitle(mContext.getString(R.string.title_sort_quick));
                break;
            case SortCode.MERGE_SORT:
                sortItemActivity.onLoadTitle(mContext.getString(R.string.title_sort_merge));
                break;
            default:
                break;
        }
    }
}
