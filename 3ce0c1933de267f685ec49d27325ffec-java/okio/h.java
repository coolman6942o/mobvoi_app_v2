package okio;

import java.io.IOException;
import kotlin.jvm.internal.i;
/* compiled from: ForwardingSource.kt */
/* loaded from: classes3.dex */
public abstract class h implements t {
    private final t delegate;

    public h(t delegate) {
        i.f(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final t m41deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final t delegate() {
        return this.delegate;
    }

    @Override // okio.t
    public long read(c sink, long j10) throws IOException {
        i.f(sink, "sink");
        return this.delegate.read(sink, j10);
    }

    @Override // okio.t
    public u timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
