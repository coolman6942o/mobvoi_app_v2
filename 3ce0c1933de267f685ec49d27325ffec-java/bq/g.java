package bq;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import rx.f;
import rx.internal.schedulers.a;
import rx.internal.schedulers.b;
import rx.internal.schedulers.c;
import rx.internal.util.RxThreadFactory;
/* compiled from: RxJavaSchedulersHook.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final g f5533a = new g();

    public static f a() {
        return b(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static f b(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory == null");
        return new b(threadFactory);
    }

    public static f c() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static f d(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory == null");
        return new a(threadFactory);
    }

    public static f e() {
        return f(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static f f(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory == null");
        return new c(threadFactory);
    }

    public static g h() {
        return f5533a;
    }

    public f g() {
        return null;
    }

    public f i() {
        return null;
    }

    public f j() {
        return null;
    }

    @Deprecated
    public yp.a k(yp.a aVar) {
        return aVar;
    }
}
