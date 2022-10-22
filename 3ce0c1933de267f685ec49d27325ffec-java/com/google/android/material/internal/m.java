package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.d0;
import androidx.core.view.n0;
import androidx.core.view.v;
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class m {

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f11097a;

        a(View view) {
            this.f11097a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f11097a.getContext().getSystemService("input_method")).showSoftInput(this.f11097a, 1);
        }
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    static class b implements v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f11098a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f11099b;

        b(d dVar, e eVar) {
            this.f11098a = dVar;
            this.f11099b = eVar;
        }

        @Override // androidx.core.view.v
        public n0 a(View view, n0 n0Var) {
            return this.f11098a.a(view, n0Var, new e(this.f11099b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    public static class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            d0.q0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    public interface d {
        n0 a(View view, n0 n0Var, e eVar);
    }

    public static void a(View view, d dVar) {
        d0.G0(view, new b(dVar, new e(d0.J(view), view.getPaddingTop(), d0.I(view), view.getPaddingBottom())));
        f(view);
    }

    public static float b(Context context, int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static float c(View view) {
        float f10 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f10 += d0.y((View) parent);
        }
        return f10;
    }

    public static boolean d(View view) {
        return d0.E(view) == 1;
    }

    public static PorterDuff.Mode e(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void f(View view) {
        if (d0.W(view)) {
            d0.q0(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void g(View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f11100a;

        /* renamed from: b  reason: collision with root package name */
        public int f11101b;

        /* renamed from: c  reason: collision with root package name */
        public int f11102c;

        /* renamed from: d  reason: collision with root package name */
        public int f11103d;

        public e(int i10, int i11, int i12, int i13) {
            this.f11100a = i10;
            this.f11101b = i11;
            this.f11102c = i12;
            this.f11103d = i13;
        }

        public void a(View view) {
            d0.H0(view, this.f11100a, this.f11101b, this.f11102c, this.f11103d);
        }

        public e(e eVar) {
            this.f11100a = eVar.f11100a;
            this.f11101b = eVar.f11101b;
            this.f11102c = eVar.f11102c;
            this.f11103d = eVar.f11103d;
        }
    }
}
