package com.mobvoi.wear.frameanimation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.view.View;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.wear.frameanimation.FrameAnimation;
import com.mobvoi.wear.frameanimation.drawer.BitmapDrawer;
import com.mobvoi.wear.frameanimation.io.BitmapPool;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy;
import io.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FrameAnimation.kt */
/* loaded from: classes2.dex */
public final class FrameAnimation$draw$1 extends Lambda implements a<m> {
    final /* synthetic */ FrameAnimation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameAnimation$draw$1(FrameAnimation frameAnimation) {
        super(0);
        this.this$0 = frameAnimation;
    }

    @Override // qo.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z10;
        boolean z11;
        BitmapDrawer bitmapDrawer;
        boolean z12;
        BitmapPool bitmapPool;
        s sVar;
        int i10;
        View view;
        BitmapDrawer bitmapDrawer2;
        Matrix matrix;
        BitmapDrawer bitmapDrawer3;
        int i11;
        BitmapDrawer bitmapDrawer4;
        int i12;
        FrameAnimation.FrameAnimationListener frameAnimationListener;
        boolean z13;
        boolean z14;
        boolean z15;
        BitmapDrawer bitmapDrawer5;
        BitmapPool bitmapPool2;
        BitmapPool bitmapPool3;
        float f10;
        int i13;
        int i14;
        int i15;
        boolean z16 = true;
        while (true) {
            try {
                z12 = this.this$0.isPlaying;
                if (!z12 || !z16 || Thread.currentThread().isInterrupted()) {
                    break;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                bitmapPool = this.this$0.mBitmapPool;
                Bitmap take = bitmapPool.take();
                if (take == null) {
                    sVar = this.this$0.mHandler;
                    i10 = this.this$0.MSG_STOP;
                    sVar.sendEmptyMessage(i10);
                    z16 = false;
                } else {
                    FrameAnimation frameAnimation = this.this$0;
                    view = frameAnimation.mSurfaceView;
                    if (view == null) {
                        view = this.this$0.mTextureView;
                        i.d(view);
                    }
                    frameAnimation.configureDrawMatrix(take, view);
                    bitmapDrawer2 = this.this$0.mBitmapDrawer;
                    if (bitmapDrawer2 != null) {
                        matrix = this.this$0.mDrawMatrix;
                        Canvas draw = bitmapDrawer2.draw(take, matrix);
                        if (draw != null) {
                            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                            try {
                                i11 = this.this$0.frameInterval;
                                if (uptimeMillis2 < i11) {
                                    i15 = this.this$0.frameInterval;
                                    Thread.sleep(i15 - uptimeMillis2);
                                }
                                bitmapDrawer4 = this.this$0.mBitmapDrawer;
                                if (bitmapDrawer4 != null) {
                                    bitmapDrawer4.unlockAndPost(draw);
                                    FrameAnimation frameAnimation2 = this.this$0;
                                    i12 = frameAnimation2.drawIndex;
                                    frameAnimation2.drawIndex = i12 + 1;
                                    frameAnimationListener = this.this$0.animationListener;
                                    if (frameAnimationListener != null) {
                                        FrameAnimation frameAnimation3 = this.this$0;
                                        bitmapPool3 = frameAnimation3.mBitmapPool;
                                        RepeatStrategy repeatStrategy = bitmapPool3.getRepeatStrategy();
                                        if (repeatStrategy != null) {
                                            if (repeatStrategy.getTotalFrames() == FrameAnimation.Companion.getFRAMES_INFINITE()) {
                                                f10 = 0.0f;
                                            } else {
                                                i14 = frameAnimation3.drawIndex;
                                                f10 = i14 / repeatStrategy.getTotalFrames();
                                            }
                                            i13 = frameAnimation3.drawIndex;
                                            frameAnimationListener.onProgress(f10, i13, repeatStrategy.getTotalFrames());
                                        }
                                    }
                                    z13 = this.this$0.supportInBitmap;
                                    if (z13) {
                                        bitmapPool2 = this.this$0.mBitmapPool;
                                        bitmapPool2.recycle(take);
                                    }
                                    z14 = this.this$0.isPlaying;
                                    if (!z14) {
                                        z15 = this.this$0.freezeLastFrame;
                                        if (z15) {
                                            continue;
                                        } else {
                                            bitmapDrawer5 = this.this$0.mBitmapDrawer;
                                            if (bitmapDrawer5 != null) {
                                                bitmapDrawer5.clear();
                                            } else {
                                                i.u("mBitmapDrawer");
                                                throw null;
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    i.u("mBitmapDrawer");
                                    throw null;
                                }
                            } catch (InterruptedException e10) {
                                bitmapDrawer3 = this.this$0.mBitmapDrawer;
                                if (bitmapDrawer3 == null) {
                                    i.u("mBitmapDrawer");
                                    throw null;
                                } else {
                                    bitmapDrawer3.unlockAndPost(draw);
                                    throw e10;
                                }
                            }
                        }
                    } else {
                        i.u("mBitmapDrawer");
                        throw null;
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                z10 = this.this$0.freezeLastFrame;
                if (!z10 && !this.this$0.getTemporaryStop()) {
                    bitmapDrawer = this.this$0.mBitmapDrawer;
                    if (bitmapDrawer != null) {
                        bitmapDrawer.clear();
                    } else {
                        i.u("mBitmapDrawer");
                        throw null;
                    }
                }
                this.this$0.mayResetTemporaryStopSignal();
                z11 = this.this$0.relayDraw;
                if (z11) {
                    this.this$0.draw();
                    this.this$0.relayDraw = false;
                    return;
                }
                return;
            }
        }
    }
}
