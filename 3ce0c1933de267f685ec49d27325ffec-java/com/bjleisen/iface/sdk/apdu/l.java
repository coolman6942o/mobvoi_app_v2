package com.bjleisen.iface.sdk.apdu;

import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public final class l implements ApduLocalMultiExeCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f7776a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f7776a = kVar;
    }

    @Override // com.bjleisen.iface.sdk.apdu.ApduLocalMultiExeCallback
    public final void closeSEChannel() {
        k.d(this.f7776a);
    }

    @Override // com.bjleisen.iface.sdk.apdu.ApduLocalMultiExeCallback
    public final Rapdu transiveAPDU(String str) {
        c cVar;
        c cVar2;
        Rapdu rapdu;
        this.f7776a.f7771v = false;
        this.f7776a.f7774y = null;
        this.f7776a.f7770u = true;
        cVar = this.f7776a.f7762m;
        cVar.a(new Capdu(0, str, new String[]{"9000"}));
        cVar2 = this.f7776a.f7762m;
        cVar2.run();
        rapdu = this.f7776a.f7774y;
        return rapdu;
    }
}
