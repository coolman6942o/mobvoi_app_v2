package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.d0;
import com.google.android.material.internal.g;
import i0.f;
import j0.h;
import t7.a;
import t7.d;
/* compiled from: CollapsingTextHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: k0  reason: collision with root package name */
    private static final boolean f11012k0;

    /* renamed from: l0  reason: collision with root package name */
    private static final Paint f11013l0;
    private t7.a A;
    private CharSequence B;
    private CharSequence C;
    private boolean D;
    private boolean F;
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private int[] K;
    private boolean L;
    private final TextPaint M;
    private final TextPaint N;
    private TimeInterpolator O;
    private TimeInterpolator P;
    private float Q;
    private float R;
    private float S;
    private ColorStateList T;
    private float U;
    private float V;
    private float W;
    private ColorStateList X;
    private float Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    private final View f11014a;

    /* renamed from: a0  reason: collision with root package name */
    private StaticLayout f11015a0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11016b;

    /* renamed from: b0  reason: collision with root package name */
    private float f11017b0;

    /* renamed from: c  reason: collision with root package name */
    private float f11018c;

    /* renamed from: c0  reason: collision with root package name */
    private float f11019c0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11020d;

    /* renamed from: d0  reason: collision with root package name */
    private float f11021d0;

    /* renamed from: e  reason: collision with root package name */
    private float f11022e;

    /* renamed from: e0  reason: collision with root package name */
    private float f11023e0;

    /* renamed from: f0  reason: collision with root package name */
    private CharSequence f11025f0;

    /* renamed from: g  reason: collision with root package name */
    private int f11026g;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f11038o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f11039p;

    /* renamed from: q  reason: collision with root package name */
    private float f11040q;

    /* renamed from: r  reason: collision with root package name */
    private float f11041r;

    /* renamed from: s  reason: collision with root package name */
    private float f11042s;

    /* renamed from: t  reason: collision with root package name */
    private float f11043t;

    /* renamed from: u  reason: collision with root package name */
    private float f11044u;

    /* renamed from: v  reason: collision with root package name */
    private float f11045v;

    /* renamed from: w  reason: collision with root package name */
    private Typeface f11046w;

    /* renamed from: x  reason: collision with root package name */
    private Typeface f11047x;

    /* renamed from: y  reason: collision with root package name */
    private Typeface f11048y;

    /* renamed from: z  reason: collision with root package name */
    private t7.a f11049z;

    /* renamed from: k  reason: collision with root package name */
    private int f11034k = 16;

    /* renamed from: l  reason: collision with root package name */
    private int f11035l = 16;

    /* renamed from: m  reason: collision with root package name */
    private float f11036m = 15.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f11037n = 15.0f;
    private boolean E = true;

    /* renamed from: g0  reason: collision with root package name */
    private int f11027g0 = 1;

    /* renamed from: h0  reason: collision with root package name */
    private float f11029h0 = 0.0f;

    /* renamed from: i0  reason: collision with root package name */
    private float f11031i0 = 1.0f;

    /* renamed from: j0  reason: collision with root package name */
    private int f11033j0 = g.f11070n;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f11030i = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private final Rect f11028h = new Rect();

    /* renamed from: j  reason: collision with root package name */
    private final RectF f11032j = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private float f11024f = e();

    /* compiled from: CollapsingTextHelper.java */
    /* renamed from: com.google.android.material.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0125a implements a.AbstractC0503a {
        C0125a() {
        }

        @Override // t7.a.AbstractC0503a
        public void a(Typeface typeface) {
            a.this.Q(typeface);
        }
    }

    static {
        f11012k0 = Build.VERSION.SDK_INT < 18;
        f11013l0 = null;
    }

    public a(View view) {
        this.f11014a = view;
        TextPaint textPaint = new TextPaint(129);
        this.M = textPaint;
        this.N = new TextPaint(textPaint);
    }

    private void A(float f10) {
        if (this.f11020d) {
            this.f11032j.set(f10 < this.f11024f ? this.f11028h : this.f11030i);
            return;
        }
        this.f11032j.left = F(this.f11028h.left, this.f11030i.left, f10, this.O);
        this.f11032j.top = F(this.f11040q, this.f11041r, f10, this.O);
        this.f11032j.right = F(this.f11028h.right, this.f11030i.right, f10, this.O);
        this.f11032j.bottom = F(this.f11028h.bottom, this.f11030i.bottom, f10, this.O);
    }

    private static boolean B(float f10, float f11) {
        return Math.abs(f10 - f11) < 0.001f;
    }

    private boolean C() {
        return d0.E(this.f11014a) == 1;
    }

    private boolean E(CharSequence charSequence, boolean z10) {
        return (z10 ? f.f28003d : f.f28002c).a(charSequence, 0, charSequence.length());
    }

    private static float F(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return e7.a.a(f10, f11, f12);
    }

    private static boolean J(Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    private void N(float f10) {
        this.f11019c0 = f10;
        d0.k0(this.f11014a);
    }

    private boolean R(Typeface typeface) {
        t7.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f11046w == typeface) {
            return false;
        }
        this.f11046w = typeface;
        return true;
    }

    private void U(float f10) {
        this.f11021d0 = f10;
        d0.k0(this.f11014a);
    }

    private boolean Y(Typeface typeface) {
        t7.a aVar = this.f11049z;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f11047x == typeface) {
            return false;
        }
        this.f11047x = typeface;
        return true;
    }

    private static int a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb((int) ((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), (int) ((Color.red(i10) * f11) + (Color.red(i11) * f10)), (int) ((Color.green(i10) * f11) + (Color.green(i11) * f10)), (int) ((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    private void a0(float f10) {
        h(f10);
        boolean z10 = f11012k0 && this.I != 1.0f;
        this.F = z10;
        if (z10) {
            n();
        }
        d0.k0(this.f11014a);
    }

    private void b(boolean z10) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        float f10 = this.J;
        i(this.f11037n, z10);
        CharSequence charSequence = this.C;
        if (!(charSequence == null || (staticLayout2 = this.f11015a0) == null)) {
            this.f11025f0 = TextUtils.ellipsize(charSequence, this.M, staticLayout2.getWidth(), TextUtils.TruncateAt.END);
        }
        float f11 = 0.0f;
        if (this.f11025f0 != null) {
            TextPaint textPaint = new TextPaint(this.M);
            if (Build.VERSION.SDK_INT >= 21) {
                textPaint.setLetterSpacing(this.Y);
            }
            CharSequence charSequence2 = this.f11025f0;
            this.f11017b0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f11017b0 = 0.0f;
        }
        int b10 = androidx.core.view.f.b(this.f11035l, this.D ? 1 : 0);
        int i10 = b10 & 112;
        if (i10 == 48) {
            this.f11041r = this.f11030i.top;
        } else if (i10 != 80) {
            this.f11041r = this.f11030i.centerY() - ((this.M.descent() - this.M.ascent()) / 2.0f);
        } else {
            this.f11041r = this.f11030i.bottom + this.M.ascent();
        }
        int i11 = b10 & 8388615;
        if (i11 == 1) {
            this.f11043t = this.f11030i.centerX() - (this.f11017b0 / 2.0f);
        } else if (i11 != 5) {
            this.f11043t = this.f11030i.left;
        } else {
            this.f11043t = this.f11030i.right - this.f11017b0;
        }
        i(this.f11036m, z10);
        float height = this.f11015a0 != null ? staticLayout.getHeight() : 0.0f;
        StaticLayout staticLayout3 = this.f11015a0;
        if (staticLayout3 != null) {
            staticLayout3.getLineCount();
        }
        CharSequence charSequence3 = this.C;
        float measureText = charSequence3 != null ? this.M.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout4 = this.f11015a0;
        if (staticLayout4 != null && this.f11027g0 > 1) {
            measureText = staticLayout4.getWidth();
        }
        StaticLayout staticLayout5 = this.f11015a0;
        if (staticLayout5 != null) {
            f11 = this.f11027g0 > 1 ? staticLayout5.getLineStart(0) : staticLayout5.getLineLeft(0);
        }
        this.f11023e0 = f11;
        int b11 = androidx.core.view.f.b(this.f11034k, this.D ? 1 : 0);
        int i12 = b11 & 112;
        if (i12 == 48) {
            this.f11040q = this.f11028h.top;
        } else if (i12 != 80) {
            this.f11040q = this.f11028h.centerY() - (height / 2.0f);
        } else {
            this.f11040q = (this.f11028h.bottom - height) + this.M.descent();
        }
        int i13 = b11 & 8388615;
        if (i13 == 1) {
            this.f11042s = this.f11028h.centerX() - (measureText / 2.0f);
        } else if (i13 != 5) {
            this.f11042s = this.f11028h.left;
        } else {
            this.f11042s = this.f11028h.right - measureText;
        }
        j();
        a0(f10);
    }

    private void c() {
        g(this.f11018c);
    }

    private float d(float f10) {
        float f11 = this.f11024f;
        if (f10 <= f11) {
            return e7.a.b(1.0f, 0.0f, this.f11022e, f11, f10);
        }
        return e7.a.b(0.0f, 1.0f, f11, 1.0f, f10);
    }

    private float e() {
        float f10 = this.f11022e;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    private boolean f(CharSequence charSequence) {
        boolean C = C();
        return this.E ? E(charSequence, C) : C;
    }

    private void g(float f10) {
        float f11;
        A(f10);
        if (!this.f11020d) {
            this.f11044u = F(this.f11042s, this.f11043t, f10, this.O);
            this.f11045v = F(this.f11040q, this.f11041r, f10, this.O);
            a0(F(this.f11036m, this.f11037n, f10, this.P));
            f11 = f10;
        } else if (f10 < this.f11024f) {
            this.f11044u = this.f11042s;
            this.f11045v = this.f11040q;
            a0(this.f11036m);
            f11 = 0.0f;
        } else {
            this.f11044u = this.f11043t;
            this.f11045v = this.f11041r - Math.max(0, this.f11026g);
            a0(this.f11037n);
            f11 = 1.0f;
        }
        TimeInterpolator timeInterpolator = e7.a.f25834b;
        N(1.0f - F(0.0f, 1.0f, 1.0f - f10, timeInterpolator));
        U(F(1.0f, 0.0f, f10, timeInterpolator));
        if (this.f11039p != this.f11038o) {
            this.M.setColor(a(v(), t(), f11));
        } else {
            this.M.setColor(t());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f12 = this.Y;
            float f13 = this.Z;
            if (f12 != f13) {
                this.M.setLetterSpacing(F(f13, f12, f10, timeInterpolator));
            } else {
                this.M.setLetterSpacing(f12);
            }
        }
        this.M.setShadowLayer(F(this.U, this.Q, f10, null), F(this.V, this.R, f10, null), F(this.W, this.S, f10, null), a(u(this.X), u(this.T), f10));
        if (this.f11020d) {
            this.M.setAlpha((int) (d(f10) * this.M.getAlpha()));
        }
        d0.k0(this.f11014a);
    }

    private boolean g0() {
        return this.f11027g0 > 1 && (!this.D || this.f11020d) && !this.F;
    }

    private void h(float f10) {
        i(f10, false);
    }

    private void i(float f10, boolean z10) {
        boolean z11;
        float f11;
        boolean z12;
        if (this.B != null) {
            float width = this.f11030i.width();
            float width2 = this.f11028h.width();
            boolean z13 = false;
            int i10 = 1;
            if (B(f10, this.f11037n)) {
                f11 = this.f11037n;
                this.I = 1.0f;
                Typeface typeface = this.f11048y;
                Typeface typeface2 = this.f11046w;
                if (typeface != typeface2) {
                    this.f11048y = typeface2;
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                float f12 = this.f11036m;
                Typeface typeface3 = this.f11048y;
                Typeface typeface4 = this.f11047x;
                if (typeface3 != typeface4) {
                    this.f11048y = typeface4;
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (B(f10, f12)) {
                    this.I = 1.0f;
                } else {
                    this.I = f10 / this.f11036m;
                }
                float f13 = this.f11037n / this.f11036m;
                width = (!z10 && width2 * f13 > width) ? Math.min(width / f13, width2) : width2;
                f11 = f12;
                z11 = z12;
            }
            if (width > 0.0f) {
                z11 = this.J != f11 || this.L || z11;
                this.J = f11;
                this.L = false;
            }
            if (this.C == null || z11) {
                this.M.setTextSize(this.J);
                this.M.setTypeface(this.f11048y);
                TextPaint textPaint = this.M;
                if (this.I != 1.0f) {
                    z13 = true;
                }
                textPaint.setLinearText(z13);
                this.D = f(this.B);
                if (g0()) {
                    i10 = this.f11027g0;
                }
                StaticLayout k10 = k(i10, width, this.D);
                this.f11015a0 = k10;
                this.C = k10.getText();
            }
        }
    }

    private void j() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    private StaticLayout k(int i10, float f10, boolean z10) {
        StaticLayout staticLayout;
        try {
            staticLayout = g.c(this.B, this.M, (int) f10).e(TextUtils.TruncateAt.END).h(z10).d(Layout.Alignment.ALIGN_NORMAL).g(false).j(i10).i(this.f11029h0, this.f11031i0).f(this.f11033j0).a();
        } catch (g.a e10) {
            Log.e("CollapsingTextHelper", e10.getCause().getMessage(), e10);
            staticLayout = null;
        }
        return (StaticLayout) h.g(staticLayout);
    }

    private void m(Canvas canvas, float f10, float f11) {
        int alpha = this.M.getAlpha();
        canvas.translate(f10, f11);
        float f12 = alpha;
        this.M.setAlpha((int) (this.f11021d0 * f12));
        this.f11015a0.draw(canvas);
        this.M.setAlpha((int) (this.f11019c0 * f12));
        int lineBaseline = this.f11015a0.getLineBaseline(0);
        CharSequence charSequence = this.f11025f0;
        float f13 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, this.M);
        if (!this.f11020d) {
            String trim = this.f11025f0.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.M.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f11015a0.getLineEnd(0), str.length()), 0.0f, f13, (Paint) this.M);
        }
    }

    private void n() {
        if (this.G == null && !this.f11028h.isEmpty() && !TextUtils.isEmpty(this.C)) {
            g(0.0f);
            int width = this.f11015a0.getWidth();
            int height = this.f11015a0.getHeight();
            if (width > 0 && height > 0) {
                this.G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f11015a0.draw(new Canvas(this.G));
                if (this.H == null) {
                    this.H = new Paint(3);
                }
            }
        }
    }

    private float r(int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (i10 / 2.0f) - (this.f11017b0 / 2.0f);
        }
        return ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) ? this.D ? this.f11030i.left : this.f11030i.right - this.f11017b0 : this.D ? this.f11030i.right - this.f11017b0 : this.f11030i.left;
    }

    private float s(RectF rectF, int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (i10 / 2.0f) + (this.f11017b0 / 2.0f);
        }
        return ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) ? this.D ? rectF.left + this.f11017b0 : this.f11030i.right : this.D ? this.f11030i.right : rectF.left + this.f11017b0;
    }

    private int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.K;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private int v() {
        return u(this.f11038o);
    }

    private void y(TextPaint textPaint) {
        textPaint.setTextSize(this.f11037n);
        textPaint.setTypeface(this.f11046w);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Y);
        }
    }

    private void z(TextPaint textPaint) {
        textPaint.setTextSize(this.f11036m);
        textPaint.setTypeface(this.f11047x);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Z);
        }
    }

    public final boolean D() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f11039p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f11038o) != null && colorStateList.isStateful());
    }

    void G() {
        this.f11016b = this.f11030i.width() > 0 && this.f11030i.height() > 0 && this.f11028h.width() > 0 && this.f11028h.height() > 0;
    }

    public void H() {
        I(false);
    }

    public void I(boolean z10) {
        if ((this.f11014a.getHeight() > 0 && this.f11014a.getWidth() > 0) || z10) {
            b(z10);
            c();
        }
    }

    public void K(int i10, int i11, int i12, int i13) {
        if (!J(this.f11030i, i10, i11, i12, i13)) {
            this.f11030i.set(i10, i11, i12, i13);
            this.L = true;
            G();
        }
    }

    public void L(Rect rect) {
        K(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void M(int i10) {
        d dVar = new d(this.f11014a.getContext(), i10);
        if (dVar.i() != null) {
            this.f11039p = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f11037n = dVar.j();
        }
        ColorStateList colorStateList = dVar.f35068a;
        if (colorStateList != null) {
            this.T = colorStateList;
        }
        this.R = dVar.f35072e;
        this.S = dVar.f35073f;
        this.Q = dVar.f35074g;
        this.Y = dVar.f35076i;
        t7.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        this.A = new t7.a(new C0125a(), dVar.e());
        dVar.h(this.f11014a.getContext(), this.A);
        H();
    }

    public void O(ColorStateList colorStateList) {
        if (this.f11039p != colorStateList) {
            this.f11039p = colorStateList;
            H();
        }
    }

    public void P(int i10) {
        if (this.f11035l != i10) {
            this.f11035l = i10;
            H();
        }
    }

    public void Q(Typeface typeface) {
        if (R(typeface)) {
            H();
        }
    }

    public void S(int i10, int i11, int i12, int i13) {
        if (!J(this.f11028h, i10, i11, i12, i13)) {
            this.f11028h.set(i10, i11, i12, i13);
            this.L = true;
            G();
        }
    }

    public void T(Rect rect) {
        S(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void V(ColorStateList colorStateList) {
        if (this.f11038o != colorStateList) {
            this.f11038o = colorStateList;
            H();
        }
    }

    public void W(int i10) {
        if (this.f11034k != i10) {
            this.f11034k = i10;
            H();
        }
    }

    public void X(float f10) {
        if (this.f11036m != f10) {
            this.f11036m = f10;
            H();
        }
    }

    public void Z(float f10) {
        float a10 = e0.a.a(f10, 0.0f, 1.0f);
        if (a10 != this.f11018c) {
            this.f11018c = a10;
            c();
        }
    }

    public void b0(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        H();
    }

    public final boolean c0(int[] iArr) {
        this.K = iArr;
        if (!D()) {
            return false;
        }
        H();
        return true;
    }

    public void d0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.B, charSequence)) {
            this.B = charSequence;
            this.C = null;
            j();
            H();
        }
    }

    public void e0(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        H();
    }

    public void f0(Typeface typeface) {
        boolean R = R(typeface);
        boolean Y = Y(typeface);
        if (R || Y) {
            H();
        }
    }

    public void l(Canvas canvas) {
        int save = canvas.save();
        if (this.C != null && this.f11016b) {
            boolean z10 = true;
            float lineStart = (this.f11044u + (this.f11027g0 > 1 ? this.f11015a0.getLineStart(0) : this.f11015a0.getLineLeft(0))) - (this.f11023e0 * 2.0f);
            this.M.setTextSize(this.J);
            float f10 = this.f11044u;
            float f11 = this.f11045v;
            if (!this.F || this.G == null) {
                z10 = false;
            }
            float f12 = this.I;
            if (f12 != 1.0f && !this.f11020d) {
                canvas.scale(f12, f12, f10, f11);
            }
            if (z10) {
                canvas.drawBitmap(this.G, f10, f11, this.H);
                canvas.restoreToCount(save);
                return;
            }
            if (!g0() || (this.f11020d && this.f11018c <= this.f11024f)) {
                canvas.translate(f10, f11);
                this.f11015a0.draw(canvas);
            } else {
                m(canvas, lineStart, f11);
            }
            canvas.restoreToCount(save);
        }
    }

    public void o(RectF rectF, int i10, int i11) {
        this.D = f(this.B);
        rectF.left = r(i10, i11);
        rectF.top = this.f11030i.top;
        rectF.right = s(rectF, i10, i11);
        rectF.bottom = this.f11030i.top + q();
    }

    public ColorStateList p() {
        return this.f11039p;
    }

    public float q() {
        y(this.N);
        return -this.N.ascent();
    }

    public int t() {
        return u(this.f11039p);
    }

    public float w() {
        z(this.N);
        return -this.N.ascent();
    }

    public float x() {
        return this.f11018c;
    }
}
