package com.mobvoi.health.companion.system;

import com.mobvoi.health.companion.system.b;
import com.mobvoi.wear.common.base.WearPath;
import fg.h;
/* compiled from: HealthModuleBridge.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f19017c = new c();

    /* renamed from: a  reason: collision with root package name */
    private a f19018a;

    /* renamed from: b  reason: collision with root package name */
    private b.c f19019b;

    private c() {
    }

    public static a a() {
        return c().f19018a;
    }

    public static c c() {
        return f19017c;
    }

    public void b() {
        this.f19018a.h(WearPath.Health.HEALTH, this.f19019b);
        this.f19019b = null;
        this.f19018a = null;
    }

    public void d(a aVar) {
        this.f19018a = aVar;
        h hVar = new h();
        this.f19019b = hVar;
        aVar.q(WearPath.Health.HEALTH, hVar);
    }
}
