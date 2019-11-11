package com.mxdl.customview;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class AtlasAdpter extends BaseQuickAdapter<String, BaseViewHolder> {
    public AtlasAdpter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        ImageView image_log=helper.getView(R.id.image_log);
        Glide.with(mContext).load(item).into(image_log);
    }
}
