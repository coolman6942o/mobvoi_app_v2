package com.mobvoi.mcuwatch.welcome.fragment;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.mobvoi.mcuwatch.welcome.WelcomeActivity;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import sh.f;
import sh.k;
import zh.u;
/* compiled from: WelcomeFragment.kt */
/* loaded from: classes2.dex */
public final class n extends Fragment {

    /* renamed from: l  reason: collision with root package name */
    public static final c f20323l = new c(null);

    /* renamed from: a  reason: collision with root package name */
    private WelcomeActivity f20324a;

    /* renamed from: b  reason: collision with root package name */
    private u f20325b;

    /* renamed from: c  reason: collision with root package name */
    private final io.d f20326c;

    /* renamed from: d  reason: collision with root package name */
    private int f20327d;

    /* renamed from: i  reason: collision with root package name */
    private final Float[] f20332i;

    /* renamed from: j  reason: collision with root package name */
    private final Float[] f20333j;

    /* renamed from: e  reason: collision with root package name */
    private final Integer[] f20328e = {Integer.valueOf(f.f34588t1), Integer.valueOf(f.f34594v1), Integer.valueOf(f.f34591u1), Integer.valueOf(f.f34585s1)};

    /* renamed from: f  reason: collision with root package name */
    private final Integer[] f20329f = {Integer.valueOf(f.H1), Integer.valueOf(f.J1), Integer.valueOf(f.I1), Integer.valueOf(f.G1)};

    /* renamed from: g  reason: collision with root package name */
    private final Float[] f20330g = {Float.valueOf(756.0f), Float.valueOf(1125.0f), Float.valueOf(1005.0f), Float.valueOf(789.0f)};

    /* renamed from: h  reason: collision with root package name */
    private final Float[] f20331h = {Float.valueOf(1101.0f), Float.valueOf(1500.0f), Float.valueOf(1077.0f), Float.valueOf(1473.0f)};

    /* renamed from: k  reason: collision with root package name */
    private final Integer[] f20334k = {Integer.valueOf(k.W4), Integer.valueOf(k.X4), Integer.valueOf(k.Y4), Integer.valueOf(k.Z4)};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WelcomeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private final int f20335a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<n> f20336b;

        public a(n fragment, int i10) {
            i.f(fragment, "fragment");
            this.f20335a = i10;
            this.f20336b = new WeakReference<>(fragment);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WelcomeActivity welcomeActivity;
            n nVar = this.f20336b.get();
            if (nVar != null && (welcomeActivity = nVar.f20324a) != null) {
                welcomeActivity.Q(this.f20335a + 1);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WelcomeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<n> f20337a;

        public b(n fragment, int i10) {
            i.f(fragment, "fragment");
            this.f20337a = new WeakReference<>(fragment);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            n nVar = this.f20337a.get();
            if (nVar != null) {
                nVar.k0();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: WelcomeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final n a(int i10) {
            n nVar = new n();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i10);
            nVar.setArguments(bundle);
            return nVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WelcomeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<n> f20338a;

        public d(n fragment) {
            i.f(fragment, "fragment");
            this.f20338a = new WeakReference<>(fragment);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            n nVar = this.f20338a.get();
            if (nVar != null) {
                nVar.j0();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            n nVar = this.f20338a.get();
            if (nVar != null) {
                nVar.g0();
            }
        }
    }

    /* compiled from: WelcomeFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements qo.a<n> {
        e() {
            super(0);
        }

        /* renamed from: a */
        public final n invoke() {
            return n.this;
        }
    }

    public n() {
        io.d a10;
        a10 = io.f.a(new e());
        this.f20326c = a10;
        Float valueOf = Float.valueOf(20.0f);
        this.f20332i = new Float[]{Float.valueOf(40.0f), Float.valueOf(30.0f), valueOf, Float.valueOf(50.0f)};
        this.f20333j = new Float[]{Float.valueOf(90.0f), Float.valueOf(0.0f), Float.valueOf(80.0f), valueOf};
    }

    private final u d0() {
        u uVar = this.f20325b;
        i.d(uVar);
        return uVar;
    }

    private final n e0() {
        return (n) this.f20326c.getValue();
    }

    private final void f0() {
        WelcomeActivity welcomeActivity = this.f20324a;
        if (welcomeActivity != null) {
            d0().f37603d.startAnimation(AnimationUtils.loadAnimation(welcomeActivity, sh.a.f34434g));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        d0().f37603d.setBackgroundResource(this.f20328e[this.f20327d].intValue());
        d0().f37603d.setVisibility(0);
    }

    private final void h0(final int i10) {
        String string = getString(this.f20334k[i10].intValue());
        i.e(string, "getString(describes[pos])");
        d0().f37604e.setText(i0.b.a(string, 0));
        if (i10 == this.f20328e.length - 1) {
            d0().f37601b.setText(k.f34774a5);
        } else {
            d0().f37601b.setText(k.f34780b5);
        }
        d0().f37601b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.welcome.fragment.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.i0(n.this, i10, view);
            }
        });
        m0(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(n this$0, int i10, View view) {
        i.f(this$0, "this$0");
        this$0.l0(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        d0().f37603d.setBackgroundResource(this.f20329f[this.f20327d].intValue());
        Drawable background = d0().f37603d.getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) background).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        WelcomeActivity welcomeActivity = this.f20324a;
        if (welcomeActivity != null) {
            int height = (d0().f37602c.getHeight() - d0().f37604e.getHeight()) - aa.d.a(this.f20332i[this.f20327d].floatValue() + this.f20333j[this.f20327d].floatValue());
            float floatValue = (this.f20330g[this.f20327d].floatValue() / this.f20331h[this.f20327d].floatValue()) * height;
            ViewGroup.LayoutParams layoutParams = d0().f37603d.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.height = height;
            marginLayoutParams.width = (int) floatValue;
            marginLayoutParams.topMargin = aa.d.a(this.f20332i[this.f20327d].floatValue());
            d0().f37603d.setLayoutParams(marginLayoutParams);
            if (this.f20327d == 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(welcomeActivity, sh.a.f34433f);
                loadAnimation.setAnimationListener(new d(e0()));
                d0().f37603d.startAnimation(loadAnimation);
                return;
            }
            Animation loadAnimation2 = AnimationUtils.loadAnimation(welcomeActivity, sh.a.f34435h);
            loadAnimation2.setAnimationListener(new d(e0()));
            d0().f37603d.startAnimation(loadAnimation2);
        }
    }

    private final void l0(int i10) {
        WelcomeActivity welcomeActivity = this.f20324a;
        if (welcomeActivity != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(welcomeActivity, sh.a.f34431d);
            loadAnimation.setAnimationListener(new a(e0(), i10));
            d0().f37604e.startAnimation(loadAnimation);
            f0();
        }
    }

    private final void m0(int i10) {
        WelcomeActivity welcomeActivity = this.f20324a;
        if (welcomeActivity != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(welcomeActivity, sh.a.f34432e);
            loadAnimation.setAnimationListener(new b(e0(), i10));
            d0().f37604e.startAnimation(loadAnimation);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        i.f(context, "context");
        super.onAttach(context);
        if (context instanceof com.mobvoi.companion.base.m3.a) {
            this.f20324a = (WelcomeActivity) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        this.f20325b = u.d(inflater, viewGroup, false);
        ConstraintLayout c10 = d0().a();
        i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f20325b = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        int i10 = arguments == null ? 0 : arguments.getInt("index");
        this.f20327d = i10;
        h0(i10);
    }
}
