package yo;

import android.os.Handler;
import android.os.Looper;
import io.m;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.t0;
/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
public final class a extends b {
    private volatile a _immediate;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f37145b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37146c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f37147d;

    /* renamed from: e  reason: collision with root package name */
    private final a f37148e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private a(Handler handler, String str, boolean z10) {
        super(null);
        a aVar = null;
        this.f37145b = handler;
        this.f37146c = str;
        this.f37147d = z10;
        this._immediate = z10 ? this : aVar;
        a aVar2 = this._immediate;
        if (aVar2 == null) {
            aVar2 = new a(handler, str, true);
            this._immediate = aVar2;
            m mVar = m.f28349a;
        }
        this.f37148e = aVar2;
    }

    private final void h0(f fVar, Runnable runnable) {
        m1.c(fVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        t0.b().Q(fVar, runnable);
    }

    @Override // kotlinx.coroutines.g0
    public void Q(f fVar, Runnable runnable) {
        if (!this.f37145b.post(runnable)) {
            h0(fVar, runnable);
        }
    }

    @Override // kotlinx.coroutines.g0
    public boolean V(f fVar) {
        return !this.f37147d || !i.b(Looper.myLooper(), this.f37145b.getLooper());
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f37145b == this.f37145b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f37145b);
    }

    /* renamed from: i0 */
    public a W() {
        return this.f37148e;
    }

    @Override // kotlinx.coroutines.s1, kotlinx.coroutines.g0
    public String toString() {
        String g02 = g0();
        if (g02 != null) {
            return g02;
        }
        String str = this.f37146c;
        if (str == null) {
            str = this.f37145b.toString();
        }
        return this.f37147d ? i.n(str, ".immediate") : str;
    }

    public /* synthetic */ a(Handler handler, String str, int i10, kotlin.jvm.internal.f fVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public a(Handler handler, String str) {
        this(handler, str, false);
    }
}
