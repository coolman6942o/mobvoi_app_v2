package com.tendcloud.tenddata;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bj implements InvocationHandler {
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            try {
                co.a().setOAID((String) objArr[1].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            co.a().setOAID((String) objArr[0].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]));
        }
        try {
            try {
                String str = (String) objArr[1].getClass().getMethod("getVAID", new Class[0]).invoke(objArr[1], new Object[0]);
                co a10 = co.a();
                if (u.b(str)) {
                    str = null;
                }
                a10.setVAID(str);
            } catch (Throwable unused3) {
                String str2 = (String) objArr[0].getClass().getMethod("getVAID", new Class[0]).invoke(objArr[0], new Object[0]);
                co a11 = co.a();
                if (u.b(str2)) {
                    str2 = null;
                }
                a11.setVAID(str2);
            }
        } catch (Throwable unused4) {
        }
        try {
            try {
                String str3 = (String) objArr[1].getClass().getMethod("getAAID", new Class[0]).invoke(objArr[1], new Object[0]);
                co a12 = co.a();
                if (u.b(str3)) {
                    str3 = null;
                }
                a12.setAAID(str3);
            } catch (Throwable unused5) {
                String str4 = (String) objArr[0].getClass().getMethod("getAAID", new Class[0]).invoke(objArr[0], new Object[0]);
                co a13 = co.a();
                if (u.b(str4)) {
                    str4 = null;
                }
                a13.setAAID(str4);
            }
        } catch (Throwable unused6) {
        }
        ba.f22720a.countDown();
        return null;
    }
}
