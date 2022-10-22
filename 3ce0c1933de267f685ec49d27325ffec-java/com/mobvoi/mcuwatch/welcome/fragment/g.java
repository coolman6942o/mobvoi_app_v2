package com.mobvoi.mcuwatch.welcome.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.mcuwatch.welcome.InitialQuestionsActivity;
import com.mobvoi.wear.util.UnitsUtility;
import io.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import sh.k;
import so.c;
import zh.q;
/* compiled from: QuestionHeightFragment.kt */
/* loaded from: classes2.dex */
public final class g extends com.mobvoi.mcuwatch.welcome.fragment.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f20305f = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private q f20306b;

    /* renamed from: c  reason: collision with root package name */
    private final d f20307c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20308d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20309e;

    /* compiled from: QuestionHeightFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final g a() {
            g gVar = new g();
            gVar.setArguments(new Bundle());
            return gVar;
        }
    }

    /* compiled from: QuestionHeightFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<g> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final g invoke() {
            return g.this;
        }
    }

    public g() {
        d a10;
        a10 = io.f.a(new b());
        this.f20307c = a10;
    }

    private final void d0() {
        if (this.f20308d) {
            e0().f37585d.setText(getString(k.R0));
            e0().f37587f.setText(getString(k.T0));
        } else {
            e0().f37585d.setText(getString(k.f34844o1));
            e0().f37587f.setText(getString(k.f34843o0));
        }
        if (this.f20309e) {
            this.f20309e = false;
            return;
        }
        e0().f37584c.setText("");
        e0().f37586e.setText("");
    }

    private final q e0() {
        q qVar = this.f20306b;
        i.d(qVar);
        return qVar;
    }

    private final g f0() {
        return (g) this.f20307c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(g this$0, CompoundButton compoundButton, boolean z10) {
        i.f(this$0, "this$0");
        this$0.f20308d = z10;
        this$0.d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(g this$0, View view) {
        CharSequence E0;
        CharSequence E02;
        CharSequence E03;
        CharSequence E04;
        int b10;
        i.f(this$0, "this$0");
        Editable text = this$0.e0().f37584c.getText();
        i.e(text, "binding.ftEt.text");
        E0 = u.E0(text);
        boolean z10 = true;
        if (E0.toString().length() > 0) {
            Editable text2 = this$0.e0().f37586e.getText();
            i.e(text2, "binding.inEt.text");
            E02 = u.E0(text2);
            if (E02.toString().length() <= 0) {
                z10 = false;
            }
            if (z10) {
                InitialQuestionsActivity Y = this$0.Y();
                if (Y != null) {
                    Editable text3 = this$0.f0().e0().f37584c.getText();
                    i.e(text3, "instance.binding.ftEt.text");
                    E03 = u.E0(text3);
                    float parseFloat = Float.parseFloat(E03.toString());
                    Editable text4 = this$0.f0().e0().f37586e.getText();
                    i.e(text4, "instance.binding.inEt.text");
                    E04 = u.E0(text4);
                    float parseFloat2 = Float.parseFloat(E04.toString());
                    b10 = c.b(this$0.f20308d ? UnitsUtility.inch2Cm(parseFloat, parseFloat2) : (100 * parseFloat) + parseFloat2);
                    Y.o0(b10);
                    if (Y.X() > 300 || Y.X() < 60) {
                        this$0.a0(k.U0);
                        return;
                    } else {
                        Y.T(4);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        this$0.a0(k.f34789d2);
    }

    private final void i0() {
        int b10;
        int b11;
        InitialQuestionsActivity Y = Y();
        if (Y != null && Y.X() != 0) {
            int X = Y.X() / 100;
            int X2 = Y.X() % 100;
            String valueOf = String.valueOf(X);
            String valueOf2 = String.valueOf(X2);
            if (this.f20308d) {
                b10 = c.b(UnitsUtility.Length.m2ft(X));
                valueOf = String.valueOf(b10);
                b11 = c.b(UnitsUtility.Length.cm2inch(X2));
                valueOf2 = String.valueOf(b11);
            }
            f0().e0().f37584c.setText(valueOf);
            f0().e0().f37586e.setText(valueOf2);
            this.f20309e = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        this.f20306b = q.d(inflater, viewGroup, false);
        ConstraintLayout c10 = e0().a();
        i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f20306b = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.fragment.app.f activity = getActivity();
        boolean z10 = true;
        if (activity == null || !Z(activity)) {
            z10 = false;
        }
        this.f20308d = z10;
        e0().f37588g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.welcome.fragment.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                g.g0(g.this, compoundButton, z11);
            }
        });
        i0();
        e0().f37588g.setChecked(this.f20308d);
        if (this.f20308d) {
            this.f20309e = false;
        }
        e0().f37583b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.welcome.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.h0(g.this, view2);
            }
        });
    }
}
