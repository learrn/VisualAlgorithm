package com.example.xjc.visualalgorithm.view.fragment;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.example.xjc.visualalgorithm.R;
import com.example.xjc.visualalgorithm.model.SortCode;
import com.example.xjc.visualalgorithm.presenter.CodeFragmentPresenter;

import thereisnospon.codeview.CodeView;

public class CodeFragment extends Fragment implements ICodeFragment{
    private int sortId;
    private CodeView mCodeCv;
    private TextView mIdeaTv;
    private static ViewPager mViewPager;
    private CodeFragmentPresenter codeFragmentPresenter;

    public static CodeFragment newInstance(int sortId, ViewPager viewPager){
        Bundle arguments = new Bundle();
        arguments.putInt(SortCode.SORT_ID, sortId);
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

        sortId = getArguments().getInt(SortCode.SORT_ID,0);
        codeFragmentPresenter.loadInfo(sortId);
    }

    @Override
    public void onLoadTitle(String title) {

    }

    @Override
    public void onLoadIdea(String idea) {
        mIdeaTv.setText(idea);
        mIdeaTv.post(new Runnable() {
            @Override
            public void run() {
                startTextAnim(mIdeaTv);
            }
        });
    }

    @Override
    public void onLoadCode(String code) {
        mCodeCv.showCode(code);
    }
    private void startTextAnim(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = ViewAnimationUtils.createCircularReveal(
                    view, 0, 0, 0,
                    (float) Math.hypot(view.getWidth(), view.getHeight()));
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(700);
            animator.start();
        }
    }
}
