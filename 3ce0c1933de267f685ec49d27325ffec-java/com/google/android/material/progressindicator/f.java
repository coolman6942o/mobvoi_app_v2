package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.google.android.material.progressindicator.b;
import s0.c;
import s0.d;
import s0.e;
/* compiled from: DeterminateDrawable.java */
/* loaded from: classes.dex */
public final class f<S extends b> extends g {

    /* renamed from: u  reason: collision with root package name */
    private static final c<f> f11226u = new a("indicatorLevel");

    /* renamed from: p  reason: collision with root package name */
    private h<S> f11227p;

    /* renamed from: q  reason: collision with root package name */
    private final e f11228q;

    /* renamed from: r  reason: collision with root package name */
    private final d f11229r;

    /* renamed from: s  reason: collision with root package name */
    private float f11230s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f11231t = false;

    /* compiled from: DeterminateDrawable.java */
    /* loaded from: classes.dex */
    static class a extends c<f> {
        a(String str) {
            super(str);
        }

        /* renamed from: c */
        public float a(f fVar) {
            return fVar.w() * 10000.0f;
        }

        /* renamed from: d */
        public void b(f fVar, float f10) {
            fVar.y(f10 / 10000.0f);
        }
    }

    f(Context context, b bVar, h<S> hVar) {
        super(context, bVar);
        x(hVar);
        e eVar = new e();
        this.f11228q = eVar;
        eVar.d(1.0f);
        eVar.f(50.0f);
        d dVar = new d(this, f11226u);
        this.f11229r = dVar;
        dVar.p(eVar);
        m(1.0f);
    }

    public static f<e> u(Context context, e eVar) {
        return new f<>(context, eVar, new c(eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float w() {
        return this.f11230s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f10) {
        this.f11230s = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f11227p.g(canvas, g());
            this.f11227p.c(canvas, this.f11245m);
            this.f11227p.b(canvas, this.f11245m, 0.0f, w(), j7.a.a(this.f11234b.f11200c[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11227p.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11227p.e();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f11229r.q();
        y(getLevel() / 10000.0f);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        if (this.f11231t) {
            this.f11229r.q();
            y(i10 / 10000.0f);
            return true;
        }
        this.f11229r.h(w() * 10000.0f);
        this.f11229r.l(i10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public boolean q(boolean z10, boolean z11, boolean z12) {
        boolean q5 = super.q(z10, z11, z12);
        float a10 = this.f11235c.a(this.f11233a.getContentResolver());
        if (a10 == 0.0f) {
            this.f11231t = true;
        } else {
            this.f11231t = false;
            this.f11228q.f(50.0f / a10);
        }
        return q5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h<S> v() {
        return this.f11227p;
    }

    void x(h<S> hVar) {
        this.f11227p = hVar;
        hVar.f(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(float f10) {
        setLevel((int) (f10 * 10000.0f));
    }
}
