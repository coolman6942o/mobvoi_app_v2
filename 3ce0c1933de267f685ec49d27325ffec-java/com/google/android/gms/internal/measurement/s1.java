package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s1 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q1 f9651a;

    private s1(q1 q1Var) {
        this.f9651a = q1Var;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            q1.a(this.f9651a).c().N().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            this.f9651a.f9604b = o6.m1(iBinder);
            if (this.f9651a.f9604b == null) {
                q1.a(this.f9651a).c().N().a("Install Referrer Service implementation was not found");
                return;
            }
            q1.a(this.f9651a).c().P().a("Install Referrer Service connected");
            q1.a(this.f9651a).d().J(new t1(this));
        } catch (Exception e10) {
            q1.a(this.f9651a).c().N().d("Exception occurred while calling Install Referrer API", e10);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f9651a.f9604b = null;
        q1.a(this.f9651a).c().P().a("Install Referrer Service disconnected");
    }
}
