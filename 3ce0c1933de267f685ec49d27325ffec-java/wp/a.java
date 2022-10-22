package wp;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final a f36343b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<b> f36344a = new AtomicReference<>();

    a() {
    }

    public static a a() {
        return f36343b;
    }

    public b b() {
        if (this.f36344a.get() == null) {
            this.f36344a.compareAndSet(null, b.a());
        }
        return this.f36344a.get();
    }
}
