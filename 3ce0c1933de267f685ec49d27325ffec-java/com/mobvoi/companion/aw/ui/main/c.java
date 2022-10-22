package com.mobvoi.companion.aw.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.health.HealthFragment;
import ei.h;
import io.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import nj.q;
/* compiled from: HealthAnalysisFragment.kt */
/* loaded from: classes2.dex */
public final class c extends HealthFragment {

    /* compiled from: HealthAnalysisFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: HealthAnalysisFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<m> {
        b() {
            super(0);
        }

        @Override // qo.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            c.this.T0("badge");
        }
    }

    /* compiled from: HealthAnalysisFragment.kt */
    /* renamed from: com.mobvoi.companion.aw.ui.main.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0199c extends Lambda implements qo.a<m> {
        C0199c() {
            super(0);
        }

        @Override // qo.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            k.a("HealthAnalysisFragment", "[MainViewModel] Notify MCU watch to sync data ");
            if (!c.this.x0() && h.a().t() && !q.g().o()) {
                c.this.N0(true);
            }
        }
    }

    static {
        new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(String str) {
        sb.a.d(requireActivity(), str);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        L0(new b());
        M0(new C0199c());
        return super.onCreateView(inflater, viewGroup, bundle);
    }

    @Override // com.mobvoi.companion.health.HealthFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sb.a.h(requireActivity(), "homeCard");
    }

    @Override // com.mobvoi.companion.health.HealthFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireActivity(), "homeCard");
    }
}
