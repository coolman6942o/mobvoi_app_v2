package com.mobvoi.android.common.ipc;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* compiled from: IpcHandler.java */
/* loaded from: classes2.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f15277a;

    private b() {
        super(a());
    }

    private static Looper a() {
        HandlerThread handlerThread = new HandlerThread("IpcHandler");
        handlerThread.start();
        return handlerThread.getLooper();
    }

    public static b b() {
        if (f15277a == null) {
            synchronized (b.class) {
                if (f15277a == null) {
                    f15277a = new b();
                }
            }
        }
        return f15277a;
    }
}
