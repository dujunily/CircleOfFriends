package com.luckydu.dujun.circleoffriends.ui.view;

import com.luckydu.dujun.circleoffriends.bean.Tweet;

import java.util.List;

/**
 *
 * Created by dujun on 2017-08-05.
 */

public interface ICircleOfFriendsView {
    /**
     * 获取tweets列表
     * @param user 用户名
     */
    void getTweets(String user);

    void onSuccess(List<Tweet> tweets);

    void onFail(Throwable e);
}
