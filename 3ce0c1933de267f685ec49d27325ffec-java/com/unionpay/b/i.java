package com.unionpay.b;

import android.util.Log;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.mi.UPTsmAddon;
import com.unionpay.utils.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements UPTsmAddon.UPTsmConnectionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f23297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f23297a = gVar;
    }

    @Override // com.unionpay.tsmservice.mi.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmConnected() {
        j.b("uppay", "mi TsmService connected.");
        this.f23297a.b();
    }

    @Override // com.unionpay.tsmservice.mi.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmDisconnected() {
        String str;
        String str2;
        Log.e("uppay", "mi TsmService disconnected.");
        g gVar = this.f23297a;
        str = gVar.f23289d;
        str2 = this.f23297a.f23290e;
        gVar.a(str, str2, UPSEInfoResp.ERROR_NONE, "Tsm service disconnect");
    }
}
