package com.bjleisen.iface.sdk.apdu;

import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.oma.ErrorInfo;
import h9.b;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public final class w extends d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f7787a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(k kVar) {
        this.f7787a = kVar;
    }

    @Override // com.bjleisen.iface.sdk.apdu.d
    public final void a(List<Rapdu> list) {
        boolean z10;
        String str;
        int i10;
        boolean z11;
        z10 = this.f7787a.f7770u;
        if (z10) {
            if (list != null && list.size() > 0) {
                this.f7787a.f7774y = list.get(0);
            }
            this.f7787a.f7770u = false;
            return;
        }
        if (list != null && list.size() > 0) {
            i10 = this.f7787a.f7765p;
            if (i10 == 5) {
                z11 = this.f7787a.f7773x;
                if (z11) {
                    list.remove(0);
                }
            }
        }
        k kVar = this.f7787a;
        str = kVar.f7764o;
        k.a(kVar, str, list);
    }

    @Override // com.bjleisen.iface.sdk.apdu.d
    public final void b(Rapdu rapdu) {
        g gVar;
        g gVar2;
        k.d(this.f7787a);
        gVar = this.f7787a.f7769t;
        if (gVar != null) {
            gVar2 = this.f7787a.f7769t;
            gVar2.onOperSuccess(rapdu);
        }
    }

    @Override // com.bjleisen.iface.sdk.apdu.d
    public final void b(int i10, Error error) {
        boolean z10;
        g gVar;
        g gVar2;
        k.d(this.f7787a);
        b.e("RequestManager", "onFailure:" + i10 + ",ErrorMsg:" + error.getMessage());
        z10 = this.f7787a.f7770u;
        if (z10) {
            if (error instanceof ErrorInfo) {
                this.f7787a.f7774y = new Rapdu(0, null, String.valueOf(((ErrorInfo) error).getErrorCode()));
            } else {
                this.f7787a.f7774y = new Rapdu(0, null, String.valueOf(i10));
            }
            this.f7787a.f7770u = false;
            return;
        }
        gVar = this.f7787a.f7769t;
        if (gVar != null) {
            gVar2 = this.f7787a.f7769t;
            gVar2.onOperFailure(i10, error);
        }
    }

    @Override // com.bjleisen.iface.sdk.apdu.d
    public final void b(int i10, List<Rapdu> list, Error error) {
        boolean z10;
        String str;
        int i11;
        boolean z11;
        b.e("RequestManager", "OnSendNextError:" + i10 + "," + error.getMessage());
        z10 = this.f7787a.f7770u;
        if (z10) {
            if (error instanceof ErrorInfo) {
                this.f7787a.f7774y = new Rapdu(0, null, String.valueOf(((ErrorInfo) error).getErrorCode()));
            }
            this.f7787a.f7770u = false;
            return;
        }
        this.f7787a.f7768s = error;
        if (list != null && list.size() > 0) {
            i11 = this.f7787a.f7765p;
            if (i11 == 5) {
                z11 = this.f7787a.f7773x;
                if (z11) {
                    list.remove(0);
                }
            }
        }
        k kVar = this.f7787a;
        str = kVar.f7764o;
        k.a(kVar, str, list);
    }
}
