package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.i;
import rp.g;
import rp.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final class m implements t {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f32416a;

    /* renamed from: b  reason: collision with root package name */
    private final u f32417b;

    public m(InputStream input, u timeout) {
        i.f(input, "input");
        i.f(timeout, "timeout");
        this.f32416a = input;
        this.f32417b = timeout;
    }

    @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f32416a.close();
    }

    @Override // okio.t
    public long read(c sink, long j10) {
        i.f(sink, "sink");
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 == 0) {
            return 0L;
        }
        if (i10 >= 0) {
            try {
                this.f32417b.f();
                g m02 = sink.m0(1);
                int read = this.f32416a.read(m02.f33663a, m02.f33665c, (int) Math.min(j10, 8192 - m02.f33665c));
                if (read != -1) {
                    m02.f33665c += read;
                    long j11 = read;
                    sink.h0(sink.i0() + j11);
                    return j11;
                } else if (m02.f33664b != m02.f33665c) {
                    return -1L;
                } else {
                    sink.f32393a = m02.b();
                    h.b(m02);
                    return -1L;
                }
            } catch (AssertionError e10) {
                if (n.e(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
    }

    @Override // okio.t
    public u timeout() {
        return this.f32417b;
    }

    public String toString() {
        return "source(" + this.f32416a + ')';
    }
}
