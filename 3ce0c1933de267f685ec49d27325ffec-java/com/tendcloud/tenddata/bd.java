package com.tendcloud.tenddata;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mobvoi.wear.providers.OtaColumn;
import com.mobvoi.wear.util.LogCleaner;
import com.mobvoi.wear.util.TelephonyUtil;
import com.tendcloud.tenddata.bh;
import com.tendcloud.tenddata.zz;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bd {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bd f22723a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f22724b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f22725c;

    static {
        try {
            v.a().register(a());
        } catch (Throwable unused) {
        }
        f22723a = null;
        f22724b = false;
        f22725c = false;
    }

    private bd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        try {
            if (h.e() == 0) {
                h.setInitTime(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(final a aVar) {
        try {
            new Timer().schedule(new TimerTask() { // from class: com.tendcloud.tenddata.bd.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    bd.c(a.this);
                    bd.c();
                    bd.e(a.this);
                }
            }, ab.f22579s);
        } catch (Throwable th2) {
            g.eForInternal(th2);
            e(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(final a aVar) {
        try {
            if (aVar == null) {
                g.eForInternal("TDFeatures is null...");
                return;
            }
            TreeMap treeMap = new TreeMap();
            boolean a10 = ab.a(aVar);
            treeMap.put("first", Boolean.valueOf(a10));
            if (!u.b(zz.f23039a)) {
                treeMap.put("custom", u.a(zz.f23039a));
            }
            bi biVar = new bi();
            biVar.f22732b = OtaColumn.COLUMN_APP;
            biVar.f22733c = "init";
            biVar.f22734d = treeMap;
            biVar.f22731a = aVar;
            if (a10) {
                biVar.f22736f = new cb() { // from class: com.tendcloud.tenddata.bd.2
                    @Override // com.tendcloud.tenddata.cb
                    public void onStoreFailed() {
                        try {
                            bf.postSDKError(new Exception("init event store failed"));
                        } catch (Throwable th2) {
                            bf.postSDKError(th2);
                        }
                    }

                    @Override // com.tendcloud.tenddata.cb
                    public void onStoreSuccess() {
                        try {
                            h.a(false, a.this);
                        } catch (Throwable unused) {
                        }
                    }
                };
            }
            v.a().post(biVar);
            bh bhVar = new bh();
            bhVar.f22729a = aVar;
            bhVar.f22730b = bh.a.IMMEDIATELY;
            v.a().post(bhVar);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public final void onTDEBEventInitEvent(zz.a aVar) {
        try {
            if (Integer.parseInt(String.valueOf(aVar.paraMap.get("apiType"))) == 1) {
                String valueOf = String.valueOf(aVar.paraMap.get(TelephonyUtil.KEY_SIM_ACTION));
                a aVar2 = (a) aVar.paraMap.get("service");
                if (valueOf.equals("install") && (aVar2.name().equals("TRACKING") || aVar2.name().equals("SDK"))) {
                    bi biVar = new bi();
                    Object obj = aVar.paraMap.get("data");
                    biVar.f22732b = String.valueOf(aVar.paraMap.get("domain"));
                    biVar.f22733c = valueOf;
                    if (obj != null && (obj instanceof Map)) {
                        biVar.f22734d = (Map) obj;
                    }
                    biVar.f22731a = aVar2;
                    v.a().post(biVar);
                } else if (valueOf.equals("init")) {
                    Context context = ab.f22568h;
                    bg.a();
                    aw.a();
                    bb.a();
                    ax.a();
                    be.a();
                    bc.a();
                    u.a(context);
                    ab.f22562b = true;
                    if (aVar2.name().equals("SDK")) {
                        a(context, aVar2);
                    }
                    d(aVar2);
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void a(Context context, a aVar) {
        if (!f22725c) {
            try {
                String str = "TalkingData SDK init...\n\tSDK_VERSION is: Android+TD+V5.0.0 gp Type:" + ab.c() + "  Build_Num:" + ab.f22583w + "\n\tApp ID is: " + ab.a(context, aVar) + "\n\tApp Channel is: " + ab.b(context, aVar) + "\n\tApp Custom is: " + ab.c(context, aVar) + "\n\tSDK_OVC is: " + d.f22886e;
                if (ab.f22562b || g.f22893a) {
                    Log.i(ab.f22582v, str);
                }
                String o10 = h.o();
                if (!TextUtils.isEmpty(o10)) {
                    cc.a().setDeepLink(o10);
                }
                f22725c = true;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(a aVar) {
        try {
            if (aVar == null) {
                g.eForInternal("TDFeatures is null...");
            } else if (h.d(aVar) == 0) {
                h.b(System.currentTimeMillis(), aVar);
            } else if (System.currentTimeMillis() - h.d(aVar) > LogCleaner.ONE_DAY) {
                u.f23007c = true;
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public static bd a() {
        if (f22723a == null) {
            synchronized (bd.class) {
                if (f22723a == null) {
                    f22723a = new bd();
                }
            }
        }
        return f22723a;
    }
}
