package com.luckydu.dujun.circleoffriends.ui.model.impl;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.MyBaseSubscriber;
import com.luckydu.dujun.circleoffriends.api.TweetApiManager;
import com.luckydu.dujun.circleoffriends.bean.Tweet;
import com.luckydu.dujun.circleoffriends.ui.model.ICircleOfFriendsModel;

import java.util.List;

/**
 *
 * Created by dujun on 2017-08-05.
 */

public class CircleOfFriendsModel implements ICircleOfFriendsModel {

    @Override
    public void getTweets(Context context,String user,MyBaseSubscriber<List<Tweet>> subscriber) {

        // 先从数据库获取数据显示出来

        // 从网络获取数据异步显示
        TweetApiManager.createNovate(context).call(TweetApiManager.getTweets(context, user), subscriber);
    }
}
