package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.tsm.connect.IInitCallback;
import com.unionpay.mobile.tsm.connect.IRemoteApdu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    b f23788a;

    /* renamed from: b  reason: collision with root package name */
    private IRemoteApdu f23789b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23790c = false;

    /* renamed from: d  reason: collision with root package name */
    private Context f23791d = null;

    /* renamed from: e  reason: collision with root package name */
    private Handler f23792e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23793f = false;

    /* renamed from: g  reason: collision with root package name */
    private final Handler.Callback f23794g = new b(this);

    /* renamed from: h  reason: collision with root package name */
    private final ServiceConnection f23795h = new c(this);

    /* renamed from: i  reason: collision with root package name */
    private final IInitCallback.Stub f23796i = new d(this);

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final String a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final ArrayList<com.unionpay.mobile.android.model.c> a(d dVar) {
        ArrayList<AppIdentification> arrayList;
        String c10;
        k.a("plugin-tsm", "RemoteApduEngine.readList() +++");
        ArrayList<com.unionpay.mobile.android.model.c> arrayList2 = null;
        try {
            String str = this.f23790c ? "D15600010100016111000000B0004101" : "D15600010100016111000000B0004001";
            k.a("plugin-tsm", "sid=" + str);
            IRemoteApdu iRemoteApdu = this.f23789b;
            String writeApdu = iRemoteApdu.writeApdu("00a4040010" + str, 0);
            if (writeApdu != null && writeApdu.equalsIgnoreCase("9000")) {
                writeApdu = this.f23789b.writeApdu("80CA2F0000", 0);
            }
            arrayList = e.b(writeApdu);
        } catch (Exception e10) {
            e10.printStackTrace();
            k.c("plugin-tsm", e10.getMessage());
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2 = new ArrayList<>();
            Iterator<AppIdentification> it = arrayList.iterator();
            while (it.hasNext()) {
                AppIdentification next = it.next();
                if (next.c() && !"06".equalsIgnoreCase(next.b()) && (c10 = e.c(dVar.a(next))) != null && c10.length() > 0) {
                    arrayList2.add(new com.unionpay.mobile.android.model.a(4, next.a(), "", c10, 1));
                }
            }
        }
        k.a("plugin-tsm", "RemoteApduEngine.readList() ---");
        return arrayList2;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a() {
        d();
        Context context = this.f23791d;
        if (context != null) {
            k.a("plugin-tsm", "unbindTSMService() ++");
            if (this.f23793f) {
                try {
                    context.unbindService(this.f23795h);
                } catch (Exception unused) {
                }
                this.f23793f = false;
            }
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a(b bVar, Context context) {
        this.f23788a = bVar;
        this.f23791d = context;
        this.f23792e = new Handler(this.f23794g);
        try {
            Intent intent = new Intent("com.unionpay.mobile.tsm.PBOCService");
            intent.setPackage("com.unionpay.mobile.tsm");
            context.startService(intent);
            Handler handler = this.f23792e;
            if (handler != null) {
                handler.sendMessageDelayed(Message.obtain(handler, (int) AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE), 8000L);
            }
            if (!context.bindService(intent, this.f23795h, 1) && this.f23788a != null) {
                k.a("plugin-tsm", "startTSMService.initFailed()");
                this.f23788a.b();
            }
        } catch (Exception unused) {
            if (this.f23788a != null) {
                k.a("plugin-tsm", "startTSMService exception");
                this.f23788a.b();
            }
        }
    }

    public final void a(boolean z10) {
        this.f23790c = z10;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final byte[] a(byte[] bArr, int i10) {
        String str = null;
        if (bArr == null) {
            return null;
        }
        String a10 = e.a(bArr);
        k.a("plugin-tsm", "[---->]" + a10);
        try {
            str = this.f23789b.writeApdu(a10, i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        k.a("plugin-tsm", "[<----]" + str);
        return e.a(str);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void b() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void c() {
        d();
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void d() {
        IRemoteApdu iRemoteApdu = this.f23789b;
        if (iRemoteApdu != null) {
            try {
                iRemoteApdu.closeChannel(0);
                this.f23789b.closeChannel(1);
                this.f23789b.closeChannel(2);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
