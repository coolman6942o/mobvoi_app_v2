package com.mobvoi.wear.frameanimation;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.TextureView;
import com.mobvoi.wear.frameanimation.FrameAnimation;
import com.mobvoi.wear.frameanimation.io.BitmapPool;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: FrameAnimationView.kt */
/* loaded from: classes2.dex */
public final class FrameAnimationView extends TextureView implements AnimationController {
    private final FrameAnimation animation;
    private boolean autoRelease;
    private final LifeCircleHandler lifeCircleHandler;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameAnimationView(Context context) {
        this(context, null, 0, 6, null);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    private FrameAnimationView(Context context, AttributeSet attributeSet, int i10, FrameAnimation frameAnimation) {
        super(context, attributeSet, i10);
        this.animation = frameAnimation;
        frameAnimation.bindView(this);
        this.lifeCircleHandler = new LifeCircleHandler(frameAnimation);
        this.autoRelease = true;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void freezeLastFrame(boolean z10) {
        this.animation.freezeLastFrame(z10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public boolean freezeLastFrame() {
        return this.animation.freezeLastFrame();
    }

    public final boolean getAutoRelease() {
        return this.autoRelease;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public BitmapPool getBitmapPool() {
        return this.animation.getBitmapPool();
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public int getFrameInterval() {
        return this.animation.getFrameInterval();
    }

    public final boolean getRestoreEnable() {
        return this.lifeCircleHandler.getRestoreEnable();
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public boolean isPlaying() {
        return this.animation.isPlaying();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.autoRelease) {
            this.lifeCircleHandler.release();
        }
        super.onDetachedFromWindow();
    }

    public final void onPause() {
        this.lifeCircleHandler.pause();
    }

    public final void onResume() {
        this.lifeCircleHandler.resume();
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimation(List<FrameAnimation.PathData> paths) {
        i.f(paths, "paths");
        this.animation.playAnimation(paths);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimation(List<FrameAnimation.PathData> paths, int i10) {
        i.f(paths, "paths");
        this.animation.playAnimation(paths, i10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimationFromAssets(String assetsPath) {
        i.f(assetsPath, "assetsPath");
        this.animation.playAnimationFromAssets(assetsPath);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimationFromAssets(String assetsPath, int i10) {
        i.f(assetsPath, "assetsPath");
        this.animation.playAnimationFromAssets(assetsPath, i10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimationFromFile(String filePath) {
        i.f(filePath, "filePath");
        this.animation.playAnimationFromFile(filePath);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimationFromFile(String filePath, int i10) {
        i.f(filePath, "filePath");
        this.animation.playAnimationFromFile(filePath, i10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void release() {
        this.animation.release();
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setAnimationListener(FrameAnimation.FrameAnimationListener listener) {
        i.f(listener, "listener");
        this.animation.setAnimationListener(listener);
    }

    public final void setAutoRelease(boolean z10) {
        this.autoRelease = z10;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setBitmapPool(BitmapPool bitmapPool) {
        i.f(bitmapPool, "bitmapPool");
        this.animation.setBitmapPool(bitmapPool);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setFrameInterval(int i10) {
        this.animation.setFrameInterval(i10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setRepeatMode(FrameAnimation.RepeatMode repeatMode) {
        i.f(repeatMode, "repeatMode");
        this.animation.setRepeatMode(repeatMode);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setRepeatMode(RepeatStrategy repeatStrategy) {
        i.f(repeatStrategy, "repeatStrategy");
        this.animation.setRepeatMode(repeatStrategy);
    }

    public final void setRestoreEnable(boolean z10) {
        this.lifeCircleHandler.setRestoreEnable(z10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setScaleType(Matrix matrix) {
        i.f(matrix, "matrix");
        this.animation.setScaleType(matrix);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setScaleType(FrameAnimation.ScaleType scaleType) {
        i.f(scaleType, "scaleType");
        this.animation.setScaleType(scaleType);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setSupportInBitmap(boolean z10) {
        this.animation.setSupportInBitmap(z10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public int stopAnimation() {
        return this.animation.stopAnimation();
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public int stopAnimationSafely() {
        return this.animation.stopAnimationSafely();
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public boolean supportInBitmap() {
        return this.animation.supportInBitmap();
    }

    public /* synthetic */ FrameAnimationView(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameAnimationView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, new FrameAnimation(context));
        i.f(context, "context");
    }
}
