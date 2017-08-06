package com.luckydu.dujun.circleoffriends.ui.presenter.impl;

import android.content.Context;

import com.luckydu.dujun.circleoffriends.bean.SenderBean;
import com.luckydu.dujun.circleoffriends.ui.model.IUserInfoModel;
import com.luckydu.dujun.circleoffriends.ui.model.impl.UserInfoModel;
import com.luckydu.dujun.circleoffriends.ui.presenter.IUserInfoPresenter;
import com.luckydu.dujun.circleoffriends.ui.view.IUserInfoView;
import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Throwable;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public class UserInfoPresenter implements IUserInfoPresenter {

    private IUserInfoView mView;

    private IUserInfoModel mModel;

    public UserInfoPresenter(IUserInfoView mView) {
        this.mView = mView;
        mModel = new UserInfoModel();
    }

    @Override
    public void getUserInfo(Context context, String user) {
        mModel.getUserInfo(context, user, new BaseSubscriber<SenderBean>() {
            @Override
            public void onError(Throwable e) {
                mView.onFail(e);
            }

            @Override
            public void onNext(SenderBean senderBean) {
                mView.onSuccess(senderBean);
            }
        });
    }
}
