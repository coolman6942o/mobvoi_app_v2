package ip;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Task.kt */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private d f29307a;

    /* renamed from: b  reason: collision with root package name */
    private long f29308b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29309c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f29310d;

    public a(String name, boolean z10) {
        i.f(name, "name");
        this.f29309c = name;
        this.f29310d = z10;
        this.f29308b = -1L;
    }

    public final boolean a() {
        return this.f29310d;
    }

    public final String b() {
        return this.f29309c;
    }

    public final long c() {
        return this.f29308b;
    }

    public final d d() {
        return this.f29307a;
    }

    public final void e(d queue) {
        i.f(queue, "queue");
        d dVar = this.f29307a;
        if (dVar != queue) {
            if (dVar == null) {
                this.f29307a = queue;
                return;
            }
            throw new IllegalStateException("task is in multiple queues".toString());
        }
    }

    public abstract long f();

    public final void g(long j10) {
        this.f29308b = j10;
    }

    public String toString() {
        return this.f29309c;
    }

    public /* synthetic */ a(String str, boolean z10, int i10, f fVar) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}
