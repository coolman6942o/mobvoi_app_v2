package ua;

import rx.f;
import xp.a;
/* compiled from: SchedulerProvider.java */
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f35361a;

    private b() {
    }

    public static synchronized b c() {
        b bVar;
        synchronized (b.class) {
            if (f35361a == null) {
                f35361a = new b();
            }
            bVar = f35361a;
        }
        return bVar;
    }

    @Override // ua.a
    public f a() {
        return a.b();
    }

    @Override // ua.a
    public f b() {
        return cq.a.c();
    }
}
