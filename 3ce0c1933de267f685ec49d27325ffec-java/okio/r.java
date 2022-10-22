package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
/* compiled from: Sink.kt */
/* loaded from: classes3.dex */
public interface r extends Closeable, Flushable {
    void Z(c cVar, long j10) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    u timeout();
}
