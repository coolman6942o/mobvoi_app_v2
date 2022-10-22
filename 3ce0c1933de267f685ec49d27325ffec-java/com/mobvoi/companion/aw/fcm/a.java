package com.mobvoi.companion.aw.fcm;

import com.google.firebase.iid.FirebaseInstanceIdService;
import dagger.hilt.android.internal.managers.g;
import tn.b;
import tn.d;
/* compiled from: Hilt_MyFirebaseInstanceIDService.java */
/* loaded from: classes2.dex */
abstract class a extends FirebaseInstanceIdService implements b {

    /* renamed from: f  reason: collision with root package name */
    private volatile g f16262f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f16263g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private boolean f16264h = false;

    public final g g() {
        if (this.f16262f == null) {
            synchronized (this.f16263g) {
                if (this.f16262f == null) {
                    this.f16262f = i();
                }
            }
        }
        return this.f16262f;
    }

    @Override // tn.b
    public final Object h() {
        return g().h();
    }

    protected g i() {
        return new g(this);
    }

    protected void j() {
        if (!this.f16264h) {
            this.f16264h = true;
            ((b) h()).a((MyFirebaseInstanceIDService) d.a(this));
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        j();
        super.onCreate();
    }
}
