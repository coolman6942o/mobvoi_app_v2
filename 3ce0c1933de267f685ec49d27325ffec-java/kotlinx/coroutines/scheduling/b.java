package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.f;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.p0;
/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public class b extends b1 {

    /* renamed from: b  reason: collision with root package name */
    private final int f30308b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30309c;

    /* renamed from: d  reason: collision with root package name */
    private final long f30310d;

    /* renamed from: e  reason: collision with root package name */
    private final String f30311e;

    /* renamed from: f  reason: collision with root package name */
    private CoroutineScheduler f30312f;

    public b(int i10, int i11, long j10, String str) {
        this.f30308b = i10;
        this.f30309c = i11;
        this.f30310d = j10;
        this.f30311e = str;
        this.f30312f = W();
    }

    private final CoroutineScheduler W() {
        return new CoroutineScheduler(this.f30308b, this.f30309c, this.f30310d, this.f30311e);
    }

    @Override // kotlinx.coroutines.g0
    public void Q(f fVar, Runnable runnable) {
        try {
            CoroutineScheduler.o(this.f30312f, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            p0.f30264g.Q(fVar, runnable);
        }
    }

    @Override // kotlinx.coroutines.g0
    public void T(f fVar, Runnable runnable) {
        try {
            CoroutineScheduler.o(this.f30312f, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            p0.f30264g.T(fVar, runnable);
        }
    }

    public final void g0(Runnable runnable, i iVar, boolean z10) {
        try {
            this.f30312f.n(runnable, iVar, z10);
        } catch (RejectedExecutionException unused) {
            p0.f30264g.K0(this.f30312f.h(runnable, iVar));
        }
    }

    public /* synthetic */ b(int i10, int i11, String str, int i12, kotlin.jvm.internal.f fVar) {
        this((i12 & 1) != 0 ? k.f30326b : i10, (i12 & 2) != 0 ? k.f30327c : i11, (i12 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public b(int i10, int i11, String str) {
        this(i10, i11, k.f30328d, str);
    }
}
