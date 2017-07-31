package com.wiggins.lazyloading.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wiggins.lazyloading.R;

/**
 * @Description 理财
 * @Author 一花一世界
 */
public class InvestFragment extends BaseFragment {

    /**
     * 不可见时调用
     */
    @Override
    protected void onInvisible() {

    }

    /**
     * 获取数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 初始化布局
     */
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_invest, container, false);
        }
        return mRootView;
    }
}
