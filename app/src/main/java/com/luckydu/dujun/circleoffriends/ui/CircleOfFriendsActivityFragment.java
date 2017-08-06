package com.luckydu.dujun.circleoffriends.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luckydu.dujun.circleoffriends.R;
import com.luckydu.dujun.circleoffriends.bean.SenderBean;
import com.luckydu.dujun.circleoffriends.bean.Tweet;
import com.luckydu.dujun.circleoffriends.ui.adapter.TweetAdapter;
import com.luckydu.dujun.circleoffriends.ui.presenter.impl.CircleOfFriendsPresenter;
import com.luckydu.dujun.circleoffriends.ui.presenter.impl.UserInfoPresenter;
import com.luckydu.dujun.circleoffriends.ui.view.ICircleOfFriendsView;
import com.luckydu.dujun.circleoffriends.ui.view.IUserInfoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class CircleOfFriendsActivityFragment extends Fragment implements ICircleOfFriendsView, IUserInfoView, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tweets)
    RecyclerView recyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.fruit_image_view)
    ImageView fruitImageView;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.icon)
    ImageView icon;

    Unbinder unbinder;

    private Context context;
    private CircleOfFriendsPresenter circleOfFriendsPresenter;
    private UserInfoPresenter userInfoPresenter;

    private TweetAdapter mAdapter;
    private List<Tweet> tweetList;

    private static int REFRESH = 0;
    private static int LOADMORE = 1;
    private int LOAD_TYPE = REFRESH; //  REFRESH : 下拉刷新,LOADMORE :加载更多

    String user = "jsmith";

    public CircleOfFriendsActivityFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle_of_friends, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        initAdapter();
        return view;
    }

    private void initAdapter() {
        mAdapter = new TweetAdapter(R.layout.item_tweets, tweetList);
        mAdapter.setOnLoadMoreListener(this, recyclerView);
        recyclerView.setAdapter(mAdapter);
    }

    private void initView() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        collapsingToolbarLayout.setTitle(user);
        //通过CollapsingToolbarLayout修改字体颜色
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色

        swipeLayout.setOnRefreshListener(this);
        //设置样式刷新显示的位置
        swipeLayout.setProgressViewOffset(true, -20, 100);
        swipeLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent, R.color.colorAccent);

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset >= 0) {
                    swipeLayout.setEnabled(true);
                } else {
                    swipeLayout.setEnabled(false);
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    private void initData() {
        userInfoPresenter = new UserInfoPresenter(this);
        circleOfFriendsPresenter = new CircleOfFriendsPresenter(this);
        tweetList = new ArrayList<>();
        getUserInfo(user);
        getTweets(user);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getTweets(String user) {
        circleOfFriendsPresenter.getTweets(context, user);
    }

    @Override
    public void onSuccess(List<Tweet> tweets) {
        // 判断加载类型
        if (LOAD_TYPE == REFRESH) {
            // 下拉刷新
            swipeLayout.setRefreshing(false); // 收起刷新图标
            mAdapter.setEnableLoadMore(true); // 设置可以加载更多
            tweetList.clear();
        } else if (LOAD_TYPE == LOADMORE) {
            // 加载更多时
            mAdapter.loadMoreEnd(false);// 不显示加载更多
            mAdapter.setEnableLoadMore(true); // 设置可以加载更多
            mAdapter.loadMoreComplete();
            swipeLayout.setEnabled(true);
        }

        if (tweets == null) {
            tweetList.clear();
            return;
        }
        Toast.makeText(context, "size:" + tweets.size(), Toast.LENGTH_SHORT).show();
        tweetList.addAll(tweets);
        mAdapter.notifyDataSetChanged();
        mAdapter.disableLoadMoreIfNotFullPage(recyclerView);
    }

    @Override
    public void getUserInfo(String user) {
        userInfoPresenter.getUserInfo(context, user);
    }

    @Override
    public void onSuccess(SenderBean senderBean) {
        // 显示用户信息
        Toast.makeText(context, "size:" + senderBean.toString(), Toast.LENGTH_SHORT).show();

        Glide.with(this).load(senderBean.getAvatar()).into(icon);
        Glide.with(this).load(senderBean.getProfileimage()).into(fruitImageView);
    }

    @Override
    public void onFail(Throwable e) {
        Toast.makeText(context, "onFail:" + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        LOAD_TYPE = REFRESH;
        mAdapter.setEnableLoadMore(false);
        getTweets(user);
    }

    @Override
    public void onLoadMoreRequested() {
        LOAD_TYPE = LOADMORE;
        swipeLayout.setEnabled(false);
        getTweets(user);
    }
}
