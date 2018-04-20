package com.example.xjc.visualalgorithm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xjc.visualalgorithm.R;
import com.example.xjc.visualalgorithm.presenter.CodeFragmentPresenter;

import thereisnospon.codeview.CodeView;

public class CodeFragment extends Fragment implements ICodeFragment{
    private static final String EXTRA_CONTENT = "content";
    private int sortId;
    private CodeView mCodeCv;
    private TextView mIdeaTv;
    private static ViewPager mViewPager;
    private CodeFragmentPresenter codeFragmentPresenter;

    public static CodeFragment newInstance(int sortId, ViewPager viewPager){
        Bundle arguments = new Bundle();
        arguments.putInt(EXTRA_CONTENT, sortId);
        CodeFragment codeFragment = new CodeFragment();
        codeFragment.setArguments(arguments);
        mViewPager = viewPager;
        return codeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_tab_code, null);

        mCodeCv = contentView.findViewById(R.id.cv_code);
        mIdeaTv = contentView.findViewById(R.id.tv_idea);

        mCodeCv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    mViewPager.requestDisallowInterceptTouchEvent(false);
                else
                    mViewPager.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        codeFragmentPresenter = new CodeFragmentPresenter(getContext());
        codeFragmentPresenter.setView(this);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sortId = getArguments().getInt(EXTRA_CONTENT,0);
        codeFragmentPresenter.loadInfo(sortId);
    }

    @Override
    public void onLoadTitle(String title) {

    }

    @Override
    public void onLoadIdea(String idea) {
        mIdeaTv.setText(idea);
    }

    @Override
    public void onLoadCode(String code) {
        mCodeCv.showCode(code);
    }
}
