package ah;

import com.mobvoi.health.companion.system.b;
import com.mobvoi.wear.common.base.WearPath;
import xg.a;
/* compiled from: SportModuleBridge.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f212c = new c();

    /* renamed from: a  reason: collision with root package name */
    private b f213a;

    /* renamed from: b  reason: collision with root package name */
    private b.c f214b;

    private c() {
    }

    public static b a() {
        return c().f213a;
    }

    public static c c() {
        return f212c;
    }

    public void b() {
        this.f213a.h(WearPath.Sports.SPORTS, this.f214b);
        this.f214b = null;
        this.f213a = null;
    }

    public void d(b bVar) {
        this.f213a = bVar;
        a aVar = new a();
        this.f214b = aVar;
        bVar.q(WearPath.Sports.SPORTS, aVar);
    }
}
