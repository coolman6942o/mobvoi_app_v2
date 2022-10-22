package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.internal.h;
import com.google.android.material.internal.k;
import com.google.android.material.internal.m;
import d7.l;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import t7.c;
import t7.d;
import u7.b;
import w7.g;
/* compiled from: ChipDrawable.java */
/* loaded from: classes.dex */
public class a extends g implements Drawable.Callback, h.b {
    private static final int[] V0 = {16842910};
    private static final ShapeDrawable W0 = new ShapeDrawable(new OvalShape());
    private ColorStateList A;
    private int A0;
    private float B;
    private int B0;
    private int C0;
    private ColorStateList D;
    private int D0;
    private float E;
    private int E0;
    private ColorStateList F;
    private int F0;
    private boolean G0;
    private boolean H;
    private int H0;
    private Drawable I;
    private ColorStateList J;
    private ColorFilter J0;
    private float K;
    private PorterDuffColorFilter K0;
    private boolean L;
    private ColorStateList L0;
    private boolean M;
    private Drawable N;
    private int[] N0;
    private Drawable O;
    private boolean O0;
    private ColorStateList P;
    private ColorStateList P0;
    private float Q;
    private CharSequence R;
    private TextUtils.TruncateAt R0;
    private boolean S;
    private boolean T;
    private int T0;
    private Drawable U;
    private boolean U0;
    private ColorStateList V;
    private e7.h W;

    /* renamed from: j0  reason: collision with root package name */
    private e7.h f10696j0;

    /* renamed from: k0  reason: collision with root package name */
    private float f10697k0;

    /* renamed from: l0  reason: collision with root package name */
    private float f10698l0;

    /* renamed from: m0  reason: collision with root package name */
    private float f10699m0;

    /* renamed from: n0  reason: collision with root package name */
    private float f10700n0;

    /* renamed from: o0  reason: collision with root package name */
    private float f10701o0;

    /* renamed from: p0  reason: collision with root package name */
    private float f10702p0;

    /* renamed from: q0  reason: collision with root package name */
    private float f10703q0;

    /* renamed from: r0  reason: collision with root package name */
    private float f10704r0;

    /* renamed from: s0  reason: collision with root package name */
    private final Context f10705s0;

    /* renamed from: z  reason: collision with root package name */
    private ColorStateList f10712z;

    /* renamed from: z0  reason: collision with root package name */
    private final h f10713z0;
    private float C = -1.0f;

    /* renamed from: t0  reason: collision with root package name */
    private final Paint f10706t0 = new Paint(1);

    /* renamed from: v0  reason: collision with root package name */
    private final Paint.FontMetrics f10708v0 = new Paint.FontMetrics();

    /* renamed from: w0  reason: collision with root package name */
    private final RectF f10709w0 = new RectF();

    /* renamed from: x0  reason: collision with root package name */
    private final PointF f10710x0 = new PointF();

    /* renamed from: y0  reason: collision with root package name */
    private final Path f10711y0 = new Path();
    private int I0 = 255;
    private PorterDuff.Mode M0 = PorterDuff.Mode.SRC_IN;
    private WeakReference<AbstractC0121a> Q0 = new WeakReference<>(null);
    private CharSequence G = "";

    /* renamed from: u0  reason: collision with root package name */
    private final Paint f10707u0 = null;
    private boolean S0 = true;

