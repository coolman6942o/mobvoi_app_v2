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
/* compiled from: Hilt_HealthFragment.java */
/* loaded from: classes2.dex */
public abstract class p1 extends Fragment implements b {

    /* renamed from: a  reason: collision with root package name */
    private ContextWrapper f16919a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16920b;

    /* renamed from: c  reason: collision with root package name */
    private volatile f f16921c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f16922d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private boolean f16923e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p1(int i10) {
        super(i10);
    }

    private void a0() {
        if (this.f16919a == null) {
            this.f16919a = f.b(super.getContext(), this);
            this.f16920b = a.a(super.getContext());
        }
    }

    public final f Y() {
        if (this.f16921c == null) {
            synchronized (this.f16922d) {
                if (this.f16921c == null) {
                    this.f16921c = Z();
                }
            }
        }
        return this.f16921c;
    }

    protected f Z() {
        return new f(this);
    }

    protected void b0() {
        if (!this.f16923e) {
            this.f16923e = true;
            ((i1) h()).i((HealthFragment) d.a(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (super.getContext() == null && !this.f16920b) {
            return null;
        }
        a0();
        return this.f16919a;
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
        ContextWrapper contextWrapper = this.f16919a;
        c.c(contextWrapper == null || f.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        a0();
        b0();
    }
}
