package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
final class b implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f23797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f23797a = aVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        com.unionpay.mobile.android.pboctransaction.b bVar;
        if (message.what != 3000 || (bVar = this.f23797a.f23788a) == null) {
            return false;
        }
        bVar.b();
        return false;
    }
}
