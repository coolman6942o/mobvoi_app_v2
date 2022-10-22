package com.mobvoi.companion.health;

import android.content.Context;
import androidx.lifecycle.h0;
import com.mobvoi.companion.base.m3.d;
import tn.b;
/* compiled from: Hilt_CardManagementActivity.java */
/* loaded from: classes2.dex */
public abstract class n1 extends d implements b {

    /* renamed from: a  reason: collision with root package name */
    private volatile dagger.hilt.android.internal.managers.a f16900a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f16901b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f16902c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hilt_CardManagementActivity.java */
    /* loaded from: classes2.dex */
    public class a implements androidx.activity.contextaware.d {
        a() {
        }

        @Override // androidx.activity.contextaware.d
        public void a(Context context) {
            n1.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n1() {
        H();
    }

    private void H() {
        addOnContextAvailableListener(new a());
    }

    public final dagger.hilt.android.internal.managers.a I() {
        if (this.f16900a == null) {
            synchronized (this.f16901b) {
                if (this.f16900a == null) {
                    this.f16900a = J();
                }
            }
        }
        return this.f16900a;
    }

    protected dagger.hilt.android.internal.managers.a J() {
        return new dagger.hilt.android.internal.managers.a(this);
    }

    protected void K() {
        if (!this.f16902c) {
            this.f16902c = true;
            ((j) h()).f((CardManagementActivity) tn.d.a(this));
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
