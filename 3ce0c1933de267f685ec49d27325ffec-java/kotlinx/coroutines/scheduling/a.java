package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.g0;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.internal.z;
import vo.f;
/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public final class a extends b {

    /* renamed from: g  reason: collision with root package name */
    public static final a f30306g;

    /* renamed from: h  reason: collision with root package name */
    private static final g0 f30307h;

    static {
        int c10;
        int d10;
        a aVar = new a();
        f30306g = aVar;
        c10 = f.c(64, x.a());
        d10 = z.d("kotlinx.coroutines.io.parallelism", c10, 0, 0, 12, null);
        f30307h = new d(aVar, d10, "Dispatchers.IO", 1);
    }

    private a() {
        super(0, 0, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public final g0 h0() {
        return f30307h;
    }

    @Override // kotlinx.coroutines.g0
    public String toString() {
        return "Dispatchers.Default";
    }
}
