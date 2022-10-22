package com.alipay.sdk.util;

import a4.h;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.util.b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.wear.lpa.LpaConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
import r3.a;
import y3.a;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Activity f6915a;

    /* renamed from: b  reason: collision with root package name */
    public volatile IAlixPay f6916b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6918d;

    /* renamed from: e  reason: collision with root package name */
    public e f6919e;

    /* renamed from: f  reason: collision with root package name */
    public final y3.a f6920f;

    /* renamed from: c  reason: collision with root package name */
    public final Object f6917c = IAlixPay.class;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6921g = false;

    /* renamed from: h  reason: collision with root package name */
    public String f6922h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f6923i = null;

    /* renamed from: com.alipay.sdk.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0091a implements AlipayResultActivity.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f6924a;

        public C0091a(CountDownLatch countDownLatch) {
            this.f6924a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i10, String str, String str2) {
            a.this.f6922h = o3.b.b(i10, str, str2);
            this.f6924a.countDown();
        }
    }

    /* loaded from: classes.dex */
    public class b implements APayEntranceActivity.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f6926a;

        public b(CountDownLatch countDownLatch) {
            this.f6926a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            a.this.f6923i = str;
            this.f6926a.countDown();
        }
    }

    /* loaded from: classes.dex */
    public class c extends IRemoteServiceCallback.Stub {
        public c() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 3;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z10, String str) throws RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            p3.a.c(a.this.f6920f, "wlt", str, str2);
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i10, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i10);
                intent.putExtras(bundle);
            } catch (Exception e10) {
                p3.a.d(a.this.f6920f, "biz", "ErrIntentEx", e10);
            }
            intent.setClassName(str, str2);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    y3.a aVar = a.this.f6920f;
                    p3.a.c(aVar, "biz", "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
                }
            } catch (Throwable unused) {
            }
            try {
                if (a.this.f6915a != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    a.this.f6915a.startActivity(intent);
                    y3.a aVar2 = a.this.f6920f;
                    p3.a.c(aVar2, "biz", "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                } else {
                    p3.a.h(a.this.f6920f, "biz", "ErrActNull", "");
                    Context a10 = a.this.f6920f.a();
                    if (a10 != null) {
                        a10.startActivity(intent);
                    }
                }
                a.this.f6919e.a();
            } catch (Throwable th2) {
                p3.a.d(a.this.f6920f, "biz", "ErrActNull", th2);
                throw th2;
            }
        }

        public /* synthetic */ c(a aVar, C0091a aVar2) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class d implements ServiceConnection {
        public d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            p3.a.b(a.this.f6920f, "biz", "srvCon");
            synchronized (a.this.f6917c) {
                a.this.f6916b = IAlixPay.Stub.asInterface(iBinder);
                a.this.f6917c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            p3.a.b(a.this.f6920f, "biz", "srvDis");
            a.this.f6916b = null;
        }

        public /* synthetic */ d(a aVar, C0091a aVar2) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    public a(Activity activity, y3.a aVar, e eVar) {
        this.f6915a = activity;
        this.f6920f = aVar;
        this.f6919e = eVar;
        a4.d.h("mspl", "alipaySdk");
    }

    private Pair<String, Boolean> a(String str, String str2, y3.a aVar) {
        int i10;
        d dVar;
        c cVar;
        Throwable th2;
        Activity activity;
        Activity activity2;
        long elapsedRealtime;
        StringBuilder sb2;
        String str3;
        Activity activity3;
        Activity activity4;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(com.alipay.sdk.util.b.y(str2));
        String h10 = com.alipay.sdk.util.b.h(this.f6915a, str2);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        sb3.append(elapsedRealtime2);
        sb3.append("|");
        sb3.append(str != null ? str.length() : 0);
        p3.a.c(aVar, "biz", "PgBindStarting", sb3.toString());
        p3.a.a(this.f6915a, aVar, str, aVar.f36738d);
        try {
            if (!r3.a.G().p()) {
                ComponentName startService = this.f6915a.getApplication().startService(intent);
                p3.a.c(aVar, "biz", "stSrv", startService != null ? startService.getPackageName() : LpaConstants.VALUE_NULL);
            } else {
                p3.a.c(aVar, "biz", "stSrv", "skipped");
            }
            if (r3.a.G().h()) {
                i10 = 65;
                p3.a.c(aVar, "biz", "bindFlg", "imp");
            } else {
                i10 = 1;
            }
            d dVar2 = new d(this, null);
            if (this.f6915a.getApplicationContext().bindService(intent, dVar2, i10)) {
                synchronized (this.f6917c) {
                    if (this.f6916b == null) {
                        try {
                            this.f6917c.wait(r3.a.G().u());
                        } catch (InterruptedException e10) {
                            p3.a.d(aVar, "biz", "BindWaitTimeoutEx", e10);
                        }
                    }
                }
                IAlixPay iAlixPay = this.f6916b;
                try {
                    if (iAlixPay == null) {
                        p3.a.h(aVar, "biz", "ClientBindFailed", h10 + "|" + com.alipay.sdk.util.b.h(this.f6915a, str2));
                        Pair<String, Boolean> pair = new Pair<>("failed", Boolean.TRUE);
                        try {
                            this.f6915a.getApplicationContext().unbindService(dVar2);
                        } catch (Throwable th3) {
                            a4.d.d(th3);
                        }
                        p3.a.c(aVar, "biz", "PgBindEnd", "" + SystemClock.elapsedRealtime());
                        p3.a.a(this.f6915a, aVar, str, aVar.f36738d);
                        this.f6916b = null;
                        if (this.f6918d && (activity4 = this.f6915a) != null) {
                            activity4.setRequestedOrientation(0);
                            this.f6918d = false;
                        }
                        return pair;
                    }
                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                    p3.a.c(aVar, "biz", "PgBinded", "" + elapsedRealtime3);
                    e eVar = this.f6919e;
                    if (eVar != null) {
                        eVar.b();
                    }
                    if (this.f6915a.getRequestedOrientation() == 0) {
                        this.f6915a.setRequestedOrientation(1);
                        this.f6918d = true;
                    }
                    int version = iAlixPay.getVersion();
                    cVar = new c(this, null);
                    try {
                        if (version >= 3) {
                            iAlixPay.registerCallback03(cVar, str, null);
                        } else {
                            iAlixPay.registerCallback(cVar);
                        }
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        sb2 = new StringBuilder();
                    } catch (Throwable th4) {
                        th2 = th4;
                        dVar = dVar2;
                    }
                    try {
                        sb2.append("");
                        sb2.append(elapsedRealtime);
                        p3.a.c(aVar, "biz", "PgBindPay", sb2.toString());
                        if (version >= 3) {
                            iAlixPay.r03("biz", "bind_pay", null);
                        }
                        if (version >= 2) {
                            HashMap<String, String> f10 = y3.a.f(aVar);
                            f10.put("ts_bind", String.valueOf(elapsedRealtime2));
                            f10.put("ts_bend", String.valueOf(elapsedRealtime3));
                            f10.put("ts_pay", String.valueOf(elapsedRealtime));
                            str3 = iAlixPay.pay02(str, f10);
                        } else {
                            str3 = iAlixPay.Pay(str);
                        }
                        String str4 = str3;
                        try {
                            iAlixPay.unregisterCallback(cVar);
                        } catch (Throwable th5) {
                            a4.d.d(th5);
                        }
                        try {
                            this.f6915a.getApplicationContext().unbindService(dVar2);
                        } catch (Throwable th6) {
                            a4.d.d(th6);
                        }
                        p3.a.c(aVar, "biz", "PgBindEnd", "" + SystemClock.elapsedRealtime());
                        p3.a.a(this.f6915a, aVar, str, aVar.f36738d);
                        this.f6916b = null;
                        if (this.f6918d && (activity3 = this.f6915a) != null) {
                            activity3.setRequestedOrientation(0);
                            this.f6918d = false;
                        }
                        return new Pair<>(str4, Boolean.FALSE);
                    } catch (Throwable th7) {
                        th2 = th7;
                        dVar = dVar2;
                        try {
                            p3.a.e(aVar, "biz", "ClientBindFailed", th2, "in_bind");
                            Pair<String, Boolean> pair2 = new Pair<>("failed", Boolean.TRUE);
                            if (cVar != null) {
                                try {
                                    iAlixPay.unregisterCallback(cVar);
                                } catch (Throwable th8) {
                                    a4.d.d(th8);
                                }
                            }
                            try {
                                this.f6915a.getApplicationContext().unbindService(dVar);
                            } catch (Throwable th9) {
                                a4.d.d(th9);
                            }
                            p3.a.c(aVar, "biz", "PgBindEnd", "" + SystemClock.elapsedRealtime());
                            p3.a.a(this.f6915a, aVar, str, aVar.f36738d);
                            this.f6916b = null;
                            if (this.f6918d && (activity2 = this.f6915a) != null) {
                                activity2.setRequestedOrientation(0);
                                this.f6918d = false;
                            }
                            return pair2;
                        } catch (Throwable th10) {
                            if (cVar != null) {
                                try {
                                    iAlixPay.unregisterCallback(cVar);
                                } catch (Throwable th11) {
                                    a4.d.d(th11);
                                }
                            }
                            try {
                                this.f6915a.getApplicationContext().unbindService(dVar);
                            } catch (Throwable th12) {
                                a4.d.d(th12);
                            }
                            p3.a.c(aVar, "biz", "PgBindEnd", "" + SystemClock.elapsedRealtime());
                            p3.a.a(this.f6915a, aVar, str, aVar.f36738d);
                            this.f6916b = null;
                            if (this.f6918d && (activity = this.f6915a) != null) {
                                activity.setRequestedOrientation(0);
                                this.f6918d = false;
                            }
                            throw th10;
                        }
                    }
                } catch (Throwable th13) {
                    th2 = th13;
                    dVar = dVar2;
                    cVar = null;
                }
            } else {
                throw new Throwable("bindService fail");
            }
        }
    }

    private String e(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        String str4;
        String str5;
        String str6;
        String str7 = str;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String g10 = com.alipay.sdk.util.b.g(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        p3.a.c(this.f6920f, "biz", "BSPStart", g10 + "|" + elapsedRealtime);
        a.C0536a.d(this.f6920f, g10);
        AlipayResultActivity.f6856a.put(g10, new C0091a(countDownLatch));
        try {
            try {
                String[] split = str7.split(ContainerUtils.FIELD_DELIMITER, -1);
                int length = split.length;
                int i10 = 0;
                while (true) {
                    jSONObject = null;
                    if (i10 >= length) {
                        str4 = "";
                        str5 = str4;
                        str6 = null;
                        break;
                    }
                    str6 = split[i10];
                    if (str6.startsWith("bizcontext=")) {
                        String substring = str6.substring(str6.indexOf("{"), str6.lastIndexOf("}") + 1);
                        int indexOf = str6.indexOf(substring);
                        str5 = str6.substring(0, indexOf);
                        str4 = str6.substring(indexOf + substring.length());
                        JSONObject jSONObject2 = new JSONObject(substring);
                        if (jSONObject2.optString("sc").equals("h5tonative")) {
                            jSONObject2.put("sc", "h5tonative_scheme");
                        } else {
                            jSONObject2.put("sc", "h5tonative_sdkscheme");
                        }
                        jSONObject = jSONObject2;
                    } else {
                        i10++;
                    }
                }
            } catch (Throwable th2) {
                p3.a.d(this.f6920f, "biz", "BSPEx", th2);
                return "scheme_failed";
            }
        } catch (Exception e10) {
            try {
                p3.a.e(this.f6920f, "biz", "BSPSCReplaceEx", e10, Base64.encodeToString(str.getBytes(), 2));
            } catch (InterruptedException e11) {
                p3.a.d(this.f6920f, "biz", "BSPWaiting", e11);
                com.alipay.sdk.app.c cVar = com.alipay.sdk.app.c.PAY_WAITTING;
                return o3.b.b(cVar.b(), cVar.a(), "");
            }
        }
        if (TextUtils.isEmpty(str6)) {
            throw new RuntimeException("empty ctx_args");
        } else if (str7.indexOf(str6) == str7.lastIndexOf(str6)) {
            str7 = str7.replace(str6, str5 + jSONObject.toString() + str4);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("sourcePid", Binder.getCallingPid());
            jSONObject3.put("external_info", str7);
            jSONObject3.put("pkgName", this.f6915a.getPackageName());
            jSONObject3.put("session", g10);
            String encodeToString = Base64.encodeToString(jSONObject3.toString().getBytes("UTF-8"), 2);
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20000125");
            appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
            try {
                HashMap<String, String> f10 = y3.a.f(this.f6920f);
                f10.put("ts_scheme", String.valueOf(elapsedRealtime));
                appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(f10).toString());
            } catch (Throwable th3) {
                p3.a.d(this.f6920f, "biz", "BSPLocEx", th3);
            }
            String uri = appendQueryParameter.build().toString();
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(Uri.parse(uri));
            Activity activity = this.f6915a;
            y3.a aVar = this.f6920f;
            p3.a.a(activity, aVar, str7, aVar.f36738d);
            this.f6915a.startActivity(intent);
            r3.a.G().g(this.f6920f, this.f6915a.getApplicationContext(), false);
            a4.d.h("mspl", "pay scheme waiting " + uri);
            countDownLatch.await();
            String str8 = this.f6922h;
            try {
                str3 = h.d(this.f6920f, str8).get("resultStatus");
                if (str3 == null) {
                    str3 = LpaConstants.VALUE_NULL;
                }
            } catch (Throwable th4) {
                p3.a.d(this.f6920f, "biz", "BSPStatEx", th4);
                str3 = "unknown";
            }
            p3.a.b(this.f6920f, "biz", "BSPDone-" + str3);
            if (!TextUtils.isEmpty(str8)) {
                return str8;
            }
            p3.a.b(this.f6920f, "biz", "BSPEmpty");
            return "scheme_failed";
        } else {
            throw new RuntimeException("multi ctx_args");
        }
    }

    private String f(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        a4.d.h("mspl", "pay bind or scheme");
        y3.a aVar = this.f6920f;
        p3.a.c(aVar, "biz", "PgWltVer", str2 + "|" + str3);
        Activity activity = this.f6915a;
        y3.a aVar2 = this.f6920f;
        p3.a.a(activity, aVar2, str, aVar2.f36738d);
        return n(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String g(String str, String str2, PackageInfo packageInfo, b.c cVar) {
        String str3;
        y3.a aVar;
        boolean z10 = false;
        int i10 = packageInfo != null ? packageInfo.versionCode : 0;
        String str4 = packageInfo != null ? packageInfo.versionName : "";
        a4.d.h("mspl", "pay bind or scheme");
        y3.a aVar2 = this.f6920f;
        p3.a.c(aVar2, "biz", "PgWltVer", str2 + "|" + str4);
        y3.a aVar3 = this.f6920f;
        if (aVar3 != null && !TextUtils.isEmpty(aVar3.f36741g)) {
            z10 = this.f6920f.f36741g.toLowerCase().contains("auth");
        }
        if (!z10 && com.alipay.sdk.util.b.S()) {
            if (cVar != null) {
                try {
                    if (r3.a.G().E()) {
                        j(cVar);
                    }
                } catch (Throwable unused) {
                }
            }
            p3.a.b(this.f6920f, "biz", "BindSkipByModel");
        } else if (z10 || !com.alipay.sdk.util.b.I(this.f6920f, str2)) {
            if (cVar != null) {
                try {
                    if (!r3.a.G().z()) {
                        j(cVar);
                    }
                } catch (Throwable unused2) {
                }
            }
            Pair<String, Boolean> a10 = a(str, str2, this.f6920f);
            str3 = (String) a10.first;
            try {
                if ("failed".equals(str3) && ((Boolean) a10.second).booleanValue() && r3.a.G().x()) {
                    p3.a.b(this.f6920f, "biz", "BindRetry");
                    str3 = (String) a(str, str2, this.f6920f).first;
                }
            } catch (Throwable th2) {
                p3.a.d(this.f6920f, "biz", "BindRetryEx", th2);
            }
            a4.d.h("mspl", "pay bind result: " + str3);
            Activity activity = this.f6915a;
            y3.a aVar4 = this.f6920f;
            p3.a.a(activity, aVar4, str, aVar4.f36738d);
            if ("failed".equals(str3)) {
                if (!r3.a.G().s()) {
                    p3.a.c(this.f6920f, "biz", "BSPNotStartByConfig", "");
                    return str3;
                } else if (!"com.eg.android.AlipayGphone".equals(str2) || i10 <= 125) {
                    y3.a aVar5 = this.f6920f;
                    p3.a.c(aVar5, "biz", "BSPNotStartByPkg", str2 + "|" + i10);
                } else if (!r3.a.G().w() || (aVar = this.f6920f) == null || com.alipay.sdk.util.b.v(aVar.f36740f) == 0) {
                    Activity activity2 = this.f6915a;
                    return (activity2 == null || !k(str2, activity2, this.f6920f)) ? "scheme_failed" : e(str, str2);
                } else {
                    p3.a.b(this.f6920f, "biz", "BSPNotStartByUsr");
                    return str3;
                }
            }
            return str3;
        } else {
            if (cVar != null) {
                try {
                    if (r3.a.G().E()) {
                        j(cVar);
                    }
                } catch (Throwable unused3) {
                }
            }
            p3.a.b(this.f6920f, "biz", "BindSkipByL");
        }
        str3 = "failed";
        a4.d.h("mspl", "pay bind result: " + str3);
        Activity activity3 = this.f6915a;
        y3.a aVar42 = this.f6920f;
        p3.a.a(activity3, aVar42, str, aVar42.f36738d);
        if ("failed".equals(str3)) {
        }
        return str3;
    }

    private void j(b.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar != null && (packageInfo = cVar.f6934a) != null) {
            String str = packageInfo.packageName;
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
            try {
                this.f6915a.startActivity(intent);
            } catch (Throwable th2) {
                p3.a.d(this.f6920f, "biz", "StartLaunchAppTransEx", th2);
            }
            Thread.sleep(200L);
        }
    }

    public static boolean k(String str, Context context, y3.a aVar) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            p3.a.b(aVar, "biz", "BSPDetectFail");
            return false;
        } catch (Throwable th2) {
            p3.a.d(aVar, "biz", "BSPDetectFail", th2);
            return false;
        }
    }

    private String n(String str, String str2) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String g10 = com.alipay.sdk.util.b.g(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        y3.a aVar = this.f6920f;
        p3.a.c(aVar, "biz", "BSAStart", g10 + "|" + elapsedRealtime);
        a.C0536a.d(this.f6920f, g10);
        APayEntranceActivity.f6853c.put(g10, new b(countDownLatch));
        try {
            HashMap<String, String> f10 = y3.a.f(this.f6920f);
            f10.put("ts_intent", String.valueOf(elapsedRealtime));
            JSONObject jSONObject = new JSONObject(f10);
            Intent intent = new Intent(this.f6915a, APayEntranceActivity.class);
            intent.putExtra("ap_order_info", str);
            intent.putExtra("ap_target_packagename", str2);
            intent.putExtra("ap_session", g10);
            if (jSONObject != null) {
                intent.putExtra("ap_local_info", jSONObject.toString());
            }
            Activity activity = this.f6915a;
            y3.a aVar2 = this.f6920f;
            p3.a.a(activity, aVar2, str, aVar2.f36738d);
            this.f6915a.startActivity(intent);
            r3.a.G().g(this.f6920f, this.f6915a.getApplicationContext(), false);
            countDownLatch.await();
            String str3 = this.f6923i;
            String str4 = h.d(this.f6920f, str3).get("resultStatus");
            if (str4 == null) {
                str4 = LpaConstants.VALUE_NULL;
            }
            y3.a aVar3 = this.f6920f;
            p3.a.b(aVar3, "biz", "BSADone-" + str4);
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
            p3.a.b(this.f6920f, "biz", "BSAEmpty");
            return "scheme_failed";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063 A[Catch: all -> 0x00ab, TRY_LEAVE, TryCatch #2 {all -> 0x00ab, blocks: (B:10:0x0023, B:12:0x002b, B:15:0x0033, B:18:0x003c, B:21:0x0042, B:24:0x004b, B:25:0x0050, B:26:0x0054, B:29:0x0059, B:31:0x0063), top: B:63:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d(String str) {
        b.c cVar;
        Throwable th2;
        PackageInfo packageInfo;
        String k10;
        String str2 = "";
        PackageInfo packageInfo2 = null;
        try {
            List<a.b> v10 = r3.a.G().v();
            if (!r3.a.G().f33373g || v10 == null) {
                v10 = o3.a.f31407d;
            }
            cVar = com.alipay.sdk.util.b.d(this.f6920f, this.f6915a, v10);
        } catch (Throwable th3) {
            th2 = th3;
            cVar = null;
        }
        if (cVar != null) {
            try {
            } catch (Throwable th4) {
                th2 = th4;
                p3.a.d(this.f6920f, "biz", "CheckClientSignEx", th2);
                if (this.f6921g) {
                }
            }
            if (cVar.b(this.f6920f) || cVar.a() || com.alipay.sdk.util.b.r(cVar.f6934a)) {
                return "failed";
            }
            PackageInfo packageInfo3 = cVar.f6934a;
            if (packageInfo3 != null && !"com.eg.android.AlipayGphone".equals(packageInfo3.packageName)) {
                str2 = cVar.f6934a.packageName;
                packageInfo = cVar.f6934a;
                if (packageInfo != null) {
                    packageInfo2 = packageInfo;
                }
                k10 = r3.a.G().k();
                if (k10 != null) {
                    if (k10.length() > 0) {
                        try {
                            JSONObject optJSONObject = new JSONObject(k10).optJSONObject(str2);
                            if (optJSONObject != null && optJSONObject.length() > 0) {
                                Iterator<String> keys = optJSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    int parseInt = Integer.parseInt(next);
                                    if (packageInfo2 != null && packageInfo2.versionCode >= parseInt) {
                                        try {
                                            boolean i10 = r3.a.G().i(this.f6915a, Integer.parseInt(optJSONObject.getString(next)));
                                            this.f6921g = i10;
                                            if (i10) {
                                                break;
                                            }
                                        } catch (Exception unused) {
                                            continue;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
                if (this.f6921g) {
                    return f(str, str2, packageInfo2);
                }
                return g(str, str2, packageInfo2, cVar);
            }
            str2 = com.alipay.sdk.util.b.f();
            packageInfo = cVar.f6934a;
            if (packageInfo != null) {
            }
            k10 = r3.a.G().k();
            if (k10 != null) {
            }
            if (this.f6921g) {
            }
        }
        return "failed";
    }

    public void i() {
        this.f6915a = null;
        this.f6919e = null;
    }
}
