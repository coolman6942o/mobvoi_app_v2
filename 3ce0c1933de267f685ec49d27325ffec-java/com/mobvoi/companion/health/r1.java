package com.mobvoi.companion.health;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import dagger.hilt.android.internal.managers.f;
import on.a;
import tn.b;
import tn.c;
import tn.d;
/* compiled from: Hilt_TicCareHealthFragment.java */
/* loaded from: classes2.dex */
public abstract class r1 extends Fragment implements b {

    /* renamed from: a  reason: collision with root package name */
    private ContextWrapper f16943a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16944b;

    /* renamed from: c  reason: collision with root package name */
    private volatile f f16945c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f16946d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private boolean f16947e = false;

    private void a0() {
        if (this.f16943a == null) {
            this.f16943a = f.b(super.getContext(), this);
            this.f16944b = a.a(super.getContext());
        }
    }

    public final f Y() {
        if (this.f16945c == null) {
            synchronized (this.f16946d) {
                if (this.f16945c == null) {
                    this.f16945c = Z();
                }
            }
        }
        return this.f16945c;
    }

    protected f Z() {
        return new f(this);
    }

    protected void b0() {
        if (!this.f16947e) {
            this.f16947e = true;
            ((x3) h()).j((w3) d.a(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (super.getContext() == null && !this.f16944b) {
            return null;
        }
        a0();
        return this.f16943a;
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.j
    public h0.b getDefaultViewModelProviderFactory() {
        return rn.a.b(this, super.getDefaultViewModelProviderFactory());
    }

    @Override // tn.b
    public final Object h() {
        return Y().h();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        a0();
        b0();
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return LayoutInflater.from(f.c(super.onGetLayoutInflater(bundle), this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ContextWrapper contextWrapper = this.f16943a;
        c.c(contextWrapper == null || f.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        a0();
        b0();
    }
}
