package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public class u {

    /* renamed from: d  reason: collision with root package name */
    public static final u f32422d = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f32423a;

    /* renamed from: b  reason: collision with root package name */
    private long f32424b;

    /* renamed from: c  reason: collision with root package name */
    private long f32425c;

    /* compiled from: Timeout.kt */
    /* loaded from: classes3.dex */
    public static final class a extends u {
        a() {
        }

        @Override // okio.u
        public u d(long j10) {
            return this;
        }

        @Override // okio.u
        public void f() {
        }

        @Override // okio.u
        public u g(long j10, TimeUnit unit) {
            i.f(unit, "unit");
            return this;
        }
    }

    /* compiled from: Timeout.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    static {
        new b(null);
    }

    public u a() {
        this.f32423a = false;
        return this;
    }

    public u b() {
        this.f32425c = 0L;
        return this;
    }

    public long c() {
        if (this.f32423a) {
            return this.f32424b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public u d(long j10) {
        this.f32423a = true;
        this.f32424b = j10;
        return this;
    }

    public boolean e() {
        return this.f32423a;
    }

    public void f() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f32423a && this.f32424b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public u g(long j10, TimeUnit unit) {
        i.f(unit, "unit");
        if (j10 >= 0) {
            this.f32425c = unit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j10).toString());
    }

    public long h() {
        return this.f32425c;
    }
}
