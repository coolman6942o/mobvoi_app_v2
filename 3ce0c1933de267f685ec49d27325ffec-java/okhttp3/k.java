package okhttp3;

import ip.e;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.i;
import okhttp3.internal.connection.h;
/* compiled from: ConnectionPool.kt */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final h f32222a;

    public k(h delegate) {
        i.f(delegate, "delegate");
        this.f32222a = delegate;
    }

    public final h a() {
        return this.f32222a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(int i10, long j10, TimeUnit timeUnit) {
        this(new h(e.f29318h, i10, j10, timeUnit));
        i.f(timeUnit, "timeUnit");
    }

    public k() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
