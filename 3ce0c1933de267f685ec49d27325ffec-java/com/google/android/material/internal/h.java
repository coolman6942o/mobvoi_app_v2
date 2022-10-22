package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
import t7.d;
import t7.f;
/* compiled from: TextDrawableHelper.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private float f11089c;

    /* renamed from: f  reason: collision with root package name */
    private d f11092f;

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f11087a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final f f11088b = new a();

    /* renamed from: d  reason: collision with root package name */
    private boolean f11090d = true;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<b> f11091e = new WeakReference<>(null);

    /* compiled from: TextDrawableHelper.java */
    /* loaded from: classes.dex */
    class a extends f {
        a() {
        }

        @Override // t7.f
        public void a(int i10) {
            h.this.f11090d = true;
            b bVar = (b) h.this.f11091e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // t7.f
        public void b(Typeface typeface, boolean z10) {
            if (!z10) {
                h.this.f11090d = true;
                b bVar = (b) h.this.f11091e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* compiled from: TextDrawableHelper.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f11087a.measureText(charSequence, 0, charSequence.length());
    }

    public d d() {
        return this.f11092f;
    }

    public TextPaint e() {
        return this.f11087a;
    }

    public float f(String str) {
        if (!this.f11090d) {
            return this.f11089c;
        }
        float c10 = c(str);
        this.f11089c = c10;
        this.f11090d = false;
        return c10;
    }

    public void g(b bVar) {
        this.f11091e = new WeakReference<>(bVar);
    }

    public void h(d dVar, Context context) {
        if (this.f11092f != dVar) {
            this.f11092f = dVar;
            if (dVar != null) {
                dVar.o(context, this.f11087a, this.f11088b);
                b bVar = this.f11091e.get();
                if (bVar != null) {
                    this.f11087a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f11087a, this.f11088b);
                this.f11090d = true;
            }
            b bVar2 = this.f11091e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z10) {
        this.f11090d = z10;
    }

    public void j(Context context) {
        this.f11092f.n(context, this.f11087a, this.f11088b);
    }
}
