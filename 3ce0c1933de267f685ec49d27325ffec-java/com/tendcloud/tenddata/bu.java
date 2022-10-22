package com.tendcloud.tenddata;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bu {
    public static boolean a() {
        String a10;
        try {
            if (bk.f() && (a10 = a("persist.sys.identifierid.supported", "0")) != null) {
                return a10.equals("1");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void reflectVIVO(Context context) {
        try {
            co.a().setOAID(a("oaid", null, context));
        } catch (Throwable unused) {
        }
        try {
            co.a().setVAID(a("vaid", null, context));
        } catch (Throwable unused2) {
        }
        try {
            co.a().setAAID(a("aaid", null, context));
        } catch (Throwable unused3) {
        }
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r0 == 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
        if (r0 == 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
        r8 = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        r8 = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(String str, String str2, Context context) {
        char c10 = 65535;
        String str3 = null;
        try {
            int hashCode = str.hashCode();
            if (hashCode != 2986299) {
                if (hashCode != 3403373) {
                    if (hashCode == 3611910 && str.equals("vaid")) {
                        c10 = 1;
                    }
                } else if (str.equals("oaid")) {
                    c10 = 0;
                }
            } else if (str.equals("aaid")) {
                c10 = 2;
            }
            Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
            Uri uri2 = uri;
            Cursor query = context.getContentResolver().query(uri2, null, null, null, null);
            if (query != null) {
                if (query.moveToNext()) {
                    str3 = query.getString(query.getColumnIndex(HealthDataProviderContracts.NAME_VALUE));
                }
                query.close();
            }
        } catch (Throwable unused) {
        }
        return str3;
    }
}
