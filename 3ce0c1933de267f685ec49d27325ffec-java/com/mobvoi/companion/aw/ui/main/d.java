package com.mobvoi.companion.aw.ui.main;

import android.content.Context;
import androidx.lifecycle.h0;
import tn.b;
/* compiled from: Hilt_HomeActivity.java */
/* loaded from: classes2.dex */
abstract class d extends androidx.appcompat.app.d implements b {

    /* renamed from: a  reason: collision with root package name */
    private volatile dagger.hilt.android.internal.managers.a f16298a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f16299b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f16300c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hilt_HomeActivity.java */
    /* loaded from: classes2.dex */
    public class a implements androidx.activity.contextaware.d {
        a() {
        }

        @Override // androidx.activity.contextaware.d
        public void a(Context context) {
            d.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        G();
    }

    private void G() {
        addOnContextAvailableListener(new a());
    }

    public final dagger.hilt.android.internal.managers.a H() {
        if (this.f16298a == null) {
            synchronized (this.f16299b) {
                if (this.f16298a == null) {
                    this.f16298a = I();
                }
            }
        }
        return this.f16298a;
    }

    protected dagger.hilt.android.internal.managers.a I() {
        return new dagger.hilt.android.internal.managers.a(this);
    }

    protected void J() {
        if (!this.f16300c) {
            this.f16300c = true;
            ((o) h()).h((HomeActivity) tn.d.a(this));
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
