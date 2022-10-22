package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.unionpay.client3.tsm.ITsmConnection;
import com.unionpay.mobile.android.utils.k;
/* loaded from: classes2.dex */
final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f23807a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Handler handler;
        k.a("plugin-clientV3", "startSamsungService onServiceConnected");
        try {
            this.f23807a.f23802c = ITsmConnection.Stub.asInterface(iBinder);
            handler = this.f23807a.f23805f;
            handler.removeMessages(1);
            this.f23807a.a(true);
        } catch (Exception unused) {
            this.f23807a.a(false);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Handler handler;
        k.a("plugin-clientV3", "startSamsungService onServiceDisconnected");
        this.f23807a.f23802c = null;
        handler = this.f23807a.f23805f;
        handler.removeMessages(1);
        this.f23807a.a(false);
    }
}
