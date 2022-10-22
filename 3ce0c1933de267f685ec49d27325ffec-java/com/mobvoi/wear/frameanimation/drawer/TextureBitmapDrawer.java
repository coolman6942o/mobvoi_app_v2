package com.mobvoi.wear.frameanimation.drawer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.view.TextureView;
import kotlin.jvm.internal.i;
/* compiled from: TextureBitmapDrawer.kt */
/* loaded from: classes2.dex */
public final class TextureBitmapDrawer implements BitmapDrawer {
    private final TextureView mTextureView;

    public TextureBitmapDrawer(TextureView mTextureView) {
        i.f(mTextureView, "mTextureView");
        this.mTextureView = mTextureView;
        mTextureView.setOpaque(false);
        Canvas lockCanvas = mTextureView.lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        if (lockCanvas != null) {
            mTextureView.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // com.mobvoi.wear.frameanimation.drawer.BitmapDrawer
    public void clear() {
        Canvas lockCanvas = this.mTextureView.lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.mTextureView.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // com.mobvoi.wear.frameanimation.drawer.BitmapDrawer
    public Canvas draw(Bitmap bitmap, Matrix matrix) {
        Canvas lockCanvas;
        i.f(bitmap, "bitmap");
        i.f(matrix, "matrix");
        if (Thread.currentThread().isInterrupted() || (lockCanvas = this.mTextureView.lockCanvas()) == null) {
            return null;
        }
        lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        lockCanvas.drawBitmap(bitmap, matrix, null);
        return lockCanvas;
    }

    @Override // com.mobvoi.wear.frameanimation.drawer.BitmapDrawer
    public void unlockAndPost(Canvas canvas) {
        i.f(canvas, "canvas");
        this.mTextureView.unlockCanvasAndPost(canvas);
    }
}
