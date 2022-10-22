package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.view.d0;
import com.google.android.material.timepicker.ClockHandView;
import d7.d;
import d7.f;
import d7.h;
import d7.k;
import d7.l;
import java.util.Arrays;
import k0.c;
/* loaded from: classes.dex */
class ClockFaceView extends d implements ClockHandView.d {
    private final SparseArray<TextView> A;
    private final androidx.core.view.a B;
    private final int[] C;
    private final float[] D;
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private String[] I;
    private float J;
    private final ColorStateList K;

    /* renamed from: x  reason: collision with root package name */
    private final ClockHandView f11571x;

    /* renamed from: y  reason: collision with root package name */
    private final Rect f11572y;

    /* renamed from: z  reason: collision with root package name */
    private final RectF f11573z;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.G(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f11571x.g()) - ClockFaceView.this.E);
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, c cVar) {
            super.g(view, cVar);
            int intValue = ((Integer) view.getTag(f.f25278y)).intValue();
            if (intValue > 0) {
                cVar.A0((View) ClockFaceView.this.A.get(intValue - 1));
            }
            cVar.d0(c.C0359c.a(0, 1, intValue, 1, false, view.isSelected()));
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.F);
    }

    private void N() {
        RectF d10 = this.f11571x.d();
        for (int i10 = 0; i10 < this.A.size(); i10++) {
            TextView textView = this.A.get(i10);
            if (textView != null) {
                textView.getDrawingRect(this.f11572y);
                this.f11572y.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f11572y);
                this.f11573z.set(this.f11572y);
                textView.getPaint().setShader(O(d10, this.f11573z));
                textView.invalidate();
            }
        }
    }

    private RadialGradient O(RectF rectF, RectF rectF2) {
        if (!RectF.intersects(rectF, rectF2)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.f11573z.left, rectF.centerY() - this.f11573z.top, rectF.width() * 0.5f, this.C, this.D, Shader.TileMode.CLAMP);
    }

    private static float P(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    private void R(int i10) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.A.size();
        for (int i11 = 0; i11 < Math.max(this.I.length, size); i11++) {
            TextView textView = this.A.get(i11);
            if (i11 >= this.I.length) {
                removeView(textView);
                this.A.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(h.f25292j, (ViewGroup) this, false);
                    this.A.put(i11, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.I[i11]);
                textView.setTag(f.f25278y, Integer.valueOf(i11));
                d0.t0(textView, this.B);
                textView.setTextColor(this.K);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.I[i11]));
                }
            }
        }
    }

    @Override // com.google.android.material.timepicker.d
    public void G(int i10) {
        if (i10 != F()) {
            super.G(i10);
            this.f11571x.k(F());
        }
    }

    public void Q(String[] strArr, int i10) {
        this.I = strArr;
        R(i10);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void b(float f10, boolean z10) {
        if (Math.abs(this.J - f10) > 0.001f) {
            this.J = f10;
            N();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        c.D0(accessibilityNodeInfo).c0(c.b.a(1, this.I.length, false, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int P = (int) (this.H / P(this.F / displayMetrics.heightPixels, this.G / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(P, 1073741824);
        setMeasuredDimension(P, P);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11572y = new Rect();
        this.f11573z = new RectF();
        this.A = new SparseArray<>();
        this.D = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f25436j1, i10, k.D);
        Resources resources = getResources();
        ColorStateList a10 = t7.c.a(context, obtainStyledAttributes, l.f25452l1);
        this.K = a10;
        LayoutInflater.from(context).inflate(h.f25293k, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(f.f25262k);
        this.f11571x = clockHandView;
        this.E = resources.getDimensionPixelSize(d.f25228x);
        int colorForState = a10.getColorForState(new int[]{16842913}, a10.getDefaultColor());
        this.C = new int[]{colorForState, colorForState, a10.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = e.a.a(context, d7.c.f25177g).getDefaultColor();
        ColorStateList a11 = t7.c.a(context, obtainStyledAttributes, l.f25444k1);
        setBackgroundColor(a11 != null ? a11.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.B = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        Q(strArr, 0);
        this.F = resources.getDimensionPixelSize(d.L);
        this.G = resources.getDimensionPixelSize(d.M);
        this.H = resources.getDimensionPixelSize(d.f25232z);
    }
}
