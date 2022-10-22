package com.mobvoi.mcuwatch.welcome.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.mcuwatch.welcome.InitialQuestionsActivity;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.h;
import sh.k;
import zh.p;
/* compiled from: QuestionGenderFragment.kt */
/* loaded from: classes2.dex */
public final class d extends com.mobvoi.mcuwatch.welcome.fragment.a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20300d = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private p f20301b;

    /* renamed from: c  reason: collision with root package name */
    private final io.d f20302c;

    /* compiled from: QuestionGenderFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final d a() {
            d dVar = new d();
            dVar.setArguments(new Bundle());
            return dVar;
        }
    }

    /* compiled from: QuestionGenderFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<d> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final d invoke() {
            return d.this;
        }
    }

    public d() {
        io.d a10;
        a10 = io.f.a(new b());
        this.f20302c = a10;
    }

    private final p c0() {
        p pVar = this.f20301b;
        i.d(pVar);
        return pVar;
    }

    private final d d0() {
        return (d) this.f20302c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(d this$0, View view) {
        i.f(this$0, "this$0");
        InitialQuestionsActivity Y = this$0.Y();
        if (Y != null) {
            if (Y.W() != -1) {
                Y.T(2);
            } else {
                this$0.a0(k.f34783c2);
            }
        }
    }

    private final void f0() {
        InitialQuestionsActivity Y = Y();
        if (Y != null) {
            if (Y.W() == 1) {
                d0().c0().f37581d.setChecked(true);
                d0().c0().f37580c.setChecked(false);
                return;
            }
            d0().c0().f37581d.setChecked(false);
            d0().c0().f37580c.setChecked(true);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        InitialQuestionsActivity Y;
        InitialQuestionsActivity Y2;
        Integer valueOf = compoundButton == null ? null : Integer.valueOf(compoundButton.getId());
        int i10 = h.W0;
        if (valueOf == null || valueOf.intValue() != i10) {
            int i11 = h.f34640g2;
            if (valueOf != null && valueOf.intValue() == i11 && z10 && (Y = Y()) != null) {
                Y.n0(1);
                Y.q0(AccountConstant.Sex.MALE.ordinal());
            }
        } else if (z10 && (Y2 = Y()) != null) {
            Y2.n0(0);
            Y2.q0(AccountConstant.Sex.FEMALE.ordinal());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        this.f20301b = p.d(inflater, viewGroup, false);
        ConstraintLayout c10 = c0().a();
        i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f20301b = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        f0();
        c0().f37580c.setOnCheckedChangeListener(this);
        c0().f37581d.setOnCheckedChangeListener(this);
        c0().f37579b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.welcome.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.e0(d.this, view2);
            }
        });
    }
}
