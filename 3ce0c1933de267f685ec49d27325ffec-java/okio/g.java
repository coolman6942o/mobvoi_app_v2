package okio;

import java.io.IOException;
import kotlin.jvm.internal.i;
/* compiled from: ForwardingSink.kt */
/* loaded from: classes3.dex */
public abstract class g implements r {

    /* renamed from: a  reason: collision with root package name */
    private final r f32400a;

    public g(r delegate) {
        i.f(delegate, "delegate");
        this.f32400a = delegate;
    }

    @Override // okio.r
    public void Z(c source, long j10) throws IOException {
        i.f(source, "source");
        this.f32400a.Z(source, j10);
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32400a.close();
    }

    @Override // okio.r, java.io.Flushable
    public void flush() throws IOException {
        this.f32400a.flush();
    }

    @Override // okio.r
    public u timeout() {
        return this.f32400a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f32400a + ')';
    }
}
