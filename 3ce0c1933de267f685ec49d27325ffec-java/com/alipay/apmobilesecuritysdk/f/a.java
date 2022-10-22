package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import d4.c;
import f4.b;
import f4.e;
import java.util.HashMap;
import org.json.JSONObject;
/*  JADX ERROR: NullPointerException in pass: ProcessKotlinInternals
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.kotlin.ProcessKotlinInternals.processMth(ProcessKotlinInternals.java:92)
    	at jadx.core.dex.visitors.kotlin.ProcessKotlinInternals.visit(ProcessKotlinInternals.java:83)
    */
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String a10;
        if (context == null || c4.a.d(str)) {
            return null;
        }
        if (!c4.a.d(str2)) {
            try {
                a10 = e.a(context, str, str2, "");
                if (c4.a.d(a10)) {
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return c.e(c.a(), a10);
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (c4.a.d(str) || c4.a.d(str2)) {
                return null;
            }
            String a10 = b.a(str);
            if (c4.a.d(a10)) {
                return null;
            }
            String string = new JSONObject(a10).getString(str2);
            if (c4.a.d(string)) {
                return null;
            }
            return c.e(c.a(), string);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!c4.a.d(str) && !c4.a.d(str2) && context != null) {
            try {
                String b10 = c.b(c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, b10);
                e.b(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: AttachTryCatchVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Null type added to not empty exception handler: Exception -> 0x0072
        	at jadx.core.dex.trycatch.ExceptionHandler.addCatchType(ExceptionHandler.java:54)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.createHandler(AttachTryCatchVisitor.java:136)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.convertToHandlers(AttachTryCatchVisitor.java:123)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.initTryCatches(AttachTryCatchVisitor.java:59)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.visit(AttachTryCatchVisitor.java:47)
        */
    public static void a(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<com.alipay.apmobilesecuritysdk.f.a> r0 = com.alipay.apmobilesecuritysdk.f.a.class
            monitor-enter(r0)
            c4.a.d(r4)     // Catch: java.lang.Throwable -> L76
            r1 = move-result     // Catch: java.lang.Throwable -> L76
            if (r1 != 0) goto L74     // Catch: java.lang.Throwable -> L76
            c4.a.d(r5)     // Catch: java.lang.Throwable -> L76
            r1 = move-result     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L10
            goto L74
            f4.b.a(r4)     // Catch: java.lang.Exception -> L72
            r1 = move-result     // Catch: java.lang.Exception -> L72
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L72
            r2.<init>()     // Catch: java.lang.Exception -> L72
            c4.a.g(r1)     // Catch: java.lang.Exception -> L72
            r3 = move-result     // Catch: java.lang.Exception -> L72
            if (r3 == 0) goto L2a
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L25 java.lang.Exception -> L72
            r2.<init>(r1)     // Catch: java.lang.Exception -> L25 java.lang.Exception -> L72
            goto L2a
        L25:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L72
            r2.<init>()     // Catch: java.lang.Exception -> L72
            d4.c.a()     // Catch: java.lang.Exception -> L72
            r1 = move-result     // Catch: java.lang.Exception -> L72
            d4.c.b(r1, r6)     // Catch: java.lang.Exception -> L72
            r6 = move-result     // Catch: java.lang.Exception -> L72
            r2.put(r5, r6)     // Catch: java.lang.Exception -> L72
            r2.toString()     // Catch: java.lang.Exception -> L72
            java.lang.System.clearProperty(r4)     // Catch: java.lang.Throwable -> L3b
        L3b:
            f4.c.b()     // Catch: java.lang.Exception -> L72
            r5 = move-result     // Catch: java.lang.Exception -> L72
            if (r5 == 0) goto L72     // Catch: java.lang.Exception -> L72
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L72
            java.lang.String r6 = ".SystemConfig"     // Catch: java.lang.Exception -> L72
            r5.<init>(r6)     // Catch: java.lang.Exception -> L72
            java.lang.String r6 = java.io.File.separator     // Catch: java.lang.Exception -> L72
            r5.append(r6)     // Catch: java.lang.Exception -> L72
            r5.append(r4)     // Catch: java.lang.Exception -> L72
            r5.toString()     // Catch: java.lang.Exception -> L72
            r4 = move-result     // Catch: java.lang.Exception -> L72
            f4.c.b()
            r5 = move-result
            if (r5 == 0) goto L72
            java.io.File r5 = new java.io.File
            android.os.Environment.getExternalStorageDirectory()
            r6 = move-result
            r5.<init>(r6, r4)
            r5.exists()
            r4 = move-result
            if (r4 == 0) goto L72
            r5.isFile()
            r4 = move-result
            if (r4 == 0) goto L72
            r5.delete()
        L72:
            monitor-exit(r0)
            return
            monitor-exit(r0)
            return
        L76:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.f.a.a(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
