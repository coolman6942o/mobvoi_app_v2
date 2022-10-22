package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f6836a = new b();

    /* renamed from: b  reason: collision with root package name */
    public Thread f6837b = null;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<Runnable> f6838c = new LinkedList<>();

    public static b a() {
        return f6836a;
    }

    public final synchronized void a(Runnable runnable) {
        this.f6838c.add(runnable);
        if (this.f6837b == null) {
            Thread thread = new Thread(new c(this));
            this.f6837b = thread;
            thread.start();
        }
    }
}
