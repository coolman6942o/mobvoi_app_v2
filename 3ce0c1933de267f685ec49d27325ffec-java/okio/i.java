package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* compiled from: ForwardingTimeout.kt */
/* loaded from: classes3.dex */
public class i extends u {

    /* renamed from: e  reason: collision with root package name */
    private u f32401e;

    public i(u delegate) {
        kotlin.jvm.internal.i.f(delegate, "delegate");
        this.f32401e = delegate;
    }

    @Override // okio.u
    public u a() {
        return this.f32401e.a();
    }

    @Override // okio.u
    public u b() {
        return this.f32401e.b();
    }

    @Override // okio.u
    public long c() {
        return this.f32401e.c();
    }

    @Override // okio.u
    public u d(long j10) {
        return this.f32401e.d(j10);
    }

    @Override // okio.u
    public boolean e() {
        return this.f32401e.e();
    }

    @Override // okio.u
    public void f() throws IOException {
        this.f32401e.f();
    }

    @Override // okio.u
    public u g(long j10, TimeUnit unit) {
        kotlin.jvm.internal.i.f(unit, "unit");
        return this.f32401e.g(j10, unit);
    }

    public final u i() {
        return this.f32401e;
    }

    public final i j(u delegate) {
        kotlin.jvm.internal.i.f(delegate, "delegate");
        this.f32401e = delegate;
        return this;
    }
}
