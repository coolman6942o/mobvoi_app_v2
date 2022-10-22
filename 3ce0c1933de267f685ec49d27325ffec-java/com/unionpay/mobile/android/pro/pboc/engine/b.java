package com.unionpay.mobile.android.pro.pboc.engine;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.remoteapdu.a;
import com.unionpay.mobile.android.pboctransaction.samsung.f;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements Handler.Callback, f.a {

    /* renamed from: g  reason: collision with root package name */
    private Context f23878g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f23879h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<c> f23880i;

    /* renamed from: n  reason: collision with root package name */
    private d f23885n;

    /* renamed from: o  reason: collision with root package name */
    private com.unionpay.mobile.android.pboctransaction.c f23886o;

    /* renamed from: q  reason: collision with root package name */
    private d f23888q;

    /* renamed from: r  reason: collision with root package name */
    private a f23889r;

    /* renamed from: t  reason: collision with root package name */
    private d f23891t;

    /* renamed from: u  reason: collision with root package name */
    private com.unionpay.mobile.android.pboctransaction.simapdu.b f23892u;

    /* renamed from: w  reason: collision with root package name */
    private d f23894w;

    /* renamed from: x  reason: collision with root package name */
    private com.unionpay.mobile.android.pboctransaction.samsung.b f23895x;

    /* renamed from: y  reason: collision with root package name */
    private f f23896y;

    /* renamed from: z  reason: collision with root package name */
    private final com.unionpay.mobile.android.pboctransaction.b f23897z;

    /* renamed from: a  reason: collision with root package name */
    private final int f23872a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f23873b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f23874c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final int f23875d = 4;

    /* renamed from: e  reason: collision with root package name */
    private final int f23876e = 8;

    /* renamed from: f  reason: collision with root package name */
    private int f23877f = 0;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<c> f23881j = null;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<c> f23882k = null;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<c> f23883l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<c> f23884m = null;

    /* renamed from: p  reason: collision with root package name */
    private final com.unionpay.mobile.android.pboctransaction.b f23887p = new c(this);

    /* renamed from: s  reason: collision with root package name */
    private final com.unionpay.mobile.android.pboctransaction.b f23890s = new d(this);

    /* renamed from: v  reason: collision with root package name */
    private final com.unionpay.mobile.android.pboctransaction.b f23893v = new e(this);
    private a A = null;
    private boolean B = false;

    public b(Context context, String str) {
        this.f23878g = null;
        this.f23879h = null;
        this.f23880i = null;
        this.f23885n = null;
        this.f23886o = null;
        this.f23888q = null;
        this.f23889r = null;
        this.f23891t = null;
        this.f23892u = null;
        this.f23894w = null;
        this.f23895x = null;
        this.f23896y = null;
        f fVar = new f(this);
        this.f23897z = fVar;
        this.f23878g = context;
        this.f23879h = new Handler(this);
        this.f23880i = new ArrayList<>(1);
        com.unionpay.mobile.android.fully.a aVar = (com.unionpay.mobile.android.fully.a) ((BaseActivity) context).a(UPPayEngine.class.toString());
        this.f23886o = a("cn.gov.pbc.tsm.client.mobile.andorid", 1) ? new com.unionpay.mobile.android.pboctransaction.icfcc.a() : new com.unionpay.mobile.android.pboctransaction.sdapdu.a();
        this.f23885n = new d(this.f23886o, aVar, str);
        try {
            Class.forName("org.simalliance.openmobileapi.SEService");
            this.f23889r = new a();
            this.f23888q = new d(this.f23889r, aVar, str);
            this.f23892u = com.unionpay.mobile.android.pboctransaction.simapdu.b.e();
            this.f23891t = new d(this.f23892u, aVar, str);
            if (a("com.unionpay.tsmservice", 18)) {
                f fVar2 = new f(this);
                this.f23896y = fVar2;
                fVar2.a(this.f23879h);
                this.f23894w = new d(this.f23896y, aVar, str);
                return;
            }
            com.unionpay.mobile.android.model.b.aB = false;
            this.f23895x = new com.unionpay.mobile.android.pboctransaction.samsung.b();
            this.f23894w = new d(this.f23895x, aVar, str);
            fVar.b();
        } catch (ClassNotFoundException | Exception unused) {
            this.f23890s.b();
            this.f23893v.b();
            this.f23897z.b();
        }
    }

    private final void a(int i10) {
        if (i10 == 1) {
            k.c("UPCardEngine", "cmcc");
            if (a("com.unionpay.mobile.tsm", 12)) {
                a aVar = this.f23889r;
                if (aVar != null) {
                    aVar.a(this.B);
                    this.f23889r.a(this.f23890s, this.f23878g);
                    return;
                }
                return;
            }
            this.f23890s.b();
        } else if (i10 == 2) {
            k.c("UPCardEngine", "ic");
            if (this.f23892u == null) {
                return;
            }
            if (b().contains("ZTE")) {
                this.f23892u.a(this.f23893v, this.f23878g);
            } else {
                this.f23893v.b();
            }
        } else if (i10 == 4) {
            k.c("UPCardEngine", "se");
            if (a("com.unionpay.tsmservice", 18) && this.f23896y != null) {
                Log.e("uppay-spay", "type se  start init");
                this.f23896y.a(this.f23897z, this.f23878g);
            } else if (this.f23895x != null) {
                this.f23897z.b();
            }
        } else if (i10 != 8) {
            k.c("UPCardEngine", "sd");
            com.unionpay.mobile.android.pboctransaction.c cVar = this.f23886o;
            if (cVar != null) {
                cVar.a(this.f23887p, this.f23878g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, int i10) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f23878g.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        k.a("tsm-client", "tsm version code=" + packageInfo.versionCode);
        return packageInfo.versionCode >= i10;
    }

    private static String b() {
        return Build.BRAND + "_" + Build.MODEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i10) {
        Thread thread;
        if (i10 == 1) {
            thread = new Thread(new g(this));
        } else if (i10 == 2) {
            thread = new Thread(new h(this));
        } else if (i10 == 4) {
            if (b().contains("ZTE")) {
                thread = new Thread(new i(this));
            } else {
                return;
            }
        } else if (i10 == 8) {
            new Thread(new j(this)).start();
            return;
        } else {
            return;
        }
        thread.start();
    }

    public final Bundle a(c cVar, String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str2) {
        d dVar;
        if (cVar == null) {
            return null;
        }
        int c10 = cVar.c();
        int d10 = cVar.d();
        if (d10 == 1) {
            AppIdentification appIdentification = new AppIdentification(cVar.a(), null);
            String str3 = cVar.d() == 1 ? "2" : "1";
            if (c10 == 8) {
                dVar = this.f23885n;
            } else if (c10 == 4) {
                dVar = this.f23888q;
            } else if (c10 == 16) {
                dVar = this.f23891t;
            } else if (c10 == 1) {
                dVar = this.f23894w;
            } else if (c10 != 32) {
                return null;
            } else {
                dVar = this.f23894w;
                str3 = "10";
            }
            return dVar.a(appIdentification, str, str3, hashMap, hashMap2, str2);
        } else if (d10 != 2) {
            return null;
        } else {
            return this.f23885n.a(Integer.parseInt(cVar.a()), str, hashMap2, str2);
        }
    }

    public final void a() {
        a aVar = this.f23889r;
        if (aVar != null) {
            aVar.a();
            this.f23889r = null;
        }
        com.unionpay.mobile.android.pboctransaction.c cVar = this.f23886o;
        if (cVar != null) {
            cVar.a();
            this.f23886o = null;
        }
        com.unionpay.mobile.android.pboctransaction.simapdu.b bVar = this.f23892u;
        if (bVar != null) {
            bVar.a();
            this.f23892u = null;
        }
        com.unionpay.mobile.android.pboctransaction.samsung.b bVar2 = this.f23895x;
        if (bVar2 != null) {
            bVar2.a();
            this.f23895x = null;
        }
        f fVar = this.f23896y;
        if (fVar != null) {
            fVar.a();
            this.f23896y = null;
        }
        this.f23878g = null;
        this.A = null;
        this.f23879h.removeCallbacksAndMessages(null);
        this.f23879h = null;
        this.f23894w = null;
        this.f23885n = null;
        this.f23888q = null;
        this.f23891t = null;
        this.f23877f = 0;
    }

    public final void a(Handler handler, String str, String str2) {
        if (com.unionpay.mobile.android.model.b.aA && com.unionpay.mobile.android.model.b.aB) {
            com.unionpay.mobile.android.model.b.f23496bo = true;
            f fVar = this.f23896y;
            if (fVar != null && this.f23894w != null) {
                fVar.a(handler);
                this.f23896y.b(str);
                this.f23896y.c(str2);
                Log.e("uppay-spay", "tsmservice  get spay card list");
                this.f23894w.b();
            }
        }
    }

    public final void a(a aVar, boolean z10) {
        this.B = z10;
        this.A = aVar;
        this.f23877f = 0;
        a(0);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.samsung.f.a
    public final void a(boolean z10) {
        k.c("uppay", "startReadList  spay");
        com.unionpay.mobile.android.model.b.aB = z10;
        b(8);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        k.c("UPCardEngine", " msg.what = " + message.what);
        int i10 = message.what;
        if (i10 == 1 || i10 == 2 || i10 == 4 || i10 == 8) {
            this.f23877f = i10 ^ this.f23877f;
            k.c("UPCardEngine", " mTag = " + this.f23877f);
            Object obj = message.obj;
            if (obj != null) {
                int i11 = message.what;
                if (i11 == 1) {
                    this.f23881j = (ArrayList) obj;
                } else if (i11 == 2) {
                    this.f23882k = (ArrayList) obj;
                } else if (i11 == 4) {
                    this.f23883l = (ArrayList) obj;
                } else if (i11 == 8) {
                    this.f23884m = (ArrayList) obj;
                }
            }
            a(message.what);
        }
        if (this.f23877f == 15 && this.A != null) {
            ArrayList<c> arrayList = this.f23881j;
            if (arrayList != null && arrayList.size() > 0) {
                this.f23880i.addAll(this.f23881j);
            }
            ArrayList<c> arrayList2 = this.f23882k;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.f23880i.addAll(this.f23882k);
            }
            ArrayList<c> arrayList3 = this.f23883l;
            if (arrayList3 != null && arrayList3.size() > 0) {
                this.f23880i.addAll(this.f23883l);
            }
            ArrayList<c> arrayList4 = this.f23884m;
            if (arrayList4 != null && arrayList4.size() > 0) {
                this.f23880i.addAll(this.f23884m);
            }
            this.A.a(this.f23880i);
        }
        return true;
    }
}
