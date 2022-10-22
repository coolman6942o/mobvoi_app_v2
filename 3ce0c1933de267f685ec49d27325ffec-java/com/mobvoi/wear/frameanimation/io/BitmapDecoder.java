package com.mobvoi.wear.frameanimation.io;

import android.graphics.Bitmap;
import com.mobvoi.wear.frameanimation.FrameAnimation;
/* compiled from: BitmapDecoder.kt */
/* loaded from: classes2.dex */
public interface BitmapDecoder {
    Bitmap decodeBitmap(FrameAnimation.PathData pathData);

    Bitmap decodeBitmap(FrameAnimation.PathData pathData, Bitmap bitmap);
}
