package com.unionpay.mobile.android.pboctransaction.icfcc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a implements c {

    /* renamed from: c  reason: collision with root package name */
    private b3.a f23773c;

    /* renamed from: d  reason: collision with root package name */
    private b f23774d;

    /* renamed from: e  reason: collision with root package name */
    private Context f23775e;

    /* renamed from: a  reason: collision with root package name */
    private String f23771a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f23772b = "A0000003334355502D4D4F42494C45";

    /* renamed from: f  reason: collision with root package name */
    private ServiceConnection f23776f = new b(this);

    private byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            String a10 = e.a(bArr);
            if (b(a10)) {
                if (a10.contains(this.f23771a)) {
                    k.c("icfcc", "pbocAID = " + this.f23771a);
                    bArr2 = this.f23773c.k2(e.a(this.f23771a), "00");
                } else if (a10.contains(this.f23772b)) {
                    k.c("icfcc", "upcardAID = " + this.f23772b);
                    bArr2 = this.f23773c.k2(e.a(this.f23772b), "01");
                }
            }
        } catch (Exception unused) {
        }
        k.c("icfcc", " openSEChannel result=" + e.a(bArr2));
        return bArr2;
    }

    private static boolean b(String str) {
        return str.startsWith("00A40400") || str.startsWith("01A40400") || str.startsWith("02A40400");
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final String a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final ArrayList<com.unionpay.mobile.android.model.c> a(d dVar) {
        if (this.f23773c == null) {
            return null;
        }
        ArrayList<com.unionpay.mobile.android.model.c> arrayList = new ArrayList<>();
        try {
            try {
                String a10 = c.a(e.a(this.f23773c.k2(e.a("325041592e5359532e4444463031"), "00")), "4F");
                k.c("icfcc", "aid =" + a10);
                if (a10 != null) {
                    this.f23771a = a10;
                    AppIdentification appIdentification = new AppIdentification(a10, "");
                    String c10 = e.c(dVar.a(appIdentification));
                    if (c10 != null && c10.length() > 0) {
                        k.c("icfcc", "  " + c10);
                        arrayList.add(new com.unionpay.mobile.android.model.a(8, appIdentification.a(), "", c10, 1));
                    }
                }
                try {
                    this.f23773c.b("00");
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
                return arrayList;
            } catch (RemoteException e11) {
                e11.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            this.f23773c.b("00");
            return null;
        } catch (Throwable th2) {
            try {
                this.f23773c.b("00");
            } catch (RemoteException e12) {
                e12.printStackTrace();
            }
            throw th2;
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a() {
        d();
        b3.a aVar = this.f23773c;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (RemoteException e10) {
                e10.printStackTrace();
            } catch (Exception unused) {
            }
        }
        if (this.f23775e != null) {
            new Intent("com.unionpay.mobile.tsm.PBOCService");
            this.f23775e.unbindService(this.f23776f);
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a(b bVar, Context context) {
        this.f23774d = bVar;
        this.f23775e = context;
        try {
            Intent intent = new Intent("cn.gov.pbc.tsm.client.mobile.android.bank.service");
            intent.setPackage("cn.gov.pbc.tsm.client.mobile.andorid");
            context.startService(intent);
            if (!context.bindService(intent, this.f23776f, 1) && bVar != null) {
                k.a("icfcc", "startTSMService.initFailed()");
                bVar.b();
            }
        } catch (Exception unused) {
            if (bVar != null) {
                k.a("icfcc", "starticfccService exception");
                bVar.b();
            }
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final byte[] a(byte[] bArr, int i10) {
        String a10 = e.a(bArr);
        k.c("icfcc", "====>" + a10);
        byte[] bArr2 = null;
        if (this.f23773c == null) {
            return null;
        }
        if (b(a10)) {
            return a(bArr);
        }
        try {
            bArr2 = this.f23773c.B1(bArr);
        } catch (RemoteException | Exception unused) {
        }
        k.c("icfcc", "<====" + e.a(bArr2));
        return bArr2;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void b() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void c() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void d() {
        b3.a aVar = this.f23773c;
        if (aVar != null) {
            try {
                aVar.b("00");
                this.f23773c.b("01");
            } catch (RemoteException e10) {
                e10.printStackTrace();
            } catch (Exception unused) {
            }
        }
    }
}
