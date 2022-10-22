package com.mobvoi.record;

import android.content.Context;
import androidx.activity.contextaware.d;
import androidx.lifecycle.h0;
import tn.b;
/* compiled from: Hilt_RecordActivity.java */
/* loaded from: classes2.dex */
abstract class a extends com.mobvoi.companion.base.m3.a implements b {

    /* renamed from: a  reason: collision with root package name */
    private volatile dagger.hilt.android.internal.managers.a f20399a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f20400b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f20401c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hilt_RecordActivity.java */
    /* renamed from: com.mobvoi.record.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0235a implements d {
        C0235a() {
        }

        @Override // androidx.activity.contextaware.d
        public void a(Context context) {
            a.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        G();
    }

    private void G() {
        addOnContextAvailableListener(new C0235a());
    }

    public final dagger.hilt.android.internal.managers.a H() {
        if (this.f20399a == null) {
            synchronized (this.f20400b) {
                if (this.f20399a == null) {
                    this.f20399a = I();
                }
            }
        }
        return this.f20399a;
    }

    protected dagger.hilt.android.internal.managers.a I() {
        return new dagger.hilt.android.internal.managers.a(this);
    }

    protected void J() {
        if (!this.f20401c) {
            this.f20401c = true;
            ((m) h()).j((RecordActivity) tn.d.a(this));
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
