package com.khilman.www.youtubeapi;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    // ID dari Youtube cth https://www.youtube.com/watch?v=fqUWU246TEs
    String mYoutubeVideoId = "fqUWU246TEs";
    static String YOUTUBE_API = "AIzaSyCDJ0AX9wJmjVCYAR5pOJzrBBU4cnAlg74";


    // Youtube player
    YouTubePlayer mPlayer;
    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnStop)
    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        YouTubePlayerView playerView = (YouTubePlayerView) findViewById(R.id.youTubePlayer);
        //Inisialisasi API KEY YOU TUBE API
        playerView.initialize(YOUTUBE_API, this);

        // Play Video
//        mPlayer.play();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean restored) {
        // inisialisasi
        mPlayer = youTubePlayer;

        if (mYoutubeVideoId != null) {
            if (restored) {
                mPlayer.play();
            } else {
                mPlayer.loadVideo(mYoutubeVideoId);
            }
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @OnClick(R.id.btnPlay)
    public void onBtnPlayClicked() {
        mPlayer.play();
    }

    @OnClick(R.id.btnStop)
    public void onBtnStopClicked() {
        mPlayer.pause();
    }
}
