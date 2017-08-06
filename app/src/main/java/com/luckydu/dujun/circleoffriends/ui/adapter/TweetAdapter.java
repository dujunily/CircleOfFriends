package com.luckydu.dujun.circleoffriends.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luckydu.dujun.circleoffriends.R;
import com.luckydu.dujun.circleoffriends.bean.Tweet;
import com.luckydu.dujun.circleoffriends.util.StringUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public class TweetAdapter extends BaseQuickAdapter<Tweet, BaseViewHolder> {

    public TweetAdapter(@LayoutRes int layoutResId, @Nullable List<Tweet> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Tweet item) {
        if (!StringUtils.isNull(item.getContent())) {
            // 设置图标
            Glide.with(mContext).load(item.getSender().getAvatar()).asBitmap().into((ImageView) helper.getView(R.id.img_avatar));
            Picasso.with(mContext)
                    .load(item.getSender().getAvatar())
                    .into((ImageView) helper.getView(R.id.img_avatar));
            // 设置朋友圈内容
            helper.setText(R.id.tv_content, item.getContent());
        }
    }
}
