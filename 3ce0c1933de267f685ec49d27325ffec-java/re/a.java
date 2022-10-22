package re;

import rx.f;
/* compiled from: SchedulerProvider.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f33501a;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f33501a == null) {
                f33501a = new a();
            }
            aVar = f33501a;
        }
        return aVar;
    }

    public f b() {
        return cq.a.c();
    }

    public f c() {
        return xp.a.b();
    }
}
