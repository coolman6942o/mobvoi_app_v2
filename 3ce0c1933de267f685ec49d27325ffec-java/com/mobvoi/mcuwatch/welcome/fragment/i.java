package com.mobvoi.mcuwatch.welcome.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.mcuwatch.welcome.InitialQuestionsActivity;
import io.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.text.u;
import sh.k;
import zh.r;
/* compiled from: QuestionNameFragment.kt */
/* loaded from: classes2.dex */
public final class i extends com.mobvoi.mcuwatch.welcome.fragment.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20311d = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private r f20312b;

    /* renamed from: c  reason: collision with root package name */
    private final d f20313c;

    /* compiled from: QuestionNameFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final i a() {
            i iVar = new i();
            iVar.setArguments(new Bundle());
            return iVar;
        }
    }

    /* compiled from: QuestionNameFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<i> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final i invoke() {
            return i.this;
        }
    }

    public i() {
        d a10;
        a10 = io.f.a(new b());
        this.f20313c = a10;
    }

    private final r c0() {
        r rVar = this.f20312b;
        kotlin.jvm.internal.i.d(rVar);
        return rVar;
    }

    private final i d0() {
        return (i) this.f20313c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(i this$0, View view) {
        CharSequence E0;
        CharSequence E02;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Editable text = this$0.c0().f37591c.getText();
        kotlin.jvm.internal.i.e(text, "binding.nameEt.text");
        E0 = u.E0(text);
        if (E0.toString().length() > 0) {
            InitialQuestionsActivity Y = this$0.Y();
            if (Y != null) {
                Editable text2 = this$0.c0().f37591c.getText();
                kotlin.jvm.internal.i.e(text2, "binding.nameEt.text");
                E02 = u.E0(text2);
                Y.p0(E02.toString());
            }
            InitialQuestionsActivity Y2 = this$0.Y();
            if (Y2 != null) {
                Y2.T(1);
                return;
            }
            return;
        }
        this$0.a0(k.f34795e2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        this.f20312b = r.d(inflater, viewGroup, false);
        ConstraintLayout c10 = c0().a();
        kotlin.jvm.internal.i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f20312b = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        InitialQuestionsActivity Y = Y();
        if (Y != null && !TextUtils.isEmpty(Y.Y())) {
            d0().c0().f37591c.setText(Y.Y());
            d0().c0().f37591c.setSelection(Y.Y().length());
        }
        c0().f37590b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.welcome.fragment.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.e0(i.this, view2);
            }
        });
    }
}
