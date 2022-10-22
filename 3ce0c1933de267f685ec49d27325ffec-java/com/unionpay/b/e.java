package com.unionpay.b;

import android.util.Log;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.utils.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements UPTsmAddon.UPTsmConnectionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23284a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f23284a = bVar;
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmConnected() {
        j.b("uppay", "TsmService connected.");
        this.f23284a.b();
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmDisconnected() {
        String str;
        String str2;
        Log.e("uppay", "TsmService disconnected.");
        b bVar = this.f23284a;
        str = bVar.f23274d;
        str2 = this.f23284a.f23275e;
        bVar.a(str, str2, UPSEInfoResp.ERROR_NONE, "Tsm service disconnect");
    }
}
