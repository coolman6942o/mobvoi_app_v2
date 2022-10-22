package com.mobvoi.companion.health.thirdparty.wechat;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import java.util.HashMap;
import java.util.List;
import qb.d;
import rx.c;
/* compiled from: WechatSportUtil.java */
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final v f17089a = new v();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WechatSportUtil.java */
    /* loaded from: classes2.dex */
    public class a implements yp.b<y> {
        a() {
        }

        /* renamed from: a */
        public void call(y yVar) {
            k.a("WechatSportUtil", "onStepResponse " + yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WechatSportUtil.java */
    /* loaded from: classes2.dex */
    public class b implements yp.b<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void call(Throwable th2) {
            k.e("WechatSportUtil", "error sending steps to wechat ", th2);
        }
    }

    public static void a(String str, String str2, yp.b<u> bVar, yp.b<Throwable> bVar2) {
        f17089a.a().a(str, e(str2), g()).Z(cq.a.c()).H(xp.a.b()).Y(bVar, bVar2);
    }

    public static c<f> b(String str, String str2, String str3) {
        return f17089a.a().b(new c(str, str2, str3));
    }

    public static c<d> c(String str, List<String> list) {
        return f17089a.a().f(new e(str, list));
    }

    private static String d(String str) {
        if (str == null) {
            return "";
        }
        return str.contains(":") ? str.replaceAll(":", "") : str;
    }

    private static String e(String str) {
        return new qb.c().a(d(str), d.a());
    }

    private static String f(String str, String str2) {
        qb.b bVar = new qb.b();
        HashMap hashMap = new HashMap();
        hashMap.put("deviceId", str);
        hashMap.put("step", str2);
        hashMap.put("version", g());
        hashMap.put("appkey", "com.mobvoi.android");
        bVar.f32939b = hashMap;
        bVar.f32938a = "GET";
        return new qb.a().b(bVar, "UhjAHR3szU7Ce+0Hlda9Urlel7qMIMLwjwX/Qt+ec1w6P1rHxuFqp/ccXoG9sOT8eb6P0iTtcsSfVBDiAQDrgg==");
    }

    public static String g() {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        try {
            return String.valueOf(e10.getPackageManager().getPackageInfo(e10.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return "0";
        }
    }

    public static void h(Context context, int i10) {
        i(ta.a.x(), t.d(context), i10);
    }

    public static void i(String str, String str2, int i10) {
        k.f("WechatSportUtil", "wwid is %s, deviceId is %s, step is %d", str, str2, Integer.valueOf(i10));
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String valueOf = String.valueOf(i10);
            f17089a.a().c(str2, valueOf, g(), "a941507e-e154-4320-b348-e05c1d13826c", f(str2, valueOf), str, "com.mobvoi.android").Z(cq.a.c()).H(xp.a.b()).Y(new a(), new b());
        }
    }

    public static void j() {
        if (t.c(com.mobvoi.android.common.utils.b.e())) {
            MessageProxyClient.getInstance().sendMessage(WearPath.Health.SYNC_STEP_TO_WECHAT);
        }
    }
}
