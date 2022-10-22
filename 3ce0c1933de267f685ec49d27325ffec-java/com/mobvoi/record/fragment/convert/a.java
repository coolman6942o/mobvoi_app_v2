package com.mobvoi.record.fragment.convert;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import dagger.hilt.android.internal.managers.f;
import tn.b;
import tn.c;
import tn.d;
/* compiled from: Hilt_RecordConvertFragment.java */
/* loaded from: classes2.dex */
abstract class a extends Fragment implements b {

    /* renamed from: a  reason: collision with root package name */
    private ContextWrapper f20432a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20433b;

    /* renamed from: c  reason: collision with root package name */
    private volatile f f20434c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f20435d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private boolean f20436e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
    }

    private void a0() {
        if (this.f20432a == null) {
            this.f20432a = f.b(super.getContext(), this);
            this.f20433b = on.a.a(super.getContext());
        }
    }

    public final f Y() {
        if (this.f20434c == null) {
            synchronized (this.f20435d) {
                if (this.f20434c == null) {
                    this.f20434c = Z();
                }
            }
        }
        return this.f20434c;
    }

    protected f Z() {
        return new f(this);
    }

    protected void b0() {
        if (!this.f20436e) {
            this.f20436e = true;
            ((c) h()).e((RecordConvertFragment) d.a(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (super.getContext() == null && !this.f20433b) {
            return null;
        }
        a0();
        return this.f20432a;
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

    a(int i10) {
        super(i10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ContextWrapper contextWrapper = this.f20432a;
        c.c(contextWrapper == null || f.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        a0();
        b0();
    }
}
