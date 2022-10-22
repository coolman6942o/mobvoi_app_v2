package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import e3.a;
import e3.p;
import k3.h;
/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class c extends a {
    private a<ColorFilter, ColorFilter> A;

    /* renamed from: x  reason: collision with root package name */
    private final Paint f6654x = new c3.a(3);

    /* renamed from: y  reason: collision with root package name */
    private final Rect f6655y = new Rect();

    /* renamed from: z  reason: collision with root package name */
    private final Rect f6656z = new Rect();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f fVar, Layer layer) {
        super(fVar, layer);
    }

    private Bitmap K() {
        return this.f6637n.q(this.f6638o.k());
    }

    @Override // com.airbnb.lottie.model.layer.a, g3.e
    public <T> void d(T t10, l3.c<T> cVar) {
        super.d(t10, cVar);
        if (t10 != k.C) {
            return;
        }
        if (cVar == null) {
            this.A = null;
        } else {
            this.A = new p(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        Bitmap K = K();
        if (K != null) {
            rectF.set(0.0f, 0.0f, K.getWidth() * h.e(), K.getHeight() * h.e());
            this.f6636m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i10) {
        Bitmap K = K();
        if (K != null && !K.isRecycled()) {
            float e10 = h.e();
            this.f6654x.setAlpha(i10);
            a<ColorFilter, ColorFilter> aVar = this.A;
            if (aVar != null) {
                this.f6654x.setColorFilter(aVar.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f6655y.set(0, 0, K.getWidth(), K.getHeight());
            this.f6656z.set(0, 0, (int) (K.getWidth() * e10), (int) (K.getHeight() * e10));
            canvas.drawBitmap(K, this.f6655y, this.f6656z, this.f6654x);
            canvas.restore();
        }
    }
}
