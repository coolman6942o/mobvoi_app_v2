package com.mobvoi.wear.frameanimation.drawer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* compiled from: BitmapDrawer.kt */
/* loaded from: classes2.dex */
public interface BitmapDrawer {
    void clear();

    Canvas draw(Bitmap bitmap, Matrix matrix);

    void unlockAndPost(Canvas canvas);
}
