package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import d3.d;
import i3.i;
import java.util.Collections;
import java.util.List;
/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class e extends a {

    /* renamed from: x  reason: collision with root package name */
    private final d f6657x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar, Layer layer) {
        super(fVar, layer);
        d dVar = new d(fVar, this, new i("__container", layer.l(), false));
        this.f6657x = dVar;
        dVar.c(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void E(g3.d dVar, int i10, List<g3.d> list, g3.d dVar2) {
        this.f6657x.h(dVar, i10, list, dVar2);
    }

    @Override // com.airbnb.lottie.model.layer.a, d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        this.f6657x.e(rectF, this.f6636m, z10);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void u(Canvas canvas, Matrix matrix, int i10) {
        this.f6657x.g(canvas, matrix, i10);
    }
}
