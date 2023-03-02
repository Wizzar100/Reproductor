package com.sandipbhattacharya.videoviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView mVideoListView;
    private VideoView mVideoView;
    private MediaController mMediaController;

    private int[] mVideoResources = {
            R.raw.sandip,
            R.raw.video1,
            R.raw.video2,
            R.raw.video3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        mVideoListView = findViewById(R.id.videoList);
        mVideoView = findViewById(R.id.videoView);

        // Set up media controller
        mMediaController = new MediaController(this);
        mMediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mMediaController);

        // Set up video list adapter
        VideoListAdapter videoListAdapter = new VideoListAdapter(this, mVideoResources);
        mVideoListView.setAdapter(videoListAdapter);

        // Set up video view
        mVideoView.setVideoPath("android.resource://" + getPackageName() + "/" + mVideoResources[0]);
        mVideoView.requestFocus();
        mVideoView.start();

        // Set up list item click listener
        mVideoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                mVideoView.setVideoPath("android.resource://" + getPackageName() + "/" + mVideoResources[position]);
                mVideoView.requestFocus();
                mVideoView.start();
            }
        });
    }
}