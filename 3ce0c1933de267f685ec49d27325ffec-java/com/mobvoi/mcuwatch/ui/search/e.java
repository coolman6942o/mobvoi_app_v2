package com.mobvoi.mcuwatch.ui.search;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import hj.a;
import sh.h;
import sh.i;
/* compiled from: SearchGuideFragment.kt */
/* loaded from: classes2.dex */
public final class e extends a implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private final int f19996c = i.f34743l0;

    private final void f0() {
        ((Button) Y().findViewById(h.f34610a0)).setOnClickListener(this);
    }

    @Override // hj.a
    public int Z() {
        return this.f19996c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i10 = h.f34610a0;
        if (valueOf != null && valueOf.intValue() == i10) {
            ((SearchActivity) requireActivity()).I("key_scan");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        a0().setMode(1);
        f0();
    }
}
