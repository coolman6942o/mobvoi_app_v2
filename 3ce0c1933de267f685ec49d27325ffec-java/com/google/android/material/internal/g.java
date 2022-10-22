package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import j0.h;
import java.lang.reflect.Constructor;
/* compiled from: StaticLayoutBuilderCompat.java */
/* loaded from: classes.dex */
final class g {

    /* renamed from: n  reason: collision with root package name */
    static final int f11070n;

    /* renamed from: o  reason: collision with root package name */
    private static boolean f11071o;

    /* renamed from: p  reason: collision with root package name */
    private static Constructor<StaticLayout> f11072p;

    /* renamed from: q  reason: collision with root package name */
    private static Object f11073q;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f11074a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f11075b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11076c;

    /* renamed from: e  reason: collision with root package name */
    private int f11078e;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11085l;

    /* renamed from: d  reason: collision with root package name */
    private int f11077d = 0;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f11079f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g  reason: collision with root package name */
    private int f11080g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    private float f11081h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f11082i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f11083j = f11070n;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11084k = true;

    /* renamed from: m  reason: collision with root package name */
    private TextUtils.TruncateAt f11086m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticLayoutBuilderCompat.java */
    /* loaded from: classes.dex */
    public static class a extends Exception {
        a(Throwable th2) {
            super("Error thrown initializing StaticLayout " + th2.getMessage(), th2);
        }
    }

    static {
        f11070n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    private g(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f11074a = charSequence;
        this.f11075b = textPaint;
        this.f11076c = i10;
        this.f11078e = charSequence.length();
    }

    private void b() throws a {
        Class<?> cls;
        if (!f11071o) {
            try {
                boolean z10 = this.f11085l && Build.VERSION.SDK_INT >= 23;
                if (Build.VERSION.SDK_INT >= 18) {
                    cls = TextDirectionHeuristic.class;
                    f11073q = z10 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader classLoader = g.class.getClassLoader();
                    String str = this.f11085l ? "RTL" : "LTR";
                    Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                    Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                    f11073q = loadClass2.getField(str).get(loadClass2);
                    cls = loadClass;
                }
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
                f11072p = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f11071o = true;
            } catch (Exception e10) {
                throw new a(e10);
            }
        }
    }

    public static g c(CharSequence charSequence, TextPaint textPaint, int i10) {
        return new g(charSequence, textPaint, i10);
    }

    public StaticLayout a() throws a {
        if (this.f11074a == null) {
            this.f11074a = "";
        }
        int max = Math.max(0, this.f11076c);
        CharSequence charSequence = this.f11074a;
        if (this.f11080g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f11075b, max, this.f11086m);
        }
        int min = Math.min(charSequence.length(), this.f11078e);
        this.f11078e = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f11085l && this.f11080g == 1) {
                this.f11079f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f11077d, min, this.f11075b, max);
            obtain.setAlignment(this.f11079f);
            obtain.setIncludePad(this.f11084k);
            obtain.setTextDirection(this.f11085l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f11086m;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f11080g);
            float f10 = this.f11081h;
            if (!(f10 == 0.0f && this.f11082i == 1.0f)) {
                obtain.setLineSpacing(f10, this.f11082i);
            }
            if (this.f11080g > 1) {
                obtain.setHyphenationFrequency(this.f11083j);
            }
            return obtain.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) h.g(f11072p)).newInstance(charSequence, Integer.valueOf(this.f11077d), Integer.valueOf(this.f11078e), this.f11075b, Integer.valueOf(max), this.f11079f, h.g(f11073q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f11084k), null, Integer.valueOf(max), Integer.valueOf(this.f11080g));
        } catch (Exception e10) {
            throw new a(e10);
        }
    }

    public g d(Layout.Alignment alignment) {
        this.f11079f = alignment;
        return this;
    }

    public g e(TextUtils.TruncateAt truncateAt) {
        this.f11086m = truncateAt;
        return this;
    }

    public g f(int i10) {
        this.f11083j = i10;
        return this;
    }

    public g g(boolean z10) {
        this.f11084k = z10;
        return this;
    }

    public g h(boolean z10) {
        this.f11085l = z10;
        return this;
    }

    public g i(float f10, float f11) {
        this.f11081h = f10;
        this.f11082i = f11;
        return this;
    }

    public g j(int i10) {
        this.f11080g = i10;
        return this;
    }
}
