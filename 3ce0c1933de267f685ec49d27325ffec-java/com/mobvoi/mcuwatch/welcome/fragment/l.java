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
import zh.s;
/* compiled from: QuestionWeightFragment.kt */
/* loaded from: classes2.dex */
public final class l extends com.mobvoi.mcuwatch.welcome.fragment.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f20316f = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private s f20317b;

    /* renamed from: c  reason: collision with root package name */
    private final d f20318c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20319d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20320e = true;

    /* compiled from: QuestionWeightFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final l a() {
            l lVar = new l();
            lVar.setArguments(new Bundle());
            return lVar;
        }
    }

    /* compiled from: QuestionWeightFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<l> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final l invoke() {
            return l.this;
        }
    }

    public l() {
        d a10;
        a10 = io.f.a(new b());
        this.f20318c = a10;
    }

    private final void d0() {
        if (this.f20319d) {
            e0().f37596e.setText(getString(k.Y0));
        } else {
            e0().f37596e.setText(getString(k.V0));
        }
        if (this.f20320e) {
            this.f20320e = false;
        } else {
            e0().f37595d.setText("");
        }
    }

    private final s e0() {
        s sVar = this.f20317b;
        i.d(sVar);
        return sVar;
    }

    private final l f0() {
        return (l) this.f20318c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(l this$0, CompoundButton compoundButton, boolean z10) {
        i.f(this$0, "this$0");
        this$0.f20319d = z10;
        this$0.d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(l this$0, View view) {
        CharSequence E0;
        CharSequence E02;
        int b10;
        i.f(this$0, "this$0");
        Editable text = this$0.e0().f37595d.getText();
        i.e(text, "binding.weightEt.text");
        E0 = u.E0(text);
        if (E0.toString().length() > 0) {
            InitialQuestionsActivity Y = this$0.Y();
            if (Y != null) {
                Editable text2 = this$0.f0().e0().f37595d.getText();
                i.e(text2, "instance.binding.weightEt.text");
                E02 = u.E0(text2);
                float parseFloat = Float.parseFloat(E02.toString());
                if (this$0.f20319d) {
                    parseFloat = UnitsUtility.pound2KgValue(parseFloat);
                }
                b10 = c.b(parseFloat);
                Y.r0(b10);
                if (Y.Z() > 220 || Y.Z() < 20) {
                    this$0.a0(k.U0);
                } else {
                    Y.d0();
                }
            }
        } else {
            this$0.a0(k.f34800f2);
        }
    }

    private final void i0() {
        int b10;
        InitialQuestionsActivity Y = Y();
        if (Y != null && Y.Z() != 0) {
            String valueOf = String.valueOf(Y.Z());
            if (this.f20319d) {
                b10 = c.b(UnitsUtility.kg2Pound(Y.Z()));
                valueOf = String.valueOf(b10);
            }
            f0().e0().f37595d.setText(valueOf);
            this.f20320e = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        this.f20317b = s.d(inflater, viewGroup, false);
        ConstraintLayout c10 = e0().a();
        i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f20317b = null;
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
        this.f20319d = z10;
        e0().f37594c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.welcome.fragment.k
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                l.g0(l.this, compoundButton, z11);
            }
        });
        i0();
        e0().f37594c.setChecked(this.f20319d);
        if (this.f20319d) {
            this.f20320e = false;
        }
        e0().f37593b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.welcome.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                l.h0(l.this, view2);
            }
        });
    }
}
