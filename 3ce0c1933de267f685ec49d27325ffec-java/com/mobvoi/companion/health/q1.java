package com.mobvoi.companion.health;

import android.content.Context;
import androidx.activity.contextaware.d;
import androidx.lifecycle.h0;
import tn.b;
/* compiled from: Hilt_MedalCenterActivity.java */
/* loaded from: classes2.dex */
public abstract class q1 extends com.mobvoi.companion.base.m3.a implements b {

    /* renamed from: a  reason: collision with root package name */
    private volatile dagger.hilt.android.internal.managers.a f16936a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f16937b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f16938c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hilt_MedalCenterActivity.java */
    /* loaded from: classes2.dex */
    public class a implements d {
        a() {
        }

        @Override // androidx.activity.contextaware.d
        public void a(Context context) {
            q1.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q1() {
        G();
    }

    private void G() {
        addOnContextAvailableListener(new a());
    }

    public final dagger.hilt.android.internal.managers.a H() {
        if (this.f16936a == null) {
            synchronized (this.f16937b) {
                if (this.f16936a == null) {
                    this.f16936a = I();
                }
            }
        }
        return this.f16936a;
    }

    protected dagger.hilt.android.internal.managers.a I() {
        return new dagger.hilt.android.internal.managers.a(this);
    }

    protected void J() {
        if (!this.f16938c) {
            this.f16938c = true;
            ((b3) h()).d((MedalCenterActivity) tn.d.a(this));
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.j
    public h0.b getDefaultViewModelProviderFactory() {
        return rn.a.a(this, super.getDefaultViewModelProviderFactory());
    }

    @Override // tn.b
    public final Object h() {
        return H().h();
    }
}
