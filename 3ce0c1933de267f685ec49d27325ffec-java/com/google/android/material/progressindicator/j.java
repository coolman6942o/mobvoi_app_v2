package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import com.google.android.material.progressindicator.b;
/* compiled from: IndeterminateDrawable.java */
/* loaded from: classes.dex */
public final class j<S extends b> extends g {

    /* renamed from: p  reason: collision with root package name */
    private h<S> f11254p;

    /* renamed from: q  reason: collision with root package name */
    private i<ObjectAnimator> f11255q;

    j(Context context, b bVar, h<S> hVar, i<ObjectAnimator> iVar) {
        super(context, bVar);
        w(hVar);
        v(iVar);
    }

    public static j<e> s(Context context, e eVar) {
        return new j<>(context, eVar, new c(eVar), new d(eVar));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f11254p.g(canvas, g());
            this.f11254p.c(canvas, this.f11245m);
            int i10 = 0;
            while (true) {
                i<ObjectAnimator> iVar = this.f11255q;
                int[] iArr = iVar.f11253c;
                if (i10 < iArr.length) {
                    h<S> hVar = this.f11254p;
                    Paint paint = this.f11245m;
                    float[] fArr = iVar.f11252b;
                    int i11 = i10 * 2;
                    hVar.b(canvas, paint, fArr[i11], fArr[i11 + 1], iArr[i10]);
                    i10++;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11254p.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11254p.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public boolean q(boolean z10, boolean z11, boolean z12) {
        boolean q5 = super.q(z10, z11, z12);
        if (!isRunning()) {
            this.f11255q.a();
        }
        float a10 = this.f11235c.a(this.f11233a.getContentResolver());
        if (z10 && (z12 || (Build.VERSION.SDK_INT <= 21 && a10 > 0.0f))) {
            this.f11255q.g();
        }
        return q5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i<ObjectAnimator> t() {
        return this.f11255q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h<S> u() {
        return this.f11254p;
    }

    void v(i<ObjectAnimator> iVar) {
        this.f11255q = iVar;
        iVar.e(this);
    }

    void w(h<S> hVar) {
        this.f11254p = hVar;
        hVar.f(this);
    }
}
