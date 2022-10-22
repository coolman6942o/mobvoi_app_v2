package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.k;
import e3.a;
import e3.p;
import l3.c;
/* compiled from: SolidLayer.java */
/* loaded from: classes.dex */
public class f extends a {
    private final Layer B;
    private a<ColorFilter, ColorFilter> C;

    /* renamed from: y  reason: collision with root package name */
    private final Paint f6659y;

    /* renamed from: x  reason: collision with root package name */
    private final RectF f6658x = new RectF();

    /* renamed from: z  reason: collision with root package name */
    private final float[] f6660z = new float[8];
    private final Path A = new Path();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        c3.a aVar = new c3.a();
        this.f6659y = aVar;
        this.B = layer;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(layer.m());
    }

    @Override // com.airbnb.lottie.model.layer.a, g3.e
    public <T> void d(T t10, c<T> cVar) {
        super.d(t10, cVar);
        if (t10 != k.C) {
            return;
        }
        if (cVar == null) {
            this.C = null;
        } else {
            this.C = new p(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        this.f6658x.set(0.0f, 0.0f, this.B.o(), this.B.n());
        this.f6636m.mapRect(this.f6658x);
        rectF.set(this.f6658x);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i10) {
        int alpha = Color.alpha(this.B.m());
        if (alpha != 0) {
            int intValue = (int) ((i10 / 255.0f) * (((alpha / 255.0f) * (this.f6645v.h() == null ? 100 : this.f6645v.h().h().intValue())) / 100.0f) * 255.0f);
            this.f6659y.setAlpha(intValue);
            a<ColorFilter, ColorFilter> aVar = this.C;
            if (aVar != null) {
                this.f6659y.setColorFilter(aVar.h());
            }
            if (intValue > 0) {
                float[] fArr = this.f6660z;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = this.B.o();
                float[] fArr2 = this.f6660z;
                fArr2[3] = 0.0f;
                fArr2[4] = this.B.o();
                this.f6660z[5] = this.B.n();
                float[] fArr3 = this.f6660z;
                fArr3[6] = 0.0f;
                fArr3[7] = this.B.n();
                matrix.mapPoints(this.f6660z);
                this.A.reset();
                Path path = this.A;
                float[] fArr4 = this.f6660z;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.A;
                float[] fArr5 = this.f6660z;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.A;
                float[] fArr6 = this.f6660z;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.A;
                float[] fArr7 = this.f6660z;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.A;
                float[] fArr8 = this.f6660z;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.A.close();
                canvas.drawPath(this.A, this.f6659y);
            }
        }
    }
}
