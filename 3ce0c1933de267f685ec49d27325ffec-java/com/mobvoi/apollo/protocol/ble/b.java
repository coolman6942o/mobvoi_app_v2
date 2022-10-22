package com.mobvoi.apollo.protocol.ble;

import android.os.Handler;
import android.os.HandlerThread;
import io.d;
import io.f;
import kotlin.jvm.internal.Lambda;
/* compiled from: BleConfigs.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f15583a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f15584b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f15585c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f15586d;

    /* renamed from: e  reason: collision with root package name */
    private static final d f15587e;

    /* compiled from: BleConfigs.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<Handler> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Handler invoke() {
            HandlerThread handlerThread = new HandlerThread("BleOp");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    }

    static {
        d a10;
        a10 = f.a(a.INSTANCE);
        f15587e = a10;
    }

    private b() {
    }

    public final boolean a() {
        return f15585c;
    }

    public final Handler b() {
        return (Handler) f15587e.getValue();
    }

    public final boolean c() {
        return f15584b;
    }

    public final boolean d() {
        return f15586d;
    }
}
