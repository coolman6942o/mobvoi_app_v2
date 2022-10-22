package com.amap.api.services.a;

import android.content.Context;
import java.util.Date;
import n4.a;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class r {
    public static String a() {
        return f.b(new Date().getTime());
    }

    public static String b(Context context, e eVar) {
        StringBuilder sb2 = new StringBuilder();
        try {
            String g10 = a.g(context);
            sb2.append("\"sim\":\"");
            sb2.append(g10);
            sb2.append("\",\"sdkversion\":\"");
            sb2.append(eVar.d());
            sb2.append("\",\"product\":\"");
            sb2.append(eVar.a());
            sb2.append("\",\"ed\":\"");
            sb2.append(eVar.e());
            sb2.append("\",\"nt\":\"");
            sb2.append(a.e(context));
            sb2.append("\",\"np\":\"");
            sb2.append(a.b(context));
            sb2.append("\",\"mnc\":\"");
            sb2.append(a.d(context));
            sb2.append("\",\"ant\":\"");
            sb2.append(a.f(context));
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
