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
/* compiled from: Hilt_SimOpenTutorialFragment.java */
/* loaded from: classes2.dex */
public abstract class m extends Fragment implements b {

    /* renamed from: a  reason: collision with root package name */
    private ContextWrapper f17223a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17224b;

    /* renamed from: c  reason: collision with root package name */
    private volatile f f17225c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f17226d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private boolean f17227e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i10) {
        super(i10);
    }

    private void a0() {
        if (this.f17223a == null) {
            this.f17223a = f.b(super.getContext(), this);
            this.f17224b = a.a(super.getContext());
        }
    }

    public final f Y() {
        if (this.f17225c == null) {
            synchronized (this.f17226d) {
                if (this.f17225c == null) {
                    this.f17225c = Z();
                }
            }
        }
        return this.f17225c;
    }

    protected f Z() {
        return new f(this);
    }

    protected void b0() {
        if (!this.f17227e) {
            this.f17227e = true;
            ((n0) h()).c((m0) d.a(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (super.getContext() == null && !this.f17224b) {
            return null;
        }
        a0();
        return this.f17223a;
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
        ContextWrapper contextWrapper = this.f17223a;
        c.c(contextWrapper == null || f.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        a0();
        b0();
    }
}
