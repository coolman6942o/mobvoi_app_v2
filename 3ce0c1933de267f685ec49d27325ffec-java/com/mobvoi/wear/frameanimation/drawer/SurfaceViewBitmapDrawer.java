package com.mobvoi.wear.frameanimation.drawer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import kotlin.jvm.internal.i;
/* compiled from: SurfaceViewBitmapDrawer.kt */
/* loaded from: classes2.dex */
public final class SurfaceViewBitmapDrawer implements BitmapDrawer {
    private final SurfaceHolder mSurfaceHolder;
    private final SurfaceView mSurfaceView;

    public SurfaceViewBitmapDrawer(SurfaceView surfaceView) {
        i.f(surfaceView, "surfaceView");
        this.mSurfaceView = surfaceView;
        this.mSurfaceHolder = surfaceView.getHolder();
    }

    @Override // com.mobvoi.wear.frameanimation.drawer.BitmapDrawer
    public void clear() {
        Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // com.mobvoi.wear.frameanimation.drawer.BitmapDrawer
    public Canvas draw(Bitmap bitmap, Matrix matrix) {
        Canvas lockCanvas;
        i.f(bitmap, "bitmap");
        i.f(matrix, "matrix");
        if (Thread.currentThread().isInterrupted() || (lockCanvas = this.mSurfaceHolder.lockCanvas()) == null) {
            return null;
        }
        lockCanvas.drawColor(-16777216, PorterDuff.Mode.SRC_OVER);
        lockCanvas.drawBitmap(bitmap, matrix, null);
        return lockCanvas;
    }

    @Override // com.mobvoi.wear.frameanimation.drawer.BitmapDrawer
    public void unlockAndPost(Canvas canvas) {
        i.f(canvas, "canvas");
        this.mSurfaceHolder.unlockCanvasAndPost(canvas);
    }
}
