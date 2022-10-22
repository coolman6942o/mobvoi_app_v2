package com.unionpay.mobile.android.pboctransaction.samsung;

import android.util.Log;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.UPTsmAddon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements UPTsmAddon.UPTsmConnectionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f23837a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.f23837a = fVar;
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmConnected() {
        k.c("uppay", "TsmService connected.");
        this.f23837a.f();
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmDisconnected() {
        Log.e("uppay", "TsmService disconnected.");
        this.f23837a.a(false);
    }
}
