package okio;

import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Okio.kt */
/* loaded from: classes3.dex */
public final class b implements r {
    @Override // okio.r
    public void Z(c source, long j10) {
        i.f(source, "source");
        source.f(j10);
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.r, java.io.Flushable
    public void flush() {
    }

    @Override // okio.r
    public u timeout() {
        return u.f32422d;
    }
}
