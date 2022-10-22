package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.RemoteException;
import com.alipay.sdk.app.PayTask;
import com.unionpay.client3.tsm.ITsmConnection;
import com.unionpay.client3.tsm.SeAppInfo;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private Context f23800a;

    /* renamed from: b  reason: collision with root package name */
    private com.unionpay.mobile.android.pboctransaction.b f23801b;

    /* renamed from: c  reason: collision with root package name */
    private ITsmConnection f23802c;

    /* renamed from: d  reason: collision with root package name */
    private int f23803d = 0;

    /* renamed from: e  reason: collision with root package name */
    private Handler.Callback f23804e = new c(this);

    /* renamed from: f  reason: collision with root package name */
    private Handler f23805f = new Handler(this.f23804e);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10) {
        com.unionpay.mobile.android.pboctransaction.b bVar = this.f23801b;
        if (bVar == null) {
            return;
        }
        if (z10) {
            bVar.a();
        } else {
            bVar.b();
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final String a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final ArrayList<com.unionpay.mobile.android.model.c> a(d dVar) {
        RemoteException e10;
        Exception e11;
        ITsmConnection iTsmConnection = this.f23802c;
        ArrayList<com.unionpay.mobile.android.model.c> arrayList = null;
        if (iTsmConnection == null) {
            return null;
        }
        try {
            SeAppInfo[] seApps = iTsmConnection.getSeApps(this.f23803d);
            if (seApps == null || seApps.length <= 0) {
                return null;
            }
            ArrayList<com.unionpay.mobile.android.model.c> arrayList2 = new ArrayList<>();
            for (int i10 = 0; i10 < seApps.length; i10++) {
                try {
                    String appAid = seApps[i10].getAppAid();
                    if (appAid != null && appAid.startsWith("A000000333")) {
                        String appAid2 = seApps[i10].getAppAid();
                        if (!(appAid2 == null || appAid2.length() <= 16 || "06".equalsIgnoreCase(appAid2.substring(14, 16)))) {
                            arrayList2.add(new a(1, seApps[i10].getAppAid(), "", seApps[i10].getPan(), 1));
                        }
                    }
                } catch (RemoteException e12) {
                    e10 = e12;
                    arrayList = arrayList2;
                    e10.printStackTrace();
                    return arrayList;
                } catch (Exception e13) {
                    e11 = e13;
                    arrayList = arrayList2;
                    e11.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (RemoteException e14) {
            e10 = e14;
        } catch (Exception e15) {
            e11 = e15;
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a(com.unionpay.mobile.android.pboctransaction.b bVar, Context context) {
        this.f23801b = bVar;
        this.f23800a = context;
        try {
            Intent intent = new Intent();
            intent.setAction("com.unionpay.client3.action.TSM_MODEL");
            intent.setPackage("com.unionpay");
            context.startService(intent);
            if (!context.bindService(intent, new d(this), 1)) {
                k.a("plugin-clientV3", "startSamsungService() failed!!!");
                a(false);
                return;
            }
            this.f23805f.sendMessageDelayed(this.f23805f.obtainMessage(1), PayTask.f6879j);
        } catch (Exception unused) {
            a(false);
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final byte[] a(byte[] bArr, int i10) {
        if (this.f23802c != null) {
            try {
                k.a("plugin-clientV3", "--->" + e.a(bArr));
                String sendApdu = this.f23802c.sendApdu(this.f23803d, e.a(bArr), i10);
                k.a("plugin-clientV3", "<---" + sendApdu);
                return e.a(sendApdu);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void b() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void c() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void d() {
    }
}
