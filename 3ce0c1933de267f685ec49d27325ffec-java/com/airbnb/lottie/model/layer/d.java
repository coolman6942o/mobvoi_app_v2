package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.f;
/* compiled from: NullLayer.java */
/* loaded from: classes.dex */
public class d extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(f fVar, Layer layer) {
        super(fVar, layer);
    }

    @Override // com.airbnb.lottie.model.layer.a, d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void u(Canvas canvas, Matrix matrix, int i10) {
    }
}
