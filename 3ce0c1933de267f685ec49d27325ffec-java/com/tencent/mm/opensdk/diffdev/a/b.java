package com.tencent.mm.opensdk.diffdev.a;

import android.os.Handler;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements OAuthListener {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ a f22459f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f22459f = aVar;
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        List list;
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        this.f22459f.f22457d = null;
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f22459f.f22456c;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        List list;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f22459f.f22456c;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Handler handler;
        Handler handler2;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        handler = this.f22459f.handler;
        if (handler != null) {
            handler2 = this.f22459f.handler;
            handler2.post(new c(this));
        }
    }
}
