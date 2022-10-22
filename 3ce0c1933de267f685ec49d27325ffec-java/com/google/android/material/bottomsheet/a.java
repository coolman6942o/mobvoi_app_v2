package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.g;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import androidx.core.view.n0;
import androidx.core.view.v;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d7.h;
import d7.k;
/* compiled from: BottomSheetDialog.java */
/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: c  reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f10553c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f10554d;

    /* renamed from: e  reason: collision with root package name */
    private CoordinatorLayout f10555e;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f10556f;

    /* renamed from: g  reason: collision with root package name */
    boolean f10557g;

    /* renamed from: h  reason: collision with root package name */
    boolean f10558h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10559i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10560j;

    /* renamed from: k  reason: collision with root package name */
    private BottomSheetBehavior.f f10561k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10562l;

    /* renamed from: m  reason: collision with root package name */
    private BottomSheetBehavior.f f10563m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomSheetDialog.java */
    /* renamed from: com.google.android.material.bottomsheet.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0119a implements v {
        C0119a() {
        }

        @Override // androidx.core.view.v
        public n0 a(View view, n0 n0Var) {
            if (a.this.f10561k != null) {
                a.this.f10553c.k0(a.this.f10561k);
            }
            if (n0Var != null) {
                a aVar = a.this;
                aVar.f10561k = new f(aVar.f10556f, n0Var, null);
                a.this.f10553c.S(a.this.f10561k);
            }
            return n0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f10558h && aVar.isShowing() && a.this.l()) {
                a.this.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes.dex */
    public class c extends androidx.core.view.a {
        c() {
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            super.g(view, cVar);
            if (a.this.f10558h) {
                cVar.a(1048576);
                cVar.f0(true);
                return;
            }
            cVar.f0(false);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (i10 == 1048576) {
                a aVar = a.this;
                if (aVar.f10558h) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i10, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        d(a aVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes.dex */
    class e extends BottomSheetBehavior.f {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, int i10) {
            if (i10 == 5) {
                a.this.cancel();
            }
        }
    }

    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes.dex */
    private static class f extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f10568a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f10569b;

        /* renamed from: c  reason: collision with root package name */
        private final n0 f10570c;

        /* synthetic */ f(View view, n0 n0Var, C0119a aVar) {
            this(view, n0Var);
        }

        private void c(View view) {
            if (view.getTop() < this.f10570c.m()) {
                a.k(view, this.f10568a);
                view.setPadding(view.getPaddingLeft(), this.f10570c.m() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                a.k(view, this.f10569b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(View view, float f10) {
            c(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, int i10) {
            c(view);
        }

        private f(View view, n0 n0Var) {
            ColorStateList colorStateList;
            this.f10570c = n0Var;
            boolean z10 = Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            this.f10569b = z10;
            w7.g f02 = BottomSheetBehavior.c0(view).f0();
            if (f02 != null) {
                colorStateList = f02.x();
            } else {
                colorStateList = d0.u(view);
            }
            if (colorStateList != null) {
                this.f10568a = j7.a.f(colorStateList.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f10568a = j7.a.f(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.f10568a = z10;
            }
        }
    }

    public a(Context context) {
        this(context, 0);
        this.f10562l = getContext().getTheme().obtainStyledAttributes(new int[]{d7.b.f25166v}).getBoolean(0, false);
    }

    private static int b(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(d7.b.f25150f, typedValue, true)) {
            return typedValue.resourceId;
        }
        return k.f25341f;
    }

    private FrameLayout i() {
        if (this.f10554d == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), h.f25284b, null);
            this.f10554d = frameLayout;
            this.f10555e = (CoordinatorLayout) frameLayout.findViewById(d7.f.f25248d);
            FrameLayout frameLayout2 = (FrameLayout) this.f10554d.findViewById(d7.f.f25250e);
            this.f10556f = frameLayout2;
            BottomSheetBehavior<FrameLayout> c02 = BottomSheetBehavior.c0(frameLayout2);
            this.f10553c = c02;
            c02.S(this.f10563m);
            this.f10553c.t0(this.f10558h);
        }
        return this.f10554d;
    }

    public static void k(View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z10 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    private View m(int i10, View view, ViewGroup.LayoutParams layoutParams) {
        i();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f10554d.findViewById(d7.f.f25248d);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f10562l) {
            d0.G0(this.f10556f, new C0119a());
        }
        this.f10556f.removeAllViews();
        if (layoutParams == null) {
            this.f10556f.addView(view);
        } else {
            this.f10556f.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(d7.f.f25265l0).setOnClickListener(new b());
        d0.t0(this.f10556f, new c());
        this.f10556f.setOnTouchListener(new d(this));
        return this.f10554d;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> j10 = j();
        if (!this.f10557g || j10.g0() == 5) {
            super.cancel();
        } else {
            j10.A0(5);
        }
    }

    public BottomSheetBehavior<FrameLayout> j() {
        if (this.f10553c == null) {
            i();
        }
        return this.f10553c;
    }

    boolean l() {
        if (!this.f10560j) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f10559i = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f10560j = true;
        }
        return this.f10559i;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null && Build.VERSION.SDK_INT >= 21) {
            boolean z10 = this.f10562l && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f10554d;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.f10555e;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            if (z10) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 21) {
                window.setStatusBarColor(0);
                window.addFlags(Integer.MIN_VALUE);
                if (i10 < 23) {
                    window.addFlags(67108864);
                }
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f10553c;
        if (bottomSheetBehavior != null && bottomSheetBehavior.g0() == 5) {
            this.f10553c.A0(4);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.f10558h != z10) {
            this.f10558h = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f10553c;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.t0(z10);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.f10558h) {
            this.f10558h = true;
        }
        this.f10559i = z10;
        this.f10560j = true;
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void setContentView(int i10) {
        super.setContentView(m(i10, null, null));
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(m(0, view, null));
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(m(0, view, layoutParams));
    }

    public a(Context context, int i10) {
        super(context, b(context, i10));
        this.f10558h = true;
        this.f10559i = true;
        this.f10563m = new e();
        d(1);
        this.f10562l = getContext().getTheme().obtainStyledAttributes(new int[]{d7.b.f25166v}).getBoolean(0, false);
    }
}
