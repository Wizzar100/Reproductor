package com.sandipbhattacharya.videoviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class VideoListAdapter extends BaseAdapter {

    private Context mContext;
    private int[] mVideoResources;

    public VideoListAdapter(Context context, int[] videoResources) {
        mContext = context;
        mVideoResources = videoResources;
    }

    @Override
    public int getCount() {
        return mVideoResources.length;
    }

    @Override
    public Object getItem(int position) {
        return mVideoResources[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText("Video " + (position + 1));
        return convertView;
    }
}
