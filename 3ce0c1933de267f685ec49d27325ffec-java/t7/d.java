package t7;

import a0.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import d7.l;
/* compiled from: TextAppearance.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f35068a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35069b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35070c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35071d;

    /* renamed from: e  reason: collision with root package name */
    public final float f35072e;

    /* renamed from: f  reason: collision with root package name */
    public final float f35073f;

    /* renamed from: g  reason: collision with root package name */
    public final float f35074g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f35075h;

    /* renamed from: i  reason: collision with root package name */
    public final float f35076i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f35077j;

    /* renamed from: k  reason: collision with root package name */
    private float f35078k;

    /* renamed from: l  reason: collision with root package name */
    private final int f35079l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f35080m = false;

    /* renamed from: n  reason: collision with root package name */
    private Typeface f35081n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextAppearance.java */
    /* loaded from: classes.dex */
    public class a extends h.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f35082a;

        a(f fVar) {
            this.f35082a = fVar;
        }

        @Override // a0.h.d
        public void d(int i10) {
            d.this.f35080m = true;
            this.f35082a.a(i10);
        }

        @Override // a0.h.d
        public void e(Typeface typeface) {
            d dVar = d.this;
            dVar.f35081n = Typeface.create(typeface, dVar.f35070c);
            d.this.f35080m = true;
            this.f35082a.b(d.this.f35081n, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextAppearance.java */
    /* loaded from: classes.dex */
    public class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextPaint f35084a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f35085b;

        b(TextPaint textPaint, f fVar) {
            this.f35084a = textPaint;
            this.f35085b = fVar;
        }

        @Override // t7.f
        public void a(int i10) {
            this.f35085b.a(i10);
        }

        @Override // t7.f
        public void b(Typeface typeface, boolean z10) {
            d.this.p(this.f35084a, typeface);
            this.f35085b.b(typeface, z10);
        }
    }

    public d(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, l.f25480o5);
        l(obtainStyledAttributes.getDimension(l.f25488p5, 0.0f));
        k(c.a(context, obtainStyledAttributes, l.f25511s5));
        c.a(context, obtainStyledAttributes, l.f25519t5);
        c.a(context, obtainStyledAttributes, l.f25527u5);
        this.f35070c = obtainStyledAttributes.getInt(l.f25503r5, 0);
        this.f35071d = obtainStyledAttributes.getInt(l.q5, 1);
        int e10 = c.e(obtainStyledAttributes, l.A5, l.f25567z5);
        this.f35079l = obtainStyledAttributes.getResourceId(e10, 0);
        this.f35069b = obtainStyledAttributes.getString(e10);
        obtainStyledAttributes.getBoolean(l.B5, false);
        this.f35068a = c.a(context, obtainStyledAttributes, l.f25535v5);
        this.f35072e = obtainStyledAttributes.getFloat(l.f25543w5, 0.0f);
        this.f35073f = obtainStyledAttributes.getFloat(l.f25551x5, 0.0f);
        this.f35074g = obtainStyledAttributes.getFloat(l.f25559y5, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i10, l.f25486p3);
            int i11 = l.f25494q3;
            this.f35075h = obtainStyledAttributes2.hasValue(i11);
            this.f35076i = obtainStyledAttributes2.getFloat(i11, 0.0f);
            obtainStyledAttributes2.recycle();
            return;
        }
        this.f35075h = false;
        this.f35076i = 0.0f;
    }

    private void d() {
        String str;
        if (this.f35081n == null && (str = this.f35069b) != null) {
            this.f35081n = Typeface.create(str, this.f35070c);
        }
        if (this.f35081n == null) {
            int i10 = this.f35071d;
            if (i10 == 1) {
                this.f35081n = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f35081n = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f35081n = Typeface.DEFAULT;
            } else {
                this.f35081n = Typeface.MONOSPACE;
            }
            this.f35081n = Typeface.create(this.f35081n, this.f35070c);
        }
    }

    private boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i10 = this.f35079l;
        return (i10 != 0 ? h.c(context, i10) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f35081n;
    }

    public Typeface f(Context context) {
        if (this.f35080m) {
            return this.f35081n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface h10 = h.h(context, this.f35079l);
                this.f35081n = h10;
                if (h10 != null) {
                    this.f35081n = Typeface.create(h10, this.f35070c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f35069b, e10);
            }
        }
        d();
        this.f35080m = true;
        return this.f35081n;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i10 = this.f35079l;
        if (i10 == 0) {
            this.f35080m = true;
        }
        if (this.f35080m) {
            fVar.b(this.f35081n, true);
            return;
        }
        try {
            h.j(context, i10, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f35080m = true;
            fVar.a(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f35069b, e10);
            this.f35080m = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f35077j;
    }

    public float j() {
        return this.f35078k;
    }

    public void k(ColorStateList colorStateList) {
        this.f35077j = colorStateList;
    }

    public void l(float f10) {
        this.f35078k = f10;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f35077j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f10 = this.f35074g;
        float f11 = this.f35072e;
        float f12 = this.f35073f;
        ColorStateList colorStateList2 = this.f35068a;
        textPaint.setShadowLayer(f10, f11, f12, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i10 = (~typeface.getStyle()) & this.f35070c;
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f35078k);
        if (Build.VERSION.SDK_INT >= 21 && this.f35075h) {
            textPaint.setLetterSpacing(this.f35076i);
        }
    }
}
