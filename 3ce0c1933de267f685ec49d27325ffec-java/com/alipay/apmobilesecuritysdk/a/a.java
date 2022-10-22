package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import i4.c;
import i4.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f6809a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f6810b = com.alipay.apmobilesecuritysdk.b.a.a();

    /* renamed from: c  reason: collision with root package name */
    public int f6811c = 4;

    public a(Context context) {
        this.f6809a = context;
    }

    public static String a(Context context) {
        String b10 = b(context);
        return c4.a.d(b10) ? h.f(context) : b10;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String a10 = i.a(str);
            if (!c4.a.d(a10)) {
                return a10;
            }
            String a11 = g.a(context, str);
            i.a(str, a11);
            return !c4.a.d(a11) ? a11 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                String[] split = strArr[i10].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random);
                    Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private c b(Map<String, String> map) {
        b b10;
        b c10;
        String str = "";
        try {
            Context context = this.f6809a;
            d dVar = new d();
            String c11 = c4.a.c(map, "appName", str);
            String c12 = c4.a.c(map, "sessionId", str);
            String c13 = c4.a.c(map, "rpcVersion", str);
            String a10 = a(context, c11);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d10 = h.d(context);
            if (c4.a.g(c12)) {
                dVar.f28076c = c12;
            } else {
                dVar.f28076c = a10;
            }
            dVar.f28077d = securityToken;
            dVar.f28078e = d10;
            dVar.f28074a = "android";
            com.alipay.apmobilesecuritysdk.e.c c14 = com.alipay.apmobilesecuritysdk.e.d.c(context);
            String str2 = c14 != null ? c14.f6819a : str;
            if (c4.a.d(str2) && (c10 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = c10.f6816a;
            }
            com.alipay.apmobilesecuritysdk.e.c b11 = com.alipay.apmobilesecuritysdk.e.d.b();
            if (b11 != null) {
                str = b11.f6819a;
            }
            if (c4.a.d(str) && (b10 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str = b10.f6816a;
            }
            dVar.f28080g = c13;
            if (c4.a.d(str2)) {
                dVar.f28075b = str;
            } else {
                dVar.f28075b = str2;
            }
            dVar.f28079f = e.a(context, map);
            return h4.d.c(this.f6809a, this.f6810b.c()).a(dVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th2);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            String b10 = i.b();
            if (!c4.a.d(b10)) {
                return b10;
            }
            com.alipay.apmobilesecuritysdk.e.c b11 = com.alipay.apmobilesecuritysdk.e.d.b(context);
            if (b11 != null) {
                i.a(b11);
                String str = b11.f6819a;
                if (c4.a.g(str)) {
                    return str;
                }
            }
            b b12 = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (b12 == null) {
                return "";
            }
            i.a(b12);
            String str2 = b12.f6816a;
            return c4.a.g(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i10 = 0; i10 < 5; i10++) {
                String str = strArr[i10];
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        if (c4.a.d(b(r9.f6809a)) != false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d2 A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af, B:37:0x00be, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:60:0x017e, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:66:0x019d, B:67:0x01a1, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218), top: B:86:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01fd A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af, B:37:0x00be, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:60:0x017e, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:66:0x019d, B:67:0x01a1, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218), top: B:86:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0203 A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af, B:37:0x00be, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:60:0x017e, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:66:0x019d, B:67:0x01a1, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218), top: B:86:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0212 A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af, B:37:0x00be, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:60:0x017e, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:66:0x019d, B:67:0x01a1, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218), top: B:86:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Map<String, String> map) {
        String c10;
        boolean z10;
        boolean z11;
        int i10;
        j4.a c11;
        Context context;
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager;
        String str;
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.f6809a, c4.a.c(map, "tid", ""), c4.a.c(map, "utdid", ""), a(this.f6809a));
            c10 = c4.a.c(map, "appName", "");
            b();
            b(this.f6809a);
            a(this.f6809a, c10);
            i.a();
            z10 = false;
        } catch (Exception e10) {
            com.alipay.apmobilesecuritysdk.c.a.a(e10);
        }
        if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.f6809a)) {
            e.a();
            if (!(!c4.a.e(e.b(this.f6809a, map), i.c()))) {
                String c12 = c4.a.c(map, "tid", "");
                String c13 = c4.a.c(map, "utdid", "");
                if (c4.a.g(c12)) {
                    if (!c4.a.e(c12, i.d())) {
                    }
                }
                if (c4.a.g(c13)) {
                    if (!c4.a.e(c13, i.e())) {
                    }
                }
                if (i.a(this.f6809a, c10)) {
                    if (!c4.a.d(a(this.f6809a, c10))) {
                        if (c4.a.d(b(this.f6809a))) {
                        }
                        z11 = false;
                        Context context2 = this.f6809a;
                        e4.b.d();
                        h.b(context2, String.valueOf(e4.b.B()));
                        if (z11) {
                            new com.alipay.apmobilesecuritysdk.c.b();
                            UmidSdkWrapper.startUmidTaskSync(this.f6809a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                            c b10 = b(map);
                            int c14 = b10 != null ? b10.c() : 2;
                            if (c14 != 1) {
                                if (c14 != 3) {
                                    if (b10 != null) {
                                        str = "Server error, result:" + b10.f28064b;
                                    } else {
                                        str = "Server error, returned null";
                                    }
                                    com.alipay.apmobilesecuritysdk.c.a.a(str);
                                    if (c4.a.d(a(this.f6809a, c10))) {
                                        i10 = 4;
                                    }
                                } else {
                                    i10 = 1;
                                }
                                this.f6811c = i10;
                                c11 = h4.d.c(this.f6809a, this.f6810b.c());
                                context = this.f6809a;
                                networkInfo = null;
                                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                if (connectivityManager != null) {
                                    networkInfo = connectivityManager.getActiveNetworkInfo();
                                }
                                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1) {
                                    z10 = true;
                                }
                                if (z10 && h.c(context)) {
                                    new g4.b(context.getFilesDir().getAbsolutePath() + "/log/ap", c11).b();
                                }
                                return this.f6811c;
                            }
                            h.a(this.f6809a, b10.b());
                            h.d(this.f6809a, b10.a());
                            h.e(this.f6809a, b10.f28069g);
                            h.a(this.f6809a, b10.f28070h);
                            h.f(this.f6809a, b10.f28071i);
                            h.g(this.f6809a, b10.f28073k);
                            i.c(e.b(this.f6809a, map));
                            i.a(c10, b10.f28066d);
                            i.b(b10.f28065c);
                            i.d(b10.f28072j);
                            String c15 = c4.a.c(map, "tid", "");
                            if (!c4.a.g(c15) || c4.a.e(c15, i.d())) {
                                c15 = i.d();
                            } else {
                                i.e(c15);
                            }
                            i.e(c15);
                            String c16 = c4.a.c(map, "utdid", "");
                            if (!c4.a.g(c16) || c4.a.e(c16, i.e())) {
                                c16 = i.e();
                            } else {
                                i.f(c16);
                            }
                            i.f(c16);
                            i.a();
                            com.alipay.apmobilesecuritysdk.e.d.a(this.f6809a, i.g());
                            com.alipay.apmobilesecuritysdk.e.d.a();
                            com.alipay.apmobilesecuritysdk.e.a.a(this.f6809a, new b(i.b(), i.c(), i.f()));
                            com.alipay.apmobilesecuritysdk.e.a.a();
                            g.a(this.f6809a, c10, i.a(c10));
                            g.a();
                            h.a(this.f6809a, c10, System.currentTimeMillis());
                        }
                        i10 = 0;
                        this.f6811c = i10;
                        c11 = h4.d.c(this.f6809a, this.f6810b.c());
                        context = this.f6809a;
                        networkInfo = null;
                        connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager != null) {
                        }
                        if (networkInfo != null) {
                            z10 = true;
                        }
                        if (z10) {
                            new g4.b(context.getFilesDir().getAbsolutePath() + "/log/ap", c11).b();
                        }
                        return this.f6811c;
                    }
                }
            }
            z11 = true;
            Context context22 = this.f6809a;
            e4.b.d();
            h.b(context22, String.valueOf(e4.b.B()));
            if (z11) {
            }
            i10 = 0;
            this.f6811c = i10;
            c11 = h4.d.c(this.f6809a, this.f6810b.c());
            context = this.f6809a;
            networkInfo = null;
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
            }
            if (networkInfo != null) {
            }
            if (z10) {
            }
            return this.f6811c;
        }
        if (!c4.a.d(a(this.f6809a, c10))) {
        }
        z11 = true;
        Context context222 = this.f6809a;
        e4.b.d();
        h.b(context222, String.valueOf(e4.b.B()));
        if (z11) {
        }
        i10 = 0;
        this.f6811c = i10;
        c11 = h4.d.c(this.f6809a, this.f6810b.c());
        context = this.f6809a;
        networkInfo = null;
        connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
        }
        if (networkInfo != null) {
        }
        if (z10) {
        }
        return this.f6811c;
    }
}
