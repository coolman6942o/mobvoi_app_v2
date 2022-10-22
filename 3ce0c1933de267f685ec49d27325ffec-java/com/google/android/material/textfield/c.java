package com.google.android.material.textfield;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import w7.g;
import w7.k;
/* compiled from: CutoutDrawable.java */
/* loaded from: classes.dex */
class c extends g {
    private final RectF A;
    private int B;

    /* renamed from: z  reason: collision with root package name */
    private final Paint f11493z;

    c() {
        this(null);
    }

    private void o0(Canvas canvas) {
        if (!v0(getCallback())) {
            canvas.restoreToCount(this.B);
        }
    }

    private void p0(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (v0(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
                return;
            }
            return;
        }
        r0(canvas);
    }

    private void r0(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void u0() {
        this.f11493z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f11493z.setColor(-1);
        this.f11493z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean v0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // w7.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        p0(canvas);
        super.draw(canvas);
        o0(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n0() {
        return !this.A.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0() {
        s0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w7.g
    public void r(Canvas canvas) {
        if (this.A.isEmpty()) {
            super.r(canvas);
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.r(canvas2);
        canvas2.drawRect(this.A, this.f11493z);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
    }

    void s0(float f10, float f11, float f12, float f13) {
        RectF rectF = this.A;
        if (f10 != rectF.left || f11 != rectF.top || f12 != rectF.right || f13 != rectF.bottom) {
            rectF.set(f10, f11, f12, f13);
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t0(RectF rectF) {
        s0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(k kVar) {
        super(kVar == null ? new k() : kVar);
        this.f11493z = new Paint(1);
        u0();
        this.A = new RectF();
    }
}
