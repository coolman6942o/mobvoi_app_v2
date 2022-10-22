package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.i;
import rp.c;
import rp.g;
import rp.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final class q implements r {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f32419a;

    /* renamed from: b  reason: collision with root package name */
    private final u f32420b;

    public q(OutputStream out, u timeout) {
        i.f(out, "out");
        i.f(timeout, "timeout");
        this.f32419a = out;
        this.f32420b = timeout;
    }

    @Override // okio.r
    public void Z(c source, long j10) {
        i.f(source, "source");
        c.b(source.i0(), 0L, j10);
        while (j10 > 0) {
            this.f32420b.f();
            g gVar = source.f32393a;
            i.d(gVar);
            int min = (int) Math.min(j10, gVar.f33665c - gVar.f33664b);
            this.f32419a.write(gVar.f33663a, gVar.f33664b, min);
            gVar.f33664b += min;
            long j11 = min;
            j10 -= j11;
            source.h0(source.i0() - j11);
            if (gVar.f33664b == gVar.f33665c) {
                source.f32393a = gVar.b();
                h.b(gVar);
            }
        }
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f32419a.close();
    }

    @Override // okio.r, java.io.Flushable
    public void flush() {
        this.f32419a.flush();
    }

    @Override // okio.r
    public u timeout() {
        return this.f32420b;
    }

    public String toString() {
        return "sink(" + this.f32419a + ')';
    }
}
