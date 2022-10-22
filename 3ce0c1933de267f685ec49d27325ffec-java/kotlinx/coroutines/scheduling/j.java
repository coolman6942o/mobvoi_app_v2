package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.o0;
/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public final class j extends h {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f30324c;

    public j(Runnable runnable, long j10, i iVar) {
        super(j10, iVar);
        this.f30324c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f30324c.run();
        } finally {
            this.f30323b.n();
        }
    }

    public String toString() {
        return "Task[" + o0.a(this.f30324c) + '@' + o0.b(this.f30324c) + ", " + this.f30322a + ", " + this.f30323b + ']';
    }
}
