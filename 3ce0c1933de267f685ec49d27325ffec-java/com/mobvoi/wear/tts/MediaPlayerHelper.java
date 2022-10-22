package com.mobvoi.wear.tts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.R;
import com.mobvoi.wear.util.ConnectionUtils;
/* loaded from: classes2.dex */
public class MediaPlayerHelper implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, AudioManager.OnAudioFocusChangeListener {
    public static final String TAG = "TodoMediaPlayer";
    private AudioManager mAudioManager;
    private Context mContext;
    private MediaPlayer mPlayer;
    private int mStreamType;

    public MediaPlayerHelper(Context context, int i10) {
        this.mStreamType = i10;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
        this.mAudioManager = audioManager;
        int streamMaxVolume = audioManager.getStreamMaxVolume(i10);
        int streamVolume = this.mAudioManager.getStreamVolume(i10);
        if (streamMaxVolume < streamVolume) {
            this.mAudioManager.setStreamVolume(i10, streamVolume, 1);
        }
        ensurePlayer();
    }

    private void ensurePlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.mPlayer = mediaPlayer2;
            mediaPlayer2.setAudioStreamType(this.mStreamType);
            this.mPlayer.setOnCompletionListener(this);
            this.mPlayer.setOnPreparedListener(this);
            return;
        }
        mediaPlayer.reset();
    }

    private void releasePlayer() {
        if (this.mPlayer != null) {
            this.mAudioManager.abandonAudioFocus(this);
            this.mPlayer.release();
            this.mPlayer = null;
        }
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i10) {
        if (i10 == -3 || i10 == -2 || i10 == -1) {
            k.a(TAG, "tts player loss audio focus & quite");
            stop();
        } else if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            k.a(TAG, "tts player gain audio focus");
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        k.a(TAG, "tts player onCompletion");
        this.mPlayer = null;
        ((AudioManager) this.mContext.getSystemService("audio")).abandonAudioFocus(this);
        mediaPlayer.release();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        k.a(TAG, "tts player start playing");
        mediaPlayer.start();
    }

    @SuppressLint({"MissingPermission"})
    public synchronized void play(String str, Handler handler) {
        if (ConnectionUtils.isNetworkAvailable(this.mContext)) {
            k.c(TAG, "play tts url %s", str);
            ensurePlayer();
            try {
                this.mAudioManager.requestAudioFocus(this, this.mStreamType, 2);
                this.mPlayer.setDataSource(str);
                k.a(TAG, "tts player start prepare");
                this.mPlayer.prepareAsync();
            } catch (Exception e10) {
                Log.e(TAG, " playMedia error" + e10.toString());
                Toast.makeText(this.mContext, R.string.tts_error, 0).show();
                stop();
            }
        }
    }

    public synchronized void stop() {
        k.a(TAG, "stop play tts");
        releasePlayer();
    }

    public synchronized void play(String str) {
        k.c(TAG, "play tts file %s", str);
        ensurePlayer();
        try {
            this.mAudioManager.requestAudioFocus(this, this.mStreamType, 2);
            this.mPlayer.setDataSource(str);
            k.a(TAG, "tts player start prepare");
            this.mPlayer.prepareAsync();
        } catch (Exception e10) {
            Log.e(TAG, " playMedia error", e10);
            Toast.makeText(this.mContext, R.string.tts_error, 0).show();
            stop();
        }
    }
}
