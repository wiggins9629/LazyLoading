package com.wiggins.lazyloading;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wiggins.lazyloading.adapter.MyFragmentPagerAdapter;
import com.wiggins.lazyloading.fragment.AccountFragment;
import com.wiggins.lazyloading.fragment.FixedSpeedScroller;
import com.wiggins.lazyloading.fragment.HomeFragment;
import com.wiggins.lazyloading.fragment.InvestFragment;
import com.wiggins.lazyloading.fragment.MoreFragment;
import com.wiggins.lazyloading.utils.UIUtils;
import com.wiggins.lazyloading.widget.TitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Android之ViewPager+Fragment实现懒加载
 * @Author 一花一世界
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private MainActivity mActivity = null;
    private TitleView titleView;
    private ViewPager viewPager;

    private LinearLayout mLlHome;
    private LinearLayout mLlInvest;
    private LinearLayout mLlAccount;
    private LinearLayout mLlMore;

    private ImageView mImgHome;
    private ImageView mImgInvest;
    private ImageView mImgAccount;
    private ImageView mImgMore;

    private TextView mTvHome;
    private TextView mTvInvest;
    private TextView mTvAccount;
    private TextView mTvMore;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;

        initView();
        setListener();
        initData();
    }

    private void initView() {
        titleView = (TitleView) findViewById(R.id.titleView);
        titleView.setAppTitle(UIUtils.getString(R.string.title));
        titleView.setLeftImageVisibility(View.GONE);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mLlHome = (LinearLayout) findViewById(R.id.ll_home);
        mLlInvest = (LinearLayout) findViewById(R.id.ll_invest);
        mLlAccount = (LinearLayout) findViewById(R.id.ll_account);
        mLlMore = (LinearLayout) findViewById(R.id.ll_more);
        mImgHome = (ImageView) findViewById(R.id.img_home);
        mImgInvest = (ImageView) findViewById(R.id.img_invest);
        mImgAccount = (ImageView) findViewById(R.id.img_account);
        mImgMore = (ImageView) findViewById(R.id.img_more);
        mTvHome = (TextView) findViewById(R.id.tv_home);
        mTvInvest = (TextView) findViewById(R.id.tv_invest);
        mTvAccount = (TextView) findViewById(R.id.tv_account);
        mTvMore = (TextView) findViewById(R.id.tv_more);
    }

    private void setListener() {
        mLlHome.setOnClickListener(this);
        mLlInvest.setOnClickListener(this);
        mLlAccount.setOnClickListener(this);
        mLlMore.setOnClickListener(this);
    }

    private void initData() {
        if (fragments == null) {
            fragments = new ArrayList<>();
        }
        fragments.add(new HomeFragment());
        fragments.add(new InvestFragment());
        fragments.add(new AccountFragment());
        fragments.add(new MoreFragment());

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

        tabShowPosition(0);
        FixedSpeedScroller mScroller = new FixedSpeedScroller(mActivity);
        mScroller.initViewPagerScroll(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tabShowPosition(0);
                        break;
                    case 1:
                        tabShowPosition(1);
                        break;
                    case 2:
                        tabShowPosition(2);
                        break;
                    case 3:
                        tabShowPosition(3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 重置
     */
    private void resetTabSelected() {
        mImgHome.setSelected(false);
        mImgInvest.setSelected(false);
        mImgAccount.setSelected(false);
        mImgMore.setSelected(false);
        mTvHome.setSelected(false);
        mTvInvest.setSelected(false);
        mTvAccount.setSelected(false);
        mTvMore.setSelected(false);
    }

    /**
     * 设置当前显示页状态
     *
     * @param showPosition 当前显示页
     */
    private void tabShowPosition(int showPosition) {
        resetTabSelected();
        switch (showPosition) {
            case 0:
                mImgHome.setSelected(true);
                mTvHome.setSelected(true);
                viewPager.setCurrentItem(0, false);
                break;
            case 1:
                mImgInvest.setSelected(true);
                mTvInvest.setSelected(true);
                viewPager.setCurrentItem(1, false);
                break;
            case 2:
                mImgAccount.setSelected(true);
                mTvAccount.setSelected(true);
                viewPager.setCurrentItem(2, false);
                break;
            case 3:
                mImgMore.setSelected(true);
                mTvMore.setSelected(true);
                viewPager.setCurrentItem(3, false);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_home:
                tabShowPosition(0);
                break;
            case R.id.ll_invest:
                tabShowPosition(1);
                break;
            case R.id.ll_account:
                tabShowPosition(2);
                break;
            case R.id.ll_more:
                tabShowPosition(3);
                break;
        }
    }
}
