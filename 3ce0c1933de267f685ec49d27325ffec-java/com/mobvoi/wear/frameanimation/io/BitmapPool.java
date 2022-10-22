package com.mobvoi.wear.frameanimation.io;

import android.graphics.Bitmap;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy;
/* compiled from: BitmapPool.kt */
/* loaded from: classes2.dex */
public interface BitmapPool {
    RepeatStrategy getRepeatStrategy();

    void recycle(Bitmap bitmap);

    void release();

    void start(RepeatStrategy repeatStrategy, int i10);

    void stop();

    Bitmap take() throws InterruptedException;
}
