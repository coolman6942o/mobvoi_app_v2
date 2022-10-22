package com.mobvoi.assistant.account.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.f;
import com.mobvoi.companion.base.m3.b;
import kotlin.jvm.internal.i;
import ta.a;
/* compiled from: NightModeSettingFragment.kt */
/* loaded from: classes2.dex */
public class NightModeSettingFragment extends b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private wa.b f15676b;

    private final void b0() {
        int o10 = a.o();
        if (o10 == -1) {
            a0().f36182d.setChecked(true);
            a0().f36181c.setChecked(false);
            a0().f36180b.setChecked(false);
        } else if (o10 != 2) {
            a0().f36180b.setChecked(true);
            a0().f36181c.setChecked(false);
            a0().f36182d.setChecked(false);
        } else {
            a0().f36181c.setChecked(true);
            a0().f36182d.setChecked(false);
            a0().f36180b.setChecked(false);
        }
    }

    private final void c0() {
        a0().f36180b.setOnClickListener(this);
        a0().f36181c.setOnClickListener(this);
        a0().f36182d.setOnClickListener(this);
    }

    protected final wa.b a0() {
        wa.b bVar = this.f15676b;
        i.d(bVar);
        return bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.b(view, a0().f36180b)) {
            if (a0().f36180b.isChecked()) {
                a.U(1);
                f.G(1);
                a0().f36181c.setChecked(false);
                a0().f36182d.setChecked(false);
            }
        } else if (i.b(view, a0().f36181c)) {
            if (a0().f36181c.isChecked()) {
                a.U(2);
                f.G(2);
                a0().f36180b.setChecked(false);
                a0().f36182d.setChecked(false);
            }
        } else if (i.b(view, a0().f36182d) && a0().f36182d.isChecked()) {
            a.U(-1);
            f.G(-1);
            a0().f36180b.setChecked(false);
            a0().f36181c.setChecked(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        this.f15676b = wa.b.d(inflater, viewGroup, false);
        return a0().a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        b0();
        c0();
    }
}
