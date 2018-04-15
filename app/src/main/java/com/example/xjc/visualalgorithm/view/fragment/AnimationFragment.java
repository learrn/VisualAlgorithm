package com.example.xjc.visualalgorithm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xjc.visualalgorithm.R;

public class AnimationFragment extends Fragment{
    private static final String EXTRA_CONTENT = "content";

    public static AnimationFragment newInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        AnimationFragment animationfragment = new AnimationFragment();
        animationfragment.setArguments(arguments);
        return animationfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_tab_animation, null);
        return contentView;
    }
}
