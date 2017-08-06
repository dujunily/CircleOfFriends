package com.luckydu.dujun.circleoffriends.ui.model;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.MyBaseSubscriber;
import com.luckydu.dujun.circleoffriends.bean.Tweet;

import java.util.List;

/**
 *
 * Created by dujun on 2017-08-05.
 */

public interface ICircleOfFriendsModel {

    void getTweets(Context context, String user, MyBaseSubscriber<List<Tweet>> subscriber);
}