    /* compiled from: ChipDrawable.java */
    /* renamed from: com.google.android.material.chip.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0121a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        O(context);
        this.f10705s0 = context;
        h hVar = new h(this);
        this.f10713z0 = hVar;
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        int[] iArr = V0;
        setState(iArr);
        o2(iArr);
        if (b.f35338a) {
            W0.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        if (!this.U0) {
            this.f10706t0.setColor(this.B0);
            this.f10706t0.setStyle(Paint.Style.FILL);
            this.f10706t0.setColorFilter(o1());
            this.f10709w0.set(rect);
            canvas.drawRoundRect(this.f10709w0, L0(), L0(), this.f10706t0);
        }
    }

    private void B0(Canvas canvas, Rect rect) {
        if (Q2()) {
            o0(rect, this.f10709w0);
            RectF rectF = this.f10709w0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.I.setBounds(0, 0, (int) this.f10709w0.width(), (int) this.f10709w0.height());
            this.I.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    private void C0(Canvas canvas, Rect rect) {
        if (this.E > 0.0f && !this.U0) {
            this.f10706t0.setColor(this.D0);
            this.f10706t0.setStyle(Paint.Style.STROKE);
            if (!this.U0) {
                this.f10706t0.setColorFilter(o1());
            }
            RectF rectF = this.f10709w0;
            float f10 = this.E;
            rectF.set(rect.left + (f10 / 2.0f), rect.top + (f10 / 2.0f), rect.right - (f10 / 2.0f), rect.bottom - (f10 / 2.0f));
            float f11 = this.C - (this.E / 2.0f);
            canvas.drawRoundRect(this.f10709w0, f11, f11, this.f10706t0);
        }
    }

    private void D0(Canvas canvas, Rect rect) {
        if (!this.U0) {
            this.f10706t0.setColor(this.A0);
            this.f10706t0.setStyle(Paint.Style.FILL);
            this.f10709w0.set(rect);
            canvas.drawRoundRect(this.f10709w0, L0(), L0(), this.f10706t0);
        }
    }

    private void E0(Canvas canvas, Rect rect) {
        if (R2()) {
            r0(rect, this.f10709w0);
            RectF rectF = this.f10709w0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.N.setBounds(0, 0, (int) this.f10709w0.width(), (int) this.f10709w0.height());
            if (b.f35338a) {
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                this.O.draw(canvas);
            } else {
                this.N.draw(canvas);
            }
            canvas.translate(-f10, -f11);
        }
    }

    private void F0(Canvas canvas, Rect rect) {
        this.f10706t0.setColor(this.E0);
        this.f10706t0.setStyle(Paint.Style.FILL);
        this.f10709w0.set(rect);
        if (!this.U0) {
            canvas.drawRoundRect(this.f10709w0, L0(), L0(), this.f10706t0);
            return;
        }
        h(new RectF(rect), this.f10711y0);
        super.p(canvas, this.f10706t0, this.f10711y0, u());
    }

    private void G0(Canvas canvas, Rect rect) {
        Paint paint = this.f10707u0;
        if (paint != null) {
            paint.setColor(b0.a.j(-16777216, 127));
            canvas.drawRect(rect, this.f10707u0);
            if (Q2() || P2()) {
                o0(rect, this.f10709w0);
                canvas.drawRect(this.f10709w0, this.f10707u0);
            }
            if (this.G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f10707u0);
            }
            if (R2()) {
                r0(rect, this.f10709w0);
                canvas.drawRect(this.f10709w0, this.f10707u0);
            }
            this.f10707u0.setColor(b0.a.j(-65536, 127));
            q0(rect, this.f10709w0);
            canvas.drawRect(this.f10709w0, this.f10707u0);
            this.f10707u0.setColor(b0.a.j(-16711936, 127));
            s0(rect, this.f10709w0);
            canvas.drawRect(this.f10709w0, this.f10707u0);
        }
    }

    private void H0(Canvas canvas, Rect rect) {
        if (this.G != null) {
            Paint.Align w02 = w0(rect, this.f10710x0);
            u0(rect, this.f10709w0);
            if (this.f10713z0.d() != null) {
                this.f10713z0.e().drawableState = getState();
                this.f10713z0.j(this.f10705s0);
            }
            this.f10713z0.e().setTextAlign(w02);
            int i10 = 0;
            boolean z10 = Math.round(this.f10713z0.f(k1().toString())) > Math.round(this.f10709w0.width());
            if (z10) {
                i10 = canvas.save();
                canvas.clipRect(this.f10709w0);
            }
            CharSequence charSequence = this.G;
            if (z10 && this.R0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f10713z0.e(), this.f10709w0.width(), this.R0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f10710x0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f10713z0.e());
            if (z10) {
                canvas.restoreToCount(i10);
            }
        }
    }

    private boolean P2() {
        return this.T && this.U != null && this.G0;
    }

    private boolean Q2() {
        return this.H && this.I != null;
    }

    private boolean R2() {
        return this.M && this.N != null;
    }

    private void S2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void T2() {
        this.P0 = this.O0 ? b.d(this.F) : null;
    }

    @TargetApi(21)
    private void U2() {
        this.O = new RippleDrawable(b.d(i1()), this.N, W0);
    }

    private float c1() {
        Drawable drawable = this.G0 ? this.U : this.I;
        float f10 = this.K;
        if (f10 <= 0.0f && drawable != null) {
            f10 = (float) Math.ceil(m.b(this.f10705s0, 24));
            if (drawable.getIntrinsicHeight() <= f10) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f10;
    }

    private float d1() {
        Drawable drawable = this.G0 ? this.U : this.I;
        float f10 = this.K;
        return (f10 > 0.0f || drawable == null) ? f10 : drawable.getIntrinsicWidth();
    }

    private void e2(ColorStateList colorStateList) {
        if (this.f10712z != colorStateList) {
            this.f10712z = colorStateList;
            onStateChange(getState());
        }
    }

    private void n0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.N) {
                if (drawable.isStateful()) {
                    drawable.setState(Z0());
                }
                androidx.core.graphics.drawable.a.o(drawable, this.P);
                return;
            }
            Drawable drawable2 = this.I;
            if (drawable == drawable2 && this.L) {
                androidx.core.graphics.drawable.a.o(drawable2, this.J);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private void o0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (Q2() || P2()) {
            float f10 = this.f10697k0 + this.f10698l0;
            float d12 = d1();
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f11 = rect.left + f10;
                rectF.left = f11;
                rectF.right = f11 + d12;
            } else {
                float f12 = rect.right - f10;
                rectF.right = f12;
                rectF.left = f12 - d12;
            }
            float c12 = c1();
            float exactCenterY = rect.exactCenterY() - (c12 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + c12;
        }
    }

    private ColorFilter o1() {
        ColorFilter colorFilter = this.J0;
        return colorFilter != null ? colorFilter : this.K0;
    }

    private void q0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (R2()) {
            float f10 = this.f10704r0 + this.f10703q0 + this.Q + this.f10702p0 + this.f10701o0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.right = rect.right - f10;
            } else {
                rectF.left = rect.left + f10;
            }
        }
    }

    private static boolean q1(int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    private void r0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (R2()) {
            float f10 = this.f10704r0 + this.f10703q0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f11 = rect.right - f10;
                rectF.right = f11;
                rectF.left = f11 - this.Q;
            } else {
                float f12 = rect.left + f10;
                rectF.left = f12;
                rectF.right = f12 + this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f13 = this.Q;
            float f14 = exactCenterY - (f13 / 2.0f);
            rectF.top = f14;
            rectF.bottom = f14 + f13;
        }
    }

    private void s0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (R2()) {
            float f10 = this.f10704r0 + this.f10703q0 + this.Q + this.f10702p0 + this.f10701o0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f11 = rect.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                int i10 = rect.left;
                rectF.left = i10;
                rectF.right = i10 + f10;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void u0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.G != null) {
            float p02 = this.f10697k0 + p0() + this.f10700n0;
            float t02 = this.f10704r0 + t0() + this.f10701o0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.left = rect.left + p02;
                rectF.right = rect.right - t02;
            } else {
                rectF.left = rect.left + t02;
                rectF.right = rect.right - p02;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean u1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float v0() {
        this.f10713z0.e().getFontMetrics(this.f10708v0);
        Paint.FontMetrics fontMetrics = this.f10708v0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean v1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean w1(d dVar) {
        return (dVar == null || dVar.i() == null || !dVar.i().isStateful()) ? false : true;
    }

    private boolean x0() {
        return this.T && this.U != null && this.S;
    }

    private void x1(AttributeSet attributeSet, int i10, int i11) {
        TypedArray h10 = k.h(this.f10705s0, attributeSet, l.f25419h0, i10, i11, new int[0]);
        this.U0 = h10.hasValue(l.T0);
        e2(c.a(this.f10705s0, h10, l.G0));
        I1(c.a(this.f10705s0, h10, l.f25514t0));
        W1(h10.getDimension(l.B0, 0.0f));
        int i12 = l.f25522u0;
        if (h10.hasValue(i12)) {
            K1(h10.getDimension(i12, 0.0f));
        }
        a2(c.a(this.f10705s0, h10, l.E0));
        c2(h10.getDimension(l.F0, 0.0f));
        B2(c.a(this.f10705s0, h10, l.S0));
        G2(h10.getText(l.f25467n0));
        d f10 = c.f(this.f10705s0, h10, l.f25427i0);
        f10.l(h10.getDimension(l.f25435j0, f10.j()));
        H2(f10);
        int i13 = h10.getInt(l.f25451l0, 0);
        if (i13 == 1) {
            t2(TextUtils.TruncateAt.START);
        } else if (i13 == 2) {
            t2(TextUtils.TruncateAt.MIDDLE);
        } else if (i13 == 3) {
            t2(TextUtils.TruncateAt.END);
        }
        V1(h10.getBoolean(l.A0, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            V1(h10.getBoolean(l.f25546x0, false));
        }
        O1(c.d(this.f10705s0, h10, l.f25538w0));
        int i14 = l.f25562z0;
        if (h10.hasValue(i14)) {
            S1(c.a(this.f10705s0, h10, i14));
        }
        Q1(h10.getDimension(l.f25554y0, -1.0f));
        r2(h10.getBoolean(l.N0, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            r2(h10.getBoolean(l.I0, false));
        }
        f2(c.d(this.f10705s0, h10, l.H0));
        p2(c.a(this.f10705s0, h10, l.M0));
        k2(h10.getDimension(l.K0, 0.0f));
        A1(h10.getBoolean(l.f25475o0, false));
        H1(h10.getBoolean(l.f25506s0, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            H1(h10.getBoolean(l.f25491q0, false));
        }
        C1(c.d(this.f10705s0, h10, l.f25483p0));
        int i15 = l.f25498r0;
        if (h10.hasValue(i15)) {
            E1(c.a(this.f10705s0, h10, i15));
        }
        E2(e7.h.b(this.f10705s0, h10, l.U0));
        u2(e7.h.b(this.f10705s0, h10, l.P0));
        Y1(h10.getDimension(l.D0, 0.0f));
        y2(h10.getDimension(l.R0, 0.0f));
        w2(h10.getDimension(l.Q0, 0.0f));
        L2(h10.getDimension(l.W0, 0.0f));
        J2(h10.getDimension(l.V0, 0.0f));
        m2(h10.getDimension(l.L0, 0.0f));
        h2(h10.getDimension(l.J0, 0.0f));
        M1(h10.getDimension(l.f25530v0, 0.0f));
        A2(h10.getDimensionPixelSize(l.f25459m0, Integer.MAX_VALUE));
        h10.recycle();
    }

    public static a y0(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.x1(attributeSet, i10, i11);
        return aVar;
    }

    private void z0(Canvas canvas, Rect rect) {
        if (P2()) {
            o0(rect, this.f10709w0);
            RectF rectF = this.f10709w0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.U.setBounds(0, 0, (int) this.f10709w0.width(), (int) this.f10709w0.height());
            this.U.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    private boolean z1(int[] iArr, int[] iArr2) {
        boolean z10;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f10712z;
        int l10 = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.A0) : 0);
        boolean z11 = true;
        if (this.A0 != l10) {
            this.A0 = l10;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.A;
        int l11 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.B0) : 0);
        if (this.B0 != l11) {
            this.B0 = l11;
            onStateChange = true;
        }
        int g10 = j7.a.g(l10, l11);
        if ((this.C0 != g10) || (x() == null)) {
            this.C0 = g10;
            Z(ColorStateList.valueOf(g10));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.D;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.D0) : 0;
        if (this.D0 != colorForState) {
            this.D0 = colorForState;
            onStateChange = true;
        }
        int colorForState2 = (this.P0 == null || !b.e(iArr)) ? 0 : this.P0.getColorForState(iArr, this.E0);
        if (this.E0 != colorForState2) {
            this.E0 = colorForState2;
            if (this.O0) {
                onStateChange = true;
            }
        }
        int colorForState3 = (this.f10713z0.d() == null || this.f10713z0.d().i() == null) ? 0 : this.f10713z0.d().i().getColorForState(iArr, this.F0);
        if (this.F0 != colorForState3) {
            this.F0 = colorForState3;
            onStateChange = true;
        }
        boolean z12 = q1(getState(), 16842912) && this.S;
        if (this.G0 == z12 || this.U == null) {
            z10 = false;
        } else {
            float p02 = p0();
            this.G0 = z12;
            if (p02 != p0()) {
                onStateChange = true;
                z10 = true;
            } else {
                z10 = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.L0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.H0) : 0;
        if (this.H0 != colorForState4) {
            this.H0 = colorForState4;
            this.K0 = m7.a.a(this, this.L0, this.M0);
        } else {
            z11 = onStateChange;
        }
        if (v1(this.I)) {
            z11 |= this.I.setState(iArr);
        }
        if (v1(this.U)) {
            z11 |= this.U.setState(iArr);
        }
        if (v1(this.N)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z11 |= this.N.setState(iArr3);
        }
        if (b.f35338a && v1(this.O)) {
            z11 |= this.O.setState(iArr2);
        }
        if (z11) {
            invalidateSelf();
        }
        if (z10) {
            y1();
        }
        return z11;
    }

    public void A1(boolean z10) {
        if (this.S != z10) {
            this.S = z10;
            float p02 = p0();
            if (!z10 && this.G0) {
                this.G0 = false;
            }
            float p03 = p0();
            invalidateSelf();
            if (p02 != p03) {
                y1();
            }
        }
    }

    public void A2(int i10) {
        this.T0 = i10;
    }

    public void B1(int i10) {
        A1(this.f10705s0.getResources().getBoolean(i10));
    }

    public void B2(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            T2();
            onStateChange(getState());
        }
    }

    public void C1(Drawable drawable) {
        if (this.U != drawable) {
            float p02 = p0();
            this.U = drawable;
            float p03 = p0();
            S2(this.U);
            n0(this.U);
            invalidateSelf();
            if (p02 != p03) {
                y1();
            }
        }
    }

    public void C2(int i10) {
        B2(e.a.a(this.f10705s0, i10));
    }

    public void D1(int i10) {
        C1(e.a.b(this.f10705s0, i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D2(boolean z10) {
        this.S0 = z10;
    }

    public void E1(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (x0()) {
                androidx.core.graphics.drawable.a.o(this.U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void E2(e7.h hVar) {
        this.W = hVar;
    }

    public void F1(int i10) {
        E1(e.a.a(this.f10705s0, i10));
    }

    public void F2(int i10) {
        E2(e7.h.c(this.f10705s0, i10));
    }

    public void G1(int i10) {
        H1(this.f10705s0.getResources().getBoolean(i10));
    }

    public void G2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.f10713z0.i(true);
            invalidateSelf();
            y1();
        }
    }

    public void H1(boolean z10) {
        if (this.T != z10) {
            boolean P2 = P2();
            this.T = z10;
            boolean P22 = P2();
            if (P2 != P22) {
                if (P22) {
                    n0(this.U);
                } else {
                    S2(this.U);
                }
                invalidateSelf();
                y1();
            }
        }
    }

    public void H2(d dVar) {
        this.f10713z0.h(dVar, this.f10705s0);
    }

    public Drawable I0() {
        return this.U;
    }

    public void I1(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public void I2(int i10) {
        H2(new d(this.f10705s0, i10));
    }

    public ColorStateList J0() {
        return this.V;
    }

    public void J1(int i10) {
        I1(e.a.a(this.f10705s0, i10));
    }

    public void J2(float f10) {
        if (this.f10701o0 != f10) {
            this.f10701o0 = f10;
            invalidateSelf();
            y1();
        }
    }

    public ColorStateList K0() {
        return this.A;
    }

    @Deprecated
    public void K1(float f10) {
        if (this.C != f10) {
            this.C = f10;
            setShapeAppearanceModel(E().w(f10));
        }
    }

    public void K2(int i10) {
        J2(this.f10705s0.getResources().getDimension(i10));
    }

    public float L0() {
        return this.U0 ? H() : this.C;
    }

    @Deprecated
    public void L1(int i10) {
        K1(this.f10705s0.getResources().getDimension(i10));
    }

    public void L2(float f10) {
        if (this.f10700n0 != f10) {
            this.f10700n0 = f10;
            invalidateSelf();
            y1();
        }
    }

    public float M0() {
        return this.f10704r0;
    }

    public void M1(float f10) {
        if (this.f10704r0 != f10) {
            this.f10704r0 = f10;
            invalidateSelf();
            y1();
        }
    }

    public void M2(int i10) {
        L2(this.f10705s0.getResources().getDimension(i10));
    }

    public Drawable N0() {
        Drawable drawable = this.I;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void N1(int i10) {
        M1(this.f10705s0.getResources().getDimension(i10));
    }

    public void N2(boolean z10) {
        if (this.O0 != z10) {
            this.O0 = z10;
            T2();
            onStateChange(getState());
        }
    }

    public float O0() {
        return this.K;
    }

    public void O1(Drawable drawable) {
        Drawable N0 = N0();
        if (N0 != drawable) {
            float p02 = p0();
            this.I = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            float p03 = p0();
            S2(N0);
            if (Q2()) {
                n0(this.I);
            }
            invalidateSelf();
            if (p02 != p03) {
                y1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O2() {
        return this.S0;
    }

    public ColorStateList P0() {
        return this.J;
    }

    public void P1(int i10) {
        O1(e.a.b(this.f10705s0, i10));
    }

    public float Q0() {
        return this.B;
    }

    public void Q1(float f10) {
        if (this.K != f10) {
            float p02 = p0();
            this.K = f10;
            float p03 = p0();
            invalidateSelf();
            if (p02 != p03) {
                y1();
            }
        }
    }

    public float R0() {
        return this.f10697k0;
    }

    public void R1(int i10) {
        Q1(this.f10705s0.getResources().getDimension(i10));
    }

    public ColorStateList S0() {
        return this.D;
    }

    public void S1(ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (Q2()) {
                androidx.core.graphics.drawable.a.o(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float T0() {
        return this.E;
    }

    public void T1(int i10) {
        S1(e.a.a(this.f10705s0, i10));
    }

    public Drawable U0() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void U1(int i10) {
        V1(this.f10705s0.getResources().getBoolean(i10));
    }

    public CharSequence V0() {
        return this.R;
    }

    public void V1(boolean z10) {
        if (this.H != z10) {
            boolean Q2 = Q2();
            this.H = z10;
            boolean Q22 = Q2();
            if (Q2 != Q22) {
                if (Q22) {
                    n0(this.I);
                } else {
                    S2(this.I);
                }
                invalidateSelf();
                y1();
            }
        }
    }

    public float W0() {
        return this.f10703q0;
    }

    public void W1(float f10) {
        if (this.B != f10) {
            this.B = f10;
            invalidateSelf();
            y1();
        }
    }

    public float X0() {
        return this.Q;
    }

    public void X1(int i10) {
        W1(this.f10705s0.getResources().getDimension(i10));
    }

    public float Y0() {
        return this.f10702p0;
    }

    public void Y1(float f10) {
        if (this.f10697k0 != f10) {
            this.f10697k0 = f10;
            invalidateSelf();
            y1();
        }
    }

    public int[] Z0() {
        return this.N0;
    }

    public void Z1(int i10) {
        Y1(this.f10705s0.getResources().getDimension(i10));
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        y1();
        invalidateSelf();
    }

    public ColorStateList a1() {
        return this.P;
    }

    public void a2(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.U0) {
                i0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b1(RectF rectF) {
        s0(getBounds(), rectF);
    }

    public void b2(int i10) {
        a2(e.a.a(this.f10705s0, i10));
    }

    public void c2(float f10) {
        if (this.E != f10) {
            this.E = f10;
            this.f10706t0.setStrokeWidth(f10);
            if (this.U0) {
                super.j0(f10);
            }
            invalidateSelf();
        }
    }

    public void d2(int i10) {
        c2(this.f10705s0.getResources().getDimension(i10));
    }

    @Override // w7.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i10 = 0;
            int i11 = this.I0;
            if (i11 < 255) {
                i10 = f7.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i11);
            }
            D0(canvas, bounds);
            A0(canvas, bounds);
            if (this.U0) {
                super.draw(canvas);
            }
            C0(canvas, bounds);
            F0(canvas, bounds);
            B0(canvas, bounds);
            z0(canvas, bounds);
            if (this.S0) {
                H0(canvas, bounds);
            }
            E0(canvas, bounds);
            G0(canvas, bounds);
            if (this.I0 < 255) {
                canvas.restoreToCount(i10);
            }
        }
    }

    public TextUtils.TruncateAt e1() {
        return this.R0;
    }

    public e7.h f1() {
        return this.f10696j0;
    }

    public void f2(Drawable drawable) {
        Drawable U0 = U0();
        if (U0 != drawable) {
            float t02 = t0();
            this.N = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            if (b.f35338a) {
                U2();
            }
            float t03 = t0();
            S2(U0);
            if (R2()) {
                n0(this.N);
            }
            invalidateSelf();
            if (t02 != t03) {
                y1();
            }
        }
    }

    public float g1() {
        return this.f10699m0;
    }

    public void g2(CharSequence charSequence) {
        if (this.R != charSequence) {
            this.R = i0.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.I0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.J0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f10697k0 + p0() + this.f10700n0 + this.f10713z0.f(k1().toString()) + this.f10701o0 + t0() + this.f10704r0), this.T0);
    }

    @Override // w7.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // w7.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.U0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.C);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public float h1() {
        return this.f10698l0;
    }

    public void h2(float f10) {
        if (this.f10703q0 != f10) {
            this.f10703q0 = f10;
            invalidateSelf();
            if (R2()) {
                y1();
            }
        }
    }

    public ColorStateList i1() {
        return this.F;
    }

    public void i2(int i10) {
        h2(this.f10705s0.getResources().getDimension(i10));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // w7.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return u1(this.f10712z) || u1(this.A) || u1(this.D) || (this.O0 && u1(this.P0)) || w1(this.f10713z0.d()) || x0() || v1(this.I) || v1(this.U) || u1(this.L0);
    }

    public e7.h j1() {
        return this.W;
    }

    public void j2(int i10) {
        f2(e.a.b(this.f10705s0, i10));
    }

    public CharSequence k1() {
        return this.G;
    }

    public void k2(float f10) {
        if (this.Q != f10) {
            this.Q = f10;
            invalidateSelf();
            if (R2()) {
                y1();
            }
        }
    }

    public d l1() {
        return this.f10713z0.d();
    }

    public void l2(int i10) {
        k2(this.f10705s0.getResources().getDimension(i10));
    }

    public float m1() {
        return this.f10701o0;
    }

    public void m2(float f10) {
        if (this.f10702p0 != f10) {
            this.f10702p0 = f10;
            invalidateSelf();
            if (R2()) {
                y1();
            }
        }
    }

    public float n1() {
        return this.f10700n0;
    }

    public void n2(int i10) {
        m2(this.f10705s0.getResources().getDimension(i10));
    }

    public boolean o2(int[] iArr) {
        if (Arrays.equals(this.N0, iArr)) {
            return false;
        }
        this.N0 = iArr;
        if (R2()) {
            return z1(getState(), iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (Q2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.I, i10);
        }
        if (P2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.U, i10);
        }
        if (R2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.N, i10);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        boolean onLevelChange = super.onLevelChange(i10);
        if (Q2()) {
            onLevelChange |= this.I.setLevel(i10);
        }
        if (P2()) {
            onLevelChange |= this.U.setLevel(i10);
        }
        if (R2()) {
            onLevelChange |= this.N.setLevel(i10);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // w7.g, android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        if (this.U0) {
            super.onStateChange(iArr);
        }
        return z1(iArr, Z0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p0() {
        if (Q2() || P2()) {
            return this.f10698l0 + d1() + this.f10699m0;
        }
        return 0.0f;
    }

    public boolean p1() {
        return this.O0;
    }

    public void p2(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (R2()) {
                androidx.core.graphics.drawable.a.o(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void q2(int i10) {
        p2(e.a.a(this.f10705s0, i10));
    }

    public boolean r1() {
        return this.S;
    }

    public void r2(boolean z10) {
        if (this.M != z10) {
            boolean R2 = R2();
            this.M = z10;
            boolean R22 = R2();
            if (R2 != R22) {
                if (R22) {
                    n0(this.N);
                } else {
                    S2(this.N);
                }
                invalidateSelf();
                y1();
            }
        }
    }

    public boolean s1() {
        return v1(this.N);
    }

    public void s2(AbstractC0121a aVar) {
        this.Q0 = new WeakReference<>(aVar);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // w7.g, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.I0 != i10) {
            this.I0 = i10;
            invalidateSelf();
        }
    }

    @Override // w7.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.J0 != colorFilter) {
            this.J0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // w7.g, android.graphics.drawable.Drawable, c0.d
    public void setTintList(ColorStateList colorStateList) {
        if (this.L0 != colorStateList) {
            this.L0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // w7.g, android.graphics.drawable.Drawable, c0.d
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.M0 != mode) {
            this.M0 = mode;
            this.K0 = m7.a.a(this, this.L0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (Q2()) {
            visible |= this.I.setVisible(z10, z11);
        }
        if (P2()) {
            visible |= this.U.setVisible(z10, z11);
        }
        if (R2()) {
            visible |= this.N.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t0() {
        if (R2()) {
            return this.f10702p0 + this.Q + this.f10703q0;
        }
        return 0.0f;
    }

    public boolean t1() {
        return this.M;
    }

    public void t2(TextUtils.TruncateAt truncateAt) {
        this.R0 = truncateAt;
    }

    public void u2(e7.h hVar) {
        this.f10696j0 = hVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v2(int i10) {
        u2(e7.h.c(this.f10705s0, i10));
    }

    Paint.Align w0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.G != null) {
            float p02 = this.f10697k0 + p0() + this.f10700n0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                pointF.x = rect.left + p02;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - p02;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - v0();
        }
        return align;
    }

    public void w2(float f10) {
        if (this.f10699m0 != f10) {
            float p02 = p0();
            this.f10699m0 = f10;
            float p03 = p0();
            invalidateSelf();
            if (p02 != p03) {
                y1();
            }
        }
    }

    public void x2(int i10) {
        w2(this.f10705s0.getResources().getDimension(i10));
    }

    protected void y1() {
        AbstractC0121a aVar = this.Q0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public void y2(float f10) {
        if (this.f10698l0 != f10) {
            float p02 = p0();
            this.f10698l0 = f10;
            float p03 = p0();
            invalidateSelf();
            if (p02 != p03) {
                y1();
            }
        }
    }

    public void z2(int i10) {
        y2(this.f10705s0.getResources().getDimension(i10));
    }
}
