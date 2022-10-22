package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.b0;
import androidx.core.view.d0;
import androidx.core.widget.j;
import d7.d;
import e7.b;
import java.util.ArrayList;
import java.util.List;
import t7.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndicatorViewController.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11527a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f11528b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f11529c;

    /* renamed from: d  reason: collision with root package name */
    private int f11530d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f11531e;

    /* renamed from: f  reason: collision with root package name */
    private Animator f11532f;

    /* renamed from: g  reason: collision with root package name */
    private final float f11533g;

    /* renamed from: h  reason: collision with root package name */
    private int f11534h;

    /* renamed from: i  reason: collision with root package name */
    private int f11535i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f11536j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11537k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f11538l;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f11539m;

    /* renamed from: n  reason: collision with root package name */
    private int f11540n;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f11541o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f11542p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11543q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f11544r;

    /* renamed from: s  reason: collision with root package name */
    private int f11545s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f11546t;

    /* renamed from: u  reason: collision with root package name */
    private Typeface f11547u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndicatorViewController.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f11548a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f11549b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f11550c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f11551d;

        a(int i10, TextView textView, int i11, TextView textView2) {
            this.f11548a = i10;
            this.f11549b = textView;
            this.f11550c = i11;
            this.f11551d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f11534h = this.f11548a;
            f.this.f11532f = null;
            TextView textView = this.f11549b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f11550c == 1 && f.this.f11538l != null) {
                    f.this.f11538l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f11551d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f11551d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f11551d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f11527a = context;
        this.f11528b = textInputLayout;
        this.f11533g = context.getResources().getDimensionPixelSize(d.f25212p);
    }

    private void A(int i10, int i11) {
        TextView l10;
        TextView l11;
        if (i10 != i11) {
            if (!(i11 == 0 || (l11 = l(i11)) == null)) {
                l11.setVisibility(0);
                l11.setAlpha(1.0f);
            }
            if (!(i10 == 0 || (l10 = l(i10)) == null)) {
                l10.setVisibility(4);
                if (i10 == 1) {
                    l10.setText((CharSequence) null);
                }
            }
            this.f11534h = i11;
        }
    }

    private void I(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void K(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean L(TextView textView, CharSequence charSequence) {
        return d0.X(this.f11528b) && this.f11528b.isEnabled() && (this.f11535i != this.f11534h || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    private void O(int i10, int i11, boolean z10) {
        if (i10 != i11) {
            if (z10) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f11532f = animatorSet;
                ArrayList arrayList = new ArrayList();
                h(arrayList, this.f11543q, this.f11544r, 2, i10, i11);
                h(arrayList, this.f11537k, this.f11538l, 1, i10, i11);
                b.a(animatorSet, arrayList);
                animatorSet.addListener(new a(i11, l(i10), i10, l(i11)));
                animatorSet.start();
            } else {
                A(i10, i11);
            }
            this.f11528b.t0();
            this.f11528b.w0(z10);
            this.f11528b.G0();
        }
    }

    private boolean f() {
        return (this.f11529c == null || this.f11528b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z10, TextView textView, int i10, int i11, int i12) {
        if (textView != null && z10) {
            if (i10 == i12 || i10 == i11) {
                list.add(i(textView, i12 == i10));
                if (i12 == i10) {
                    list.add(j(textView));
                }
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z10 ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(e7.a.f25833a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f11533g, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(e7.a.f25836d);
        return ofFloat;
    }

    private TextView l(int i10) {
        if (i10 == 1) {
            return this.f11538l;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f11544r;
    }

    private int s(boolean z10, int i10, int i11) {
        return z10 ? this.f11527a.getResources().getDimensionPixelSize(i10) : i11;
    }

    private boolean v(int i10) {
        return i10 == 1 && this.f11538l != null && !TextUtils.isEmpty(this.f11536j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(CharSequence charSequence) {
        this.f11539m = charSequence;
        TextView textView = this.f11538l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(boolean z10) {
        if (this.f11537k != z10) {
            g();
            if (z10) {
                b0 b0Var = new b0(this.f11527a);
                this.f11538l = b0Var;
                b0Var.setId(d7.f.f25255g0);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f11538l.setTextAlignment(5);
                }
                Typeface typeface = this.f11547u;
                if (typeface != null) {
                    this.f11538l.setTypeface(typeface);
                }
                D(this.f11540n);
                E(this.f11541o);
                B(this.f11539m);
                this.f11538l.setVisibility(4);
                d0.v0(this.f11538l, 1);
                d(this.f11538l, 0);
            } else {
                t();
                z(this.f11538l, 0);
                this.f11538l = null;
                this.f11528b.t0();
                this.f11528b.G0();
            }
            this.f11537k = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(int i10) {
        this.f11540n = i10;
        TextView textView = this.f11538l;
        if (textView != null) {
            this.f11528b.g0(textView, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(ColorStateList colorStateList) {
        this.f11541o = colorStateList;
        TextView textView = this.f11538l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(int i10) {
        this.f11545s = i10;
        TextView textView = this.f11544r;
        if (textView != null) {
            j.q(textView, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z10) {
        if (this.f11543q != z10) {
            g();
            if (z10) {
                b0 b0Var = new b0(this.f11527a);
                this.f11544r = b0Var;
                b0Var.setId(d7.f.f25257h0);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f11544r.setTextAlignment(5);
                }
                Typeface typeface = this.f11547u;
                if (typeface != null) {
                    this.f11544r.setTypeface(typeface);
                }
                this.f11544r.setVisibility(4);
                d0.v0(this.f11544r, 1);
                F(this.f11545s);
                H(this.f11546t);
                d(this.f11544r, 1);
            } else {
                u();
                z(this.f11544r, 1);
                this.f11544r = null;
                this.f11528b.t0();
                this.f11528b.G0();
            }
            this.f11543q = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(ColorStateList colorStateList) {
        this.f11546t = colorStateList;
        TextView textView = this.f11544r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(Typeface typeface) {
        if (typeface != this.f11547u) {
            this.f11547u = typeface;
            I(this.f11538l, typeface);
            I(this.f11544r, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(CharSequence charSequence) {
        g();
        this.f11536j = charSequence;
        this.f11538l.setText(charSequence);
        int i10 = this.f11534h;
        if (i10 != 1) {
            this.f11535i = 1;
        }
        O(i10, this.f11535i, L(this.f11538l, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(CharSequence charSequence) {
        g();
        this.f11542p = charSequence;
        this.f11544r.setText(charSequence);
        int i10 = this.f11534h;
        if (i10 != 2) {
            this.f11535i = 2;
        }
        O(i10, this.f11535i, L(this.f11544r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i10) {
        if (this.f11529c == null && this.f11531e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f11527a);
            this.f11529c = linearLayout;
            linearLayout.setOrientation(0);
            this.f11528b.addView(this.f11529c, -1, -2);
            this.f11531e = new FrameLayout(this.f11527a);
            this.f11529c.addView(this.f11531e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f11528b.getEditText() != null) {
                e();
            }
        }
        if (w(i10)) {
            this.f11531e.setVisibility(0);
            this.f11531e.addView(textView);
        } else {
            this.f11529c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f11529c.setVisibility(0);
        this.f11530d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            EditText editText = this.f11528b.getEditText();
            boolean g10 = c.g(this.f11527a);
            LinearLayout linearLayout = this.f11529c;
            int i10 = d.I;
            d0.H0(linearLayout, s(g10, i10, d0.J(editText)), s(g10, d.J, this.f11527a.getResources().getDimensionPixelSize(d.H)), s(g10, i10, d0.I(editText)), 0);
        }
    }

    void g() {
        Animator animator = this.f11532f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return v(this.f11535i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence m() {
        return this.f11539m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence n() {
        return this.f11536j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        TextView textView = this.f11538l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList p() {
        TextView textView = this.f11538l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence q() {
        return this.f11542p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        TextView textView = this.f11544r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.f11536j = null;
        g();
        if (this.f11534h == 1) {
            if (!this.f11543q || TextUtils.isEmpty(this.f11542p)) {
                this.f11535i = 0;
            } else {
                this.f11535i = 2;
            }
        }
        O(this.f11534h, this.f11535i, L(this.f11538l, null));
    }

    void u() {
        g();
        int i10 = this.f11534h;
        if (i10 == 2) {
            this.f11535i = 0;
        }
        O(i10, this.f11535i, L(this.f11544r, null));
    }

    boolean w(int i10) {
        return i10 == 0 || i10 == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.f11537k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f11543q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f11529c != null) {
            if (!w(i10) || (frameLayout = this.f11531e) == null) {
                this.f11529c.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i11 = this.f11530d - 1;
            this.f11530d = i11;
            K(this.f11529c, i11);
        }
    }
}
