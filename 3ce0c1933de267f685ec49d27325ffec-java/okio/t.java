package okio;

import java.io.Closeable;
import java.io.IOException;
/* compiled from: Source.kt */
/* loaded from: classes3.dex */
public interface t extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(c cVar, long j10) throws IOException;

    u timeout();
}
