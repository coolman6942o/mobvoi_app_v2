package com.amap.api.mapcore2d;

import android.content.Context;
import java.util.Date;
import k4.b;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class s {
    public static String a() {
        return g.b(new Date().getTime());
    }

    public static String b(Context context, f fVar) {
        StringBuilder sb2 = new StringBuilder();
        try {
            String f10 = b.f(context);
            sb2.append("\"sim\":\"");
            sb2.append(f10);
            sb2.append("\",\"sdkversion\":\"");
            sb2.append(fVar.d());
            sb2.append("\",\"product\":\"");
            sb2.append(fVar.a());
            sb2.append("\",\"ed\":\"");
            sb2.append(fVar.e());
            sb2.append("\",\"nt\":\"");
            sb2.append(b.d(context));
            sb2.append("\",\"np\":\"");
            sb2.append(b.a(context));
            sb2.append("\",\"mnc\":\"");
            sb2.append(b.c(context));
            sb2.append("\",\"ant\":\"");
            sb2.append(b.e(context));
            sb2.append("\"");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return sb2.toString();
    }

    public static String c(String str, String str2, String str3, int i10, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(",");
        stringBuffer.append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i10);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}
