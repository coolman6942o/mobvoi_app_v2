package com.mobvoi.companion.lpa;

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
/* compiled from: Hilt_EnableSuccessFragment.java */
/* loaded from: classes2.dex */
public abstract class j extends Fragment implements b {

    /* renamed from: a  reason: collision with root package name */
    private ContextWrapper f17204a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17205b;

    /* renamed from: c  reason: collision with root package name */
    private volatile f f17206c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f17207d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private boolean f17208e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i10) {
        super(i10);
    }

    private void a0() {
        if (this.f17204a == null) {
            this.f17204a = f.b(super.getContext(), this);
            this.f17205b = a.a(super.getContext());
        }
    }

    public final f Y() {
        if (this.f17206c == null) {
            synchronized (this.f17207d) {
                if (this.f17206c == null) {
                    this.f17206c = Z();
                }
            }
        }
        return this.f17206c;
    }

    protected f Z() {
        return new f(this);
    }

    protected void b0() {
        if (!this.f17208e) {
            this.f17208e = true;
            ((f) h()).g((e) d.a(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (super.getContext() == null && !this.f17205b) {
            return null;
        }
        a0();
        return this.f17204a;
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
        ContextWrapper contextWrapper = this.f17204a;
        c.c(contextWrapper == null || f.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        a0();
        b0();
    }
}
