package com.mobvoi.companion.aw.base;

import android.app.Application;
import dagger.hilt.android.internal.managers.d;
import dagger.hilt.android.internal.managers.e;
import sn.c;
import tn.b;
/* compiled from: Hilt_App.java */
/* loaded from: classes2.dex */
abstract class n extends Application implements b {

    /* renamed from: a  reason: collision with root package name */
    private final d f16259a = new d(new a());

    /* compiled from: Hilt_App.java */
    /* loaded from: classes2.dex */
    class a implements e {
        a() {
        }

        @Override // dagger.hilt.android.internal.managers.e
        public Object get() {
            return m.s().a(new c(n.this)).b();
        }
    }

    public final d a() {
        return this.f16259a;
    }

    @Override // tn.b
    public final Object h() {
        return a().h();
    }

    @Override // android.app.Application
    public void onCreate() {
        ((e) h()).b((App) tn.d.a(this));
        super.onCreate();
    }
}
