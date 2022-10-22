package com.paypal.android.sdk;

import android.content.Context;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public final class o2 {

    /* renamed from: a  reason: collision with root package name */
    private static v1 f21483a;

    public static final synchronized String b(ExecutorService executorService, Context context, String str, String str2, String str3) {
        synchronized (o2.class) {
            v1 v1Var = f21483a;
            if (v1Var == null) {
                f21483a = new v1();
                String a10 = f21483a.a(context, str, str2, Collections.emptyMap());
                executorService.submit(new h3());
                f21483a.d();
                return a10;
            }
            return v1Var.c();
        }
    }
}
