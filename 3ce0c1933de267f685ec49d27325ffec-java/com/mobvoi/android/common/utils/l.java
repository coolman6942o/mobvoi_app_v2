package com.mobvoi.android.common.utils;

import android.os.Handler;
import android.os.Looper;
/* compiled from: MainHandler.java */
/* loaded from: classes2.dex */
public class l extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static volatile l f15454a;

    private l() {
        super(Looper.getMainLooper());
    }

    public static l a() {
        if (f15454a == null) {
            synchronized (l.class) {
                if (f15454a == null) {
                    f15454a = new l();
                }
            }
        }
        return f15454a;
    }
}
