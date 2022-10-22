package com.mobvoi.wear.watchface;

import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class WatchFaceConstants {
    public static final String CATEGORY_COMPANION_CONFIGURATION = "com.google.android.wearable.watchface.category.COMPANION_CONFIGURATION";
    public static final String EXTRA_PEER_ID = "android.support.wearable.watchface.extra.PEER_ID";
    public static final String EXTRA_WATCH_FACE_COMPONENT = "android.support.wearable.watchface.extra.WATCH_FACE_COMPONENT";
    public static final int GONE = 8;
    public static final long INSTALLATION_DECAY_HALF_LIFE_MS;
    public static final int INVISIBLE = 4;
    public static final String KEY_WATCH_FACE_ACTIVITY = "KEY_WATCH_FACE_ACTIVITY";
    public static final String KEY_WATCH_FACE_CONFIG_ACTION_COMPANION = "KEY_WATCH_FACE_CONFIG_ACTION_COMPANION";
    public static final String KEY_WATCH_FACE_DISPLAYED_NAME = "KEY_WATCH_FACE_DISPLAYED_NAME";
    public static final String KEY_WATCH_FACE_PACKAGE = "KEY_WATCH_FACE_PACKAGE";
    public static final String KEY_WATCH_FACE_POSITION = "KEY_WATCH_FACE_POSITION";
    public static final String KEY_WATCH_FACE_PREVIEW = "KEY_WATCH_FACE_PREVIEW";
    public static final String KEY_WATCH_FACE_RANK = "KEY_WATCH_FACE_RANK";
    public static final String KEY_WATCH_FACE_VISIBILITY = "KEY_WATCH_FACE_VISIBILITY";
    public static final long USAGE_DECAY_HALF_LIFE_MS;
    public static final int VISIBLE = 0;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        INSTALLATION_DECAY_HALF_LIFE_MS = timeUnit.toMillis(3L);
        USAGE_DECAY_HALF_LIFE_MS = timeUnit.toMillis(14L);
    }
}
