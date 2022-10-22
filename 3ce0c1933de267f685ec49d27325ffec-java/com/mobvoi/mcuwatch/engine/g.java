package com.mobvoi.mcuwatch.engine;

import kotlin.jvm.internal.i;
/* compiled from: NotificationMessageManager.kt */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f19158a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19159b;

    /* renamed from: c  reason: collision with root package name */
    private final int f19160c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19161d;

    public g(String msgTitle, String msgObject, int i10, int i11) {
        i.f(msgTitle, "msgTitle");
        i.f(msgObject, "msgObject");
        this.f19158a = msgTitle;
        this.f19159b = msgObject;
        this.f19160c = i10;
        this.f19161d = i11;
    }

    public final int a() {
        return this.f19161d;
    }

    public final int b() {
        return this.f19160c;
    }

    public final String c() {
        return this.f19159b;
    }

    public final String d() {
        return this.f19158a;
    }
}
