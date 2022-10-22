package com.unionpay.mobile.android.pboctransaction.icfcc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import b3.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f23777a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f23777a = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.unionpay.mobile.android.pboctransaction.b bVar;
        com.unionpay.mobile.android.pboctransaction.b bVar2;
        com.unionpay.mobile.android.pboctransaction.b bVar3;
        com.unionpay.mobile.android.pboctransaction.b bVar4;
        try {
            this.f23777a.f23773c = a.AbstractBinderC0064a.c(iBinder);
            bVar3 = this.f23777a.f23774d;
            if (bVar3 != null) {
                bVar4 = this.f23777a.f23774d;
                bVar4.a();
            }
        } catch (Exception unused) {
            bVar = this.f23777a.f23774d;
            if (bVar != null) {
                bVar2 = this.f23777a.f23774d;
                bVar2.b();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f23777a.f23773c = null;
    }
}
