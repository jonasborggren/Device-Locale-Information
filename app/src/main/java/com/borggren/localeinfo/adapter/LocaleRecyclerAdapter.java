package com.borggren.localeinfo.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.borggren.localeinfo.model.LocaleInfo;

import java.util.List;

/**
 * Created by jonas on 12/03/17.
 */

public class LocaleRecyclerAdapter extends RecyclerView.Adapter<LocaleRecyclerAdapter.LocaleViewHolder> {

    private final List<LocaleInfo> mLocaleInfoList;

    public LocaleRecyclerAdapter(List<LocaleInfo> localeInfoList) {
        mLocaleInfoList = localeInfoList;
    }

    @Override
    public int getItemCount() {
        return mLocaleInfoList.size();
    }

    public LocaleInfo getItem(int position) {
        return mLocaleInfoList.get(position);
    }

    @Override
    public LocaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutRes = android.R.layout.simple_list_item_2;
        View view = LayoutInflater.from().inflate(layouRes, parent, false);
        return new LocaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocaleViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        LocaleInfo item = getItem(position);
        holder.mTitleView.setText(item.getTitle(context));
        holder.mSubTitleView.setText(item.getSummary());
    }

    public class LocaleViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleView, mSubTitleView;

        public LocaleViewHolder(View itemView) {
            super(itemView);
            mTitleView = (TextView) itemView.findViewById(android.R.id.text1);
            mSubTitleView = (TextView) itemView.findViewById(android.R.id.text2);
        }
    }
}
