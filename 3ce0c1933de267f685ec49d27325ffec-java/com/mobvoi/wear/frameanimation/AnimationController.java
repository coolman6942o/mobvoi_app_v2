package com.mobvoi.wear.frameanimation;

import android.graphics.Matrix;
import com.mobvoi.wear.frameanimation.FrameAnimation;
import com.mobvoi.wear.frameanimation.io.BitmapPool;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy;
import java.util.List;
/* compiled from: AnimationController.kt */
/* loaded from: classes2.dex */
public interface AnimationController {
    void freezeLastFrame(boolean z10);

    boolean freezeLastFrame();

    BitmapPool getBitmapPool();

    int getFrameInterval();

    boolean isPlaying();

    void playAnimation(List<FrameAnimation.PathData> list);

    void playAnimation(List<FrameAnimation.PathData> list, int i10);

    void playAnimationFromAssets(String str);

    void playAnimationFromAssets(String str, int i10);

    void playAnimationFromFile(String str);

    void playAnimationFromFile(String str, int i10);

    void release();

    void setAnimationListener(FrameAnimation.FrameAnimationListener frameAnimationListener);

    void setBitmapPool(BitmapPool bitmapPool);

    void setFrameInterval(int i10);

    void setRepeatMode(FrameAnimation.RepeatMode repeatMode);

    void setRepeatMode(RepeatStrategy repeatStrategy);

    void setScaleType(Matrix matrix);

    void setScaleType(FrameAnimation.ScaleType scaleType);

    void setSupportInBitmap(boolean z10);

    int stopAnimation();

    int stopAnimationSafely();

    boolean supportInBitmap();
}
