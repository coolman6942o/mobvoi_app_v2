package com.alipay.sdk.app;

import a4.d;
import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class OpenAuthTask {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, a> f6871a = new ConcurrentHashMap();

    /* loaded from: classes.dex */
    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");
        
        public String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(int i10, String str, Bundle bundle);
    }

    public static void a(String str, int i10, String str2, Bundle bundle) {
        a remove = f6871a.remove(str);
        if (remove != null) {
            try {
                remove.a(i10, str2, bundle);
            } catch (Throwable th2) {
                d.d(th2);
            }
        }
    }
}
