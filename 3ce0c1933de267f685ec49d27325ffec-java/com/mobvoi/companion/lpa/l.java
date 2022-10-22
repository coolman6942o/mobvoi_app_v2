package com.mobvoi.companion.lpa;

import android.content.Context;
import androidx.lifecycle.h0;
import com.mobvoi.companion.base.m3.d;
import tn.b;
/* compiled from: Hilt_SimOpenBaseActivity.java */
/* loaded from: classes2.dex */
public abstract class l extends d implements b {

    /* renamed from: a  reason: collision with root package name */
    private volatile dagger.hilt.android.internal.managers.a f17218a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f17219b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f17220c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hilt_SimOpenBaseActivity.java */
    /* loaded from: classes2.dex */
    public class a implements androidx.activity.contextaware.d {
        a() {
        }

        @Override // androidx.activity.contextaware.d
        public void a(Context context) {
            l.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l() {
        H();
    }

    private void H() {
        addOnContextAvailableListener(new a());
    }

    public final dagger.hilt.android.internal.managers.a I() {
        if (this.f17218a == null) {
            synchronized (this.f17219b) {
                if (this.f17218a == null) {
                    this.f17218a = J();
                }
            }
        }
        return this.f17218a;
    }

    protected dagger.hilt.android.internal.managers.a J() {
        return new dagger.hilt.android.internal.managers.a(this);
    }

    protected void K() {
        if (!this.f17220c) {
            this.f17220c = true;
            ((h0) h()).e((SimOpenBaseActivity) tn.d.a(this));
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.j
    public h0.b getDefaultViewModelProviderFactory() {
        return rn.a.a(this, super.getDefaultViewModelProviderFactory());
    }

    @Override // tn.b
    public final Object h() {
        return I().h();
    }
}
