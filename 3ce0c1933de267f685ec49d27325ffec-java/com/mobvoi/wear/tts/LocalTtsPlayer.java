package com.mobvoi.wear.tts;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class LocalTtsPlayer extends UtteranceProgressListener implements TextToSpeech.OnInitListener, AudioManager.OnAudioFocusChangeListener {
    private static final boolean IS_OREO;
    private static final String KEY_MODE = "model";
    private static final String KEY_SPEAKER = "speaker";
    private static final String TAG = "LocalTtsPlayer";
    private int mAudioFocus;
    private final AudioManager mAudioManager;
    private final Context mContext;
    private AudioFocusRequest mFocusRequest;
    private final AtomicBoolean mInited;
    private String mMode;
    private String mSpeaker;
    private String mText;
    private final TextToSpeech mTextToSpeech;
    private String mUtteranceId;
    private UtteranceProgressListener mUtteranceListener;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Mode {
        public static final String MODE_OFFLINE = "OFFLINE";
        public static final String MODE_ONLINE = "ONLINE";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Speaker {
        public static final String TTS_SPEAKER_BILLY = "billy";
        public static final String TTS_SPEAKER_CISSY = "cissy";
        public static final String TTS_SPEAKER_LUCY = "lucy";
        public static final String TTS_SPEAKER_TINA = "tina";
    }

    static {
        IS_OREO = Build.VERSION.SDK_INT >= 26;
    }

    public LocalTtsPlayer(Context context) {
        this(context, TAG, null);
    }

    private void abandonAudioFocus() {
        AudioFocusRequest audioFocusRequest = this.mFocusRequest;
        if (audioFocusRequest != null) {
            this.mAudioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private void abandonAudioFocusPreOreo() {
        this.mAudioManager.abandonAudioFocus(this);
    }

    private void abandonFocus() {
        k.c(TAG, "abandonFocus = %s", Integer.valueOf(this.mAudioFocus));
        if (IS_OREO) {
            abandonAudioFocus();
        } else {
            abandonAudioFocusPreOreo();
        }
    }

    @TargetApi(26)
    private void requestAudioFocus() {
        AudioFocusRequest build = new AudioFocusRequest.Builder(4).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(1).build()).build();
        this.mFocusRequest = build;
        int requestAudioFocus = this.mAudioManager.requestAudioFocus(build);
        this.mAudioFocus = requestAudioFocus;
        k.c(TAG, "requestAudioFocus = %s", Integer.valueOf(requestAudioFocus));
    }

    private void requestAudioFocusPreOreo() {
        int requestAudioFocus = this.mAudioManager.requestAudioFocus(this, 3, 4);
        this.mAudioFocus = requestAudioFocus;
        k.c(TAG, "requestAudioFocusPreOreo = %s", Integer.valueOf(requestAudioFocus));
    }

    private void requestFocus() {
        k.c(TAG, "requestFocus = %s", Integer.valueOf(this.mAudioFocus));
        if (IS_OREO) {
            requestAudioFocus();
        } else {
            requestAudioFocusPreOreo();
        }
    }

    private void speak(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MODE, str2);
        bundle.putString(KEY_SPEAKER, str3);
        this.mTextToSpeech.speak(str, 0, bundle, this.mUtteranceId);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i10) {
        k.c(TAG, "onAudioFocusChange %s ", Integer.valueOf(i10));
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public void onDone(String str) {
        k.c(TAG, "tts done %s", str);
        abandonFocus();
        this.mTextToSpeech.shutdown();
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public void onError(String str) {
        k.c(TAG, "tts error %s", str);
        abandonFocus();
        this.mTextToSpeech.shutdown();
        Toast.makeText(this.mContext, R.string.tts_init_failed, 1).show();
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int i10) {
        boolean z10 = false;
        k.c(TAG, "tts init status %s", Integer.valueOf(i10));
        AtomicBoolean atomicBoolean = this.mInited;
        if (i10 == 0) {
            z10 = true;
        }
        atomicBoolean.set(z10);
        if (this.mInited.get()) {
            UtteranceProgressListener utteranceProgressListener = this.mUtteranceListener;
            if (utteranceProgressListener == null) {
                this.mTextToSpeech.setOnUtteranceProgressListener(this);
            } else {
                this.mTextToSpeech.setOnUtteranceProgressListener(utteranceProgressListener);
            }
            if (!TextUtils.isEmpty(this.mText)) {
                speak(this.mText, this.mMode, this.mSpeaker);
                return;
            }
            return;
        }
        Toast.makeText(this.mContext, R.string.tts_init_failed, 1).show();
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public void onStart(String str) {
        k.c(TAG, "tts start %s", str);
        requestFocus();
    }

    public void play(String str) {
        play(str, null, null);
    }

    public void release() {
        TextToSpeech textToSpeech = this.mTextToSpeech;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
    }

    public LocalTtsPlayer(Context context, UtteranceProgressListener utteranceProgressListener) {
        this(context, TAG, utteranceProgressListener);
    }

    public void play(String str, String str2, String str3) {
        if (this.mInited.get()) {
            speak(str, str2, str3);
            return;
        }
        this.mMode = str2;
        this.mSpeaker = str3;
        this.mText = str;
    }

    public LocalTtsPlayer(Context context, String str, UtteranceProgressListener utteranceProgressListener) {
        this.mInited = new AtomicBoolean(false);
        this.mUtteranceId = str;
        this.mUtteranceListener = utteranceProgressListener;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mAudioManager = (AudioManager) applicationContext.getSystemService("audio");
        this.mTextToSpeech = new TextToSpeech(applicationContext, this);
    }
}
