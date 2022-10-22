package com.unionpay.mobile.android.pboctransaction.simapdu;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.pboctransaction.simapdu.a;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.simalliance.openmobileapi.Channel;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;
/* loaded from: classes2.dex */
public final class b implements c {

    /* renamed from: d  reason: collision with root package name */
    private static b f23844d = new b();

    /* renamed from: c  reason: collision with root package name */
    private com.unionpay.mobile.android.pboctransaction.b f23847c;

    /* renamed from: a  reason: collision with root package name */
    private SEService f23845a = null;

    /* renamed from: b  reason: collision with root package name */
    private Channel[] f23846b = new Channel[3];

    /* renamed from: e  reason: collision with root package name */
    private Handler.Callback f23848e = new c(this);

    /* renamed from: f  reason: collision with root package name */
    private Handler f23849f = new Handler(this.f23848e);

    private b() {
    }

    private synchronized String a(String str, int i10) throws a.C0265a {
        String str2 = null;
        if (str == null) {
            return null;
        }
        k.a("plugin-sim", "====>" + str);
        String upperCase = str.toUpperCase(Locale.CHINA);
        boolean z10 = false;
        if (i10 > this.f23846b.length) {
            i10 = 0;
        }
        if (upperCase.startsWith("00A40400") || upperCase.startsWith("01A40400") || upperCase.startsWith("02A40400")) {
            z10 = true;
        }
        if (z10) {
            a(i10);
            String b10 = b(e.a(upperCase.substring(10, (((Integer.parseInt(upperCase.substring(8, 9), 16) * 16) + Integer.parseInt(upperCase.substring(9, 10), 16)) * 2) + 10)), i10);
            if (!TextUtils.isEmpty(b10)) {
                return b10;
            }
            k.c("plugin-sim", " writeApdu openchannel exception!!!");
            throw new a.C0265a();
        }
        try {
            try {
                byte[] a10 = e.a(upperCase);
                if (a10 != null) {
                    str2 = e.a(this.f23846b[i10].transmit(a10));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            k.a("plugin-sim", "<====" + str2);
            return str2;
        } catch (IOException e11) {
            e11.printStackTrace();
            throw new a.C0265a();
        }
    }

    private void a(int i10) {
        k.a("plugin-sim", "closeChannel(int) +++");
        Channel[] channelArr = this.f23846b;
        if (channelArr[i10] != null && i10 <= channelArr.length) {
            try {
                channelArr[i10].close();
            } catch (Exception e10) {
                e10.printStackTrace();
                k.a("plugin-sim", " mChannel[channel].close() exception!!!");
            }
            this.f23846b[i10] = null;
        }
        k.a("plugin-sim", "closeChannel(int) ---");
    }

    private String b(byte[] bArr, int i10) {
        Channel openLogicalChannel;
        try {
            Reader[] readers = this.f23845a.getReaders();
            if (readers.length <= 0 || (openLogicalChannel = readers[0].openSession().openLogicalChannel(bArr)) == null) {
                return "";
            }
            this.f23846b[i10] = openLogicalChannel;
            return e.a(openLogicalChannel.getSelectResponse());
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            bVar = f23844d;
        }
        return bVar;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final String a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final ArrayList<com.unionpay.mobile.android.model.c> a(d dVar) {
        Throwable th2;
        ArrayList arrayList;
        String a10;
        k.c("plugin-sim", " SIMEngine.readList() +++");
        ArrayList<com.unionpay.mobile.android.model.c> arrayList2 = null;
        try {
            arrayList = new ArrayList(1);
            a10 = dVar.a("A0000003330101");
            k.c("plugin-sim", "full AID:" + a10);
        } catch (Throwable th3) {
            th2 = th3;
        }
        if (a10 != null && a10.length() >= 16) {
            arrayList.add(new AppIdentification(a10, null));
            if (arrayList.size() > 0) {
                ArrayList<com.unionpay.mobile.android.model.c> arrayList3 = new ArrayList<>();
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AppIdentification appIdentification = (AppIdentification) it.next();
                        if (!"06".equalsIgnoreCase(appIdentification.b())) {
                            String c10 = e.c(dVar.a(appIdentification));
                            k.a("nfcphone", " cardNumber=" + c10);
                            if (c10 != null && c10.length() > 0) {
                                arrayList3.add(new com.unionpay.mobile.android.model.a(16, appIdentification.a(), "", c10, 1));
                                k.a("nfcphone", " valid Number= " + c10);
                            }
                        }
                    }
                    arrayList2 = arrayList3;
                } catch (Throwable th4) {
                    th2 = th4;
                    arrayList2 = arrayList3;
                    Log.e("plugin-sim", " SimEngine Exception = " + th2.getMessage());
                    k.c("plugin-sim", " SIMEngine.readList() ---");
                    return arrayList2;
                }
            } else {
                Log.e("plugin-sim", " SIMEngine --- there has no PBOC aids!!!");
            }
            k.c("plugin-sim", " SIMEngine.readList() ---");
            return arrayList2;
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a() {
        k.c("plugin-sim", "SIMEngine.destroy() +++ ");
        k.c("plugin-sim", " mSEService = " + this.f23845a);
        d();
        SEService sEService = this.f23845a;
        if (sEService != null && sEService.isConnected()) {
            k.a("TAG", " mSEService.isConnected() = " + this.f23845a.isConnected());
            k.c("plugin-sim", " mSEService.shutdown() ");
            this.f23845a.shutdown();
        }
        k.c("plugin-sim", "SIMEngine.destroy() --- ");
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a(com.unionpay.mobile.android.pboctransaction.b bVar, Context context) {
        this.f23847c = bVar;
        try {
            new l();
            if (l.a() == null || !l.a().isConnected()) {
                this.f23849f.sendEmptyMessage(2);
                return;
            }
            this.f23845a = l.a();
            this.f23849f.sendEmptyMessage(1);
        } catch (Throwable th2) {
            th2.printStackTrace();
            Log.e("plugin-sim", " service ERROR!!!");
            this.f23849f.sendEmptyMessage(2);
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final byte[] a(byte[] bArr, int i10) {
        byte[] bArr2;
        k.c("plugin-sim", " SIMEngine.sendApdu() +++");
        try {
            bArr2 = e.a(a(e.a(bArr), i10));
        } catch (a.C0265a e10) {
            e10.printStackTrace();
            k.c("plugin-sim", " " + e10.getMessage());
            bArr2 = null;
        }
        k.c("plugin-sim", " SIMEngine.sendApdu() ---");
        return bArr2;
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
        k.a("plugin-sim", "closeChannels() +++");
        for (int i10 = 0; i10 < this.f23846b.length; i10++) {
            a(i10);
        }
        k.a("plugin-sim", "closeChannels() ---");
    }
}
