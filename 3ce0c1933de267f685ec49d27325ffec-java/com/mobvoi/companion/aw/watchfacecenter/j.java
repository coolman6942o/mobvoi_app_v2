package com.mobvoi.companion.aw.watchfacecenter;

import android.content.Context;
import androidx.activity.contextaware.d;
import androidx.lifecycle.h0;
import com.mobvoi.companion.base.m3.e;
import p1.a;
import tn.b;
/* compiled from: Hilt_AWWatchFaceActivity.java */
/* loaded from: classes2.dex */
public abstract class j<VB extends p1.a> extends e<VB> implements b {

    /* renamed from: b  reason: collision with root package name */
    private volatile dagger.hilt.android.internal.managers.a f16450b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f16451c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private boolean f16452d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hilt_AWWatchFaceActivity.java */
    /* loaded from: classes2.dex */
    public class a implements d {
        a() {
        }

        @Override // androidx.activity.contextaware.d
        public void a(Context context) {
            j.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j() {
        J();
    }

    private void J() {
        addOnContextAvailableListener(new a());
    }

    public final dagger.hilt.android.internal.managers.a K() {
        if (this.f16450b == null) {
            synchronized (this.f16451c) {
                if (this.f16450b == null) {
                    this.f16450b = L();
                }
            }
        }
        return this.f16450b;
    }

    protected dagger.hilt.android.internal.managers.a L() {
        return new dagger.hilt.android.internal.managers.a(this);
    }

    protected void M() {
        if (!this.f16452d) {
            this.f16452d = true;
            ((e) h()).c((AWWatchFaceActivity) tn.d.a(this));
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.j
    public h0.b getDefaultViewModelProviderFactory() {
        return rn.a.a(this, super.getDefaultViewModelProviderFactory());
    }

    @Override // tn.b
    public final Object h() {
        return K().h();
    }
}
