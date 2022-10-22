package com.mobvoi.companion.lpa;

import android.content.Context;
import androidx.appcompat.app.d;
import androidx.lifecycle.h0;
import tn.b;
/* compiled from: Hilt_JupiterEsimActivity.java */
/* loaded from: classes2.dex */
public abstract class k extends d implements b {

    /* renamed from: a  reason: collision with root package name */
    private volatile dagger.hilt.android.internal.managers.a f17213a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f17214b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f17215c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hilt_JupiterEsimActivity.java */
    /* loaded from: classes2.dex */
    public class a implements androidx.activity.contextaware.d {
        a() {
        }

        @Override // androidx.activity.contextaware.d
        public void a(Context context) {
            k.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k() {
        G();
    }

    private void G() {
        addOnContextAvailableListener(new a());
    }

    public final dagger.hilt.android.internal.managers.a H() {
        if (this.f17213a == null) {
            synchronized (this.f17214b) {
                if (this.f17213a == null) {
                    this.f17213a = I();
                }
            }
        }
        return this.f17213a;
    }

    protected dagger.hilt.android.internal.managers.a I() {
        return new dagger.hilt.android.internal.managers.a(this);
    }

    protected void J() {
        if (!this.f17215c) {
            this.f17215c = true;
            ((q) h()).g((JupiterEsimActivity) tn.d.a(this));
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
