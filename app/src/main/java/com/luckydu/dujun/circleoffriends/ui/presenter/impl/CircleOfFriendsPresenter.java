package com.luckydu.dujun.circleoffriends.ui.presenter.impl;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.MyBaseSubscriber;
import com.luckydu.dujun.circleoffriends.bean.Tweet;
import com.luckydu.dujun.circleoffriends.ui.model.ICircleOfFriendsModel;
import com.luckydu.dujun.circleoffriends.ui.model.impl.CircleOfFriendsModel;
import com.luckydu.dujun.circleoffriends.ui.presenter.ICircleOfFriendsPresenter;
import com.luckydu.dujun.circleoffriends.ui.view.ICircleOfFriendsView;
import com.luckydu.dujun.circleoffriends.util.StringUtils;
import com.tamic.novate.Throwable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by dujun on 2017-08-05.
 */

public class CircleOfFriendsPresenter implements ICircleOfFriendsPresenter {

    private ICircleOfFriendsView mView;

    private ICircleOfFriendsModel mModel;

    public CircleOfFriendsPresenter(ICircleOfFriendsView mView) {
        this.mView = mView;
        mModel = new CircleOfFriendsModel();
    }

    @Override
    public void getTweets(Context context, String user) {
        // 显示pb

        // 调用model获取数据
        mModel.getTweets(context, user, new MyBaseSubscriber<List<Tweet>>(context) {
            @Override
            public void onError(Throwable e) {
                mView.onFail(e);
            }

            @Override
            public void onNext(List<Tweet> tweets) {
                List<Tweet> tweetList = new ArrayList<>();
                for (Tweet tweet : tweets) {
                    if (!StringUtils.isNull(tweet.getContent()) && tweet.getImages() != null && tweet.getImages().size() != 0) {
                        tweetList.add(tweet);
                    }
                }
                mView.onSuccess(tweetList);
            }
        });
    }
}
