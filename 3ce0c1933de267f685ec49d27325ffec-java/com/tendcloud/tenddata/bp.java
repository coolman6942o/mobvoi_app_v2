package com.tendcloud.tenddata;

import android.content.Context;
import java.lang.reflect.Proxy;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class bp {
    public static boolean a() {
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void reflectMSA(Context context) {
        try {
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            Class<?> cls2 = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
            cls.getMethod("InitSdk", Context.class, Boolean.TYPE, cls2).invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new bj()));
        } catch (Throwable unused) {
            ba.f22720a.countDown();
        }
    }
}
