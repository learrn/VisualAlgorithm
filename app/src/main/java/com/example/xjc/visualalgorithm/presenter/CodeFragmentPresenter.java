package com.example.xjc.visualalgorithm.presenter;

import android.content.Context;

import com.example.xjc.visualalgorithm.R;
import com.example.xjc.visualalgorithm.model.RectModel;
import com.example.xjc.visualalgorithm.model.SortCode;
import com.example.xjc.visualalgorithm.view.fragment.ICodeFragment;
import com.example.xjc.visualalgorithm.view.ui.SortView;

import java.util.ArrayList;

public class CodeFragmentPresenter {
    private ICodeFragment codeFragment;
    private Context mContext;

    public CodeFragmentPresenter(Context context) {
        this.mContext = context;
    }

    public void setView(ICodeFragment codeFragment) {
        this.codeFragment = codeFragment;
    }

    public void loadInfo(int sortId) {
        switch (sortId) {
            case SortCode.BUBBLE_SORT:
                codeFragment.onLoadTitle(mContext.getString(R.string.title_sort_bubble));
                codeFragment.onLoadIdea(mContext.getString(R.string.text_bubble_idea));
                codeFragment.onLoadCode(SortCode.CODE_BUBBLE);
                break;
            case SortCode.SELECT_SORT:
                codeFragment.onLoadTitle(mContext.getString(R.string.title_sort_select));
                codeFragment.onLoadIdea(mContext.getString(R.string.text_select_idea));
                codeFragment.onLoadCode(SortCode.CODE_SELECT);
                break;
            case SortCode.INSERT_SORT:
                codeFragment.onLoadTitle(mContext.getString(R.string.title_sort_insert));
                codeFragment.onLoadIdea(mContext.getString(R.string.text_insert_idea));
                codeFragment.onLoadCode(SortCode.CODE_INSERT);
                break;
            case SortCode.SHELL_SORT:
                codeFragment.onLoadTitle(mContext.getString(R.string.title_sort_shell));
                codeFragment.onLoadIdea(mContext.getString(R.string.text_shell_idea));
                codeFragment.onLoadCode(SortCode.CODE_SHELL);
                break;
            case SortCode.HEAP_SORT:
                codeFragment.onLoadTitle(mContext.getString(R.string.title_sort_heap));
                codeFragment.onLoadIdea(mContext.getString(R.string.text_heap_idea));
                codeFragment.onLoadCode(SortCode.CODE_HEAP);
                break;
            case SortCode.QUICK_SORT:
                codeFragment.onLoadTitle(mContext.getString(R.string.title_sort_quick));
                codeFragment.onLoadIdea(mContext.getString(R.string.text_quick_idea));
                codeFragment.onLoadCode(SortCode.CODE_QUICK);
                break;
            case SortCode.MERGE_SORT:
                codeFragment.onLoadTitle(mContext.getString(R.string.title_sort_merge));
                codeFragment.onLoadIdea(mContext.getString(R.string.text_merge_idea));
                codeFragment.onLoadCode(SortCode.CODE_MERGE);
                break;
            default:
                break;
        }
    }
}
