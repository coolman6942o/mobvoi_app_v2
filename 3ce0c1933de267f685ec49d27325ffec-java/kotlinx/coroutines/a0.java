package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.f;
/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30115b = AtomicIntegerFieldUpdater.newUpdater(a0.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f30116a;

    public a0(Throwable th2, boolean z10) {
        this.f30116a = th2;
        this._handled = z10 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f30115b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return o0.a(this) + '[' + this.f30116a + ']';
    }

    public /* synthetic */ a0(Throwable th2, boolean z10, int i10, f fVar) {
        this(th2, (i10 & 2) != 0 ? false : z10);
    }
}
